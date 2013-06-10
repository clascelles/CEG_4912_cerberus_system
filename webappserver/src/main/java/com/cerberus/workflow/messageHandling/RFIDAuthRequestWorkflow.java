package com.cerberus.workflow.messageHandling;

import org.apache.log4j.Logger;

import com.cerberus.message.Message;
import com.cerberus.message.RFIDAuthRequestMessage;
import com.cerberus.message.WrongMessageException;
import com.cerberus.persistence.beans.RfidAuthentication;
import com.cerberus.persistence.beans.RfidTag;
import com.cerberus.persistence.beans.Socket;
import com.cerberus.persistence.beans.User;
import com.cerberus.service.pool.ServiceFactory;

public class RFIDAuthRequestWorkflow extends MessageWorkflow{

	// Get Logger
	private final static Logger LOGGER = Logger.getLogger(RFIDAuthRequestWorkflow.class);

	private final ServiceFactory serviceFactory;

	public RFIDAuthRequestWorkflow() {
		serviceFactory = borrowServiceFactory();
		LOGGER.info("[CurrentWorkflow]: Initializing. Borrowing Service Factory from ObjectPool");
	}

	@Override
	public boolean handleReceivedMessage(Message receivedMessage) throws WrongMessageException {

		// Create new Current data structure
		RFIDAuthRequestMessage requestMessage;
		if (receivedMessage instanceof RFIDAuthRequestMessage) {
			requestMessage = (RFIDAuthRequestMessage) receivedMessage;
		} else {
			throw new WrongMessageException("Wrong message processed by the RFIDAuthRequestWorkflow, "
					+ "should've been a RFIDAuthRequestMessage, but instead was: " + receivedMessage.getClass());
		}

		Socket socket = serviceFactory.getOutletService().getSocketBySerialNumber(receivedMessage.getSocketId());
		User user = serviceFactory.getUserService().getUserBySocketId(socket.getId());

		RfidTag rfidTag = serviceFactory.getRfidService().getRfidTagByNumber(requestMessage.getRfidNumber());

		RfidAuthentication auth = new RfidAuthentication(rfidTag.getId(), user);

		try {
			serviceFactory.getRfidService().insertRfidAuthentication(auth);
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean handleSendingMessage(Message sendingMessage) throws WrongMessageException {
		// TODO Auto-generated method stub
		return false;
	}

}
