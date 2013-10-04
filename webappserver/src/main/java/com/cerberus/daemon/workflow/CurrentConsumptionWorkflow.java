package com.cerberus.daemon.workflow;

import java.sql.Timestamp;

import org.apache.log4j.Logger;
import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;

import com.cerberus.daemon.message.CurrentConsumptionMessage;
import com.cerberus.daemon.message.Message;
import com.cerberus.daemon.message.WrongMessageException;
import com.cerberus.model.outlets.bean.Current;
import com.cerberus.model.outlets.bean.RfidTag;

public class CurrentConsumptionWorkflow extends MessageWorkflow {

	// Get Logger
	private final static Logger LOGGER = Logger.getLogger(CurrentConsumptionWorkflow.class);

	//private final ServiceFactory serviceFactory;

	public CurrentConsumptionWorkflow() {
		//serviceFactory = borrowServiceFactory();
		//LOGGER.info("[CurrentWorkflow]: Initializing. Borrowing Service Factory from ObjectPool");
	}

	@Override
	public boolean handleReceivedMessage(Message receivedMessage) throws WrongMessageException {

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

		current.setTimestamp(new Timestamp(receivedMessage.getTimestamp()*1000));
		current.setCurrent(currentMessage.getCurrent());

		// Set Socket
		current.setSocket(serviceFactory.getOutletService().getSocketBySerialNumber(receivedMessage.getOutletId()));

		// Set User
		current.setUser(serviceFactory.getUserService().getUserBySocketId(serviceFactory.getOutletService().getSocketBySerialNumber(receivedMessage.getOutletId()).getId()));

		// RFID is optional
		String rfidNumber = currentMessage.getRfidNumber();
		if (rfidNumber != null) {
			// Set RFID Number
			RfidTag tag = serviceFactory.getRfidService().getRfidTagByNumber(rfidNumber);
			current.setRfidTagId(tag);
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

	@Override
	public boolean handleSendingMessage(Message sendingMessage) throws WrongMessageException {
		// TODO Auto-generated method stub
		return false;
	}

}
