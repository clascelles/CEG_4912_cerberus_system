package com.cerberus.daemon.workflow;

import java.sql.Timestamp;

import org.apache.log4j.Logger;
import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;

import com.cerberus.daemon.message.CurrentConsumptionMessage;
import com.cerberus.daemon.message.Message;
import com.cerberus.daemon.message.WrongMessageException;
import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.account.bean.User;
import com.cerberus.model.outlets.bean.Current;
import com.cerberus.model.outlets.bean.Outlet;
import com.cerberus.model.outlets.bean.Socket;
import com.cerberus.model.security.bean.RfidAuthentication;
import com.cerberus.model.security.bean.RfidTag;
import com.cerberus.module.security.constants.RfidPermission;
import com.cerberus.module.system.constants.EventType;
import com.cerberus.service.account.UserService;
import com.cerberus.service.outlets.OutletService;
import com.cerberus.service.security.RfidService;
import com.cerberus.service.system.SystemService;

public class CurrentConsumptionWorkflow extends MessageWorkflow {

	// Get Logger
	private final static Logger LOGGER = Logger.getLogger(CurrentConsumptionWorkflow.class);

	public CurrentConsumptionWorkflow() {
		super(false);
	}

	@Override
	public boolean handleMessage(Message receivedMessage) throws WrongMessageException {

		OutletService outletService = serviceFactory.getOutletService();
		RfidService rfidService = serviceFactory.getRfidService();
		SystemService systemService = serviceFactory.getSystemService();
		UserService userService = serviceFactory.getUserService();

		StopWatch stopwatch = new Log4JStopWatch("CurrentWorkflow.handleReceivedMessage");

		// Create new Current data structure
		CurrentConsumptionMessage currentMessage;
		if (receivedMessage instanceof CurrentConsumptionMessage) {
			currentMessage = (CurrentConsumptionMessage) receivedMessage;
		} else {
			throw new WrongMessageException("Wrong message processed by the CurrentWorkflow, "
					+ "should've been a CurrentConsumptionMessage, but instead was: " + receivedMessage.getClass());
		}

		Current current = new Current();

		current.setTimestamp(new Timestamp(currentMessage.getTimestamp()*1000));
		current.setCurrent(currentMessage.getCurrent());

		// Get outlet
		Outlet outlet = outletService.getOutletBySerialNumber(currentMessage.getOutletSerialNumber());
		if (outlet == null) {
			// Ignore current message since the outlet is not set in the database
			return false;
		}

		// Set Socket
		Socket socket = outletService.getSocketFromOutlet(outlet.getId(), currentMessage.getSocket());

		// Current values will be tied to the socket
		if (socket != null) {
			current.setSocket(socket);
		} else {
			// TODO:Log error!
			return false;
		}

		// Set User
		//User user = userService.getUserBySocketId(socket.getId());

		// Current values will not be tied to users!
		// TODO: Refactor this (and database)
		current.setUser(null);

		// RFID is optional
		String rfidNumber = currentMessage.getRfidNumber();
		if (rfidNumber != null) {
			// Set RFID Number
			RfidTag tag = rfidService.getRfidTagByNumber(rfidNumber);
			if(tag != null) {
				current.setRfidTagId(tag);
			} else if(!rfidNumber.equals("0000000000")) {
				// New RFID detected!

				tag = new RfidTag(currentMessage.getRfidNumber(), "New RFID Tag", null);
				try {
					rfidService.insertRfidTag(tag);
					CerberusApplicationContext.getWorkflows().getEventWorkflow().logEvent(EventType.NEW_RFID_TAG, outlet.getId());
				} catch(Exception e) {
					LOGGER.error("Failed to insert new Rfid tag from rfid request message: " + currentMessage + "; Rfid Tag: " + tag);
					return false;
				}

				// Get system owner
				Integer systemId = outletService.getSystemIdFromOutlet(outlet.getId());
				User sysOwner = userService.getUserById(systemService.getSysOwnerOfSystem(systemId));

				// Rfid was never authenticated before
				// Get recently inserted RFID tag
				tag = rfidService.getRfidTagByNumber(currentMessage.getRfidNumber());
				RfidAuthentication auth = new RfidAuthentication(tag.getId(), sysOwner, RfidPermission.UNSET.getIntValue());
				try {
					rfidService.insertRfidAuthentication(auth);
				} catch(Exception e) {
					LOGGER.error("Failed to insert new Rfid authentication from rfid request message: " + currentMessage + "; Rfid Authentication: " + auth);
					return false;
				}
			}
		} else {
			current.setRfidTagId(null);
		}

		try {
			// Persist the Current object
			serviceFactory.getConsumptionService().insertCurrent(current);
			LOGGER.info("Persisted CURRENT!");

		} catch (Exception e) { // Catch if an exception occurs
			LOGGER.error("Exception caught while persisting a current object: ", e);
			return false;
		} finally {
			stopwatch.stop();
		}

		return true;
	}

}
