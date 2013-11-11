package com.cerberus.daemon.workflow;

import java.util.concurrent.ExecutorService;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import com.cerberus.daemon.executor.ExecutorServiceFactory;
import com.cerberus.daemon.message.Message;
import com.cerberus.daemon.message.MessageContainer;
import com.cerberus.daemon.message.RFIDAuthRequestMessage;
import com.cerberus.daemon.message.RFIDAuthResponseMessage;
import com.cerberus.daemon.message.WrongMessageException;
import com.cerberus.daemon.response.MessageResponse;
import com.cerberus.model.account.bean.User;
import com.cerberus.model.outlets.bean.Outlet;
import com.cerberus.model.security.bean.RfidAuthentication;
import com.cerberus.model.security.bean.RfidTag;
import com.cerberus.module.security.constants.RfidPermission;
import com.cerberus.service.account.UserService;
import com.cerberus.service.outlets.OutletService;
import com.cerberus.service.security.RfidService;
import com.cerberus.service.system.SystemService;

public class RFIDAuthMessageWorkflow extends MessageWorkflow {

	// Get Logger
	private final static Logger LOGGER = Logger.getLogger(RFIDAuthMessageWorkflow.class);

	public RFIDAuthMessageWorkflow() {
		super(false);
	}

	@Override
	public boolean handleMessage(Message receivedMessage) throws WrongMessageException {

		RfidService rfidService = serviceFactory.getRfidService();
		OutletService outletService = serviceFactory.getOutletService();
		UserService userService = serviceFactory.getUserService();
		SystemService systemService = serviceFactory.getSystemService();

		RFIDAuthRequestMessage requestMessage;
		if (receivedMessage instanceof RFIDAuthRequestMessage) {
			requestMessage = (RFIDAuthRequestMessage) receivedMessage;
		} else {
			throw new WrongMessageException("Wrong message processed by the RFIDAuthMessageWorkflow, "
					+ "should've been a RFIDAuthRequestMessage, but instead was: " + receivedMessage.getClass());
		}
		LOGGER.info("RFID Request being processed: " + requestMessage.toString());
		LOGGER.info("Request outlet ID: " + requestMessage.getOutletId());

		Outlet outlet = outletService.getOutletBySerialNumber(requestMessage.getOutletId());
		if(outlet == null) {
			// New outlet that wasn't added to the system, ignore message
			return false;
		}

		LOGGER.info("Outlet: " + outlet.toString());

		// RFID Tag are assigned to system owners for now (to be system-wide)
		Integer systemId = outletService.getSystemIdFromOutlet(outlet.getId());
		User sysOwner = userService.getUserById(systemService.getSysOwnerOfSystem(systemId));

		RfidTag rfidTag = rfidService.getRfidTagByNumber(requestMessage.getRfidNumber());

		if(rfidTag == null) {
			// New RFID Tag, create it and store it
			rfidTag = new RfidTag(requestMessage.getRfidNumber(), "New RFID Tag", null);
			try {
				rfidService.insertRfidTag(rfidTag);
			} catch(Exception e) {
				LOGGER.error("Failed to insert new Rfid tag from rfid request message: " + requestMessage + "; Rfid Tag: " + rfidTag);
				return false;
			}
		}

		RfidAuthentication auth = rfidService.getRfidAuthenticationByRfidTagId(rfidTag.getId());
		boolean isAllowed = false;

		if(auth == null) {
			// Rfid was never authenticated before
			auth = new RfidAuthentication(rfidTag.getId(), sysOwner, RfidPermission.UNSET.getIntValue());
			try {
				rfidService.insertRfidAuthentication(auth);
			} catch(Exception e) {
				LOGGER.error("Failed to insert new Rfid authentication from rfid request message: " + requestMessage + "; Rfid Authentication: " + auth);
				return false;
			}

		} else {
			// Check if RFID is allowed or not
			isAllowed = (auth.getPermission() == RfidPermission.ALLOWED.getIntValue());
		}

		// Send response back to client
		respondMessage(requestMessage.getOutletId(), requestMessage.getSocket(), rfidTag.getNumber(), isAllowed);

		return true;
	}

	private void respondMessage(String outletId, Integer socket, String rfidNumber, boolean isAuthorized) {

		DateTime dt = new DateTime();
		RFIDAuthResponseMessage response = new RFIDAuthResponseMessage(outletId, socket, dt.getMillis() / 1000, rfidNumber, isAuthorized);

		MessageContainer container = new MessageContainer(null, response);

		ExecutorService executor = ExecutorServiceFactory.getResponseLogicThreadPool();
		Runnable responseLogicTask = new MessageResponse(container);
		executor.execute(responseLogicTask);
	}

}
