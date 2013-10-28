package com.cerberus.daemon.workflow;

import org.apache.log4j.Logger;

import com.cerberus.daemon.message.Message;
import com.cerberus.daemon.message.RFIDAuthRequestMessage;
import com.cerberus.daemon.message.WrongMessageException;
import com.cerberus.model.account.bean.User;
import com.cerberus.model.outlets.bean.Socket;
import com.cerberus.model.security.bean.RfidAuthentication;
import com.cerberus.model.security.bean.RfidTag;
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
	public boolean handleMessage(Message receivedMessage) throws WrongMessageException {

		// Create new Current data structure
		RFIDAuthRequestMessage requestMessage;
		if (receivedMessage instanceof RFIDAuthRequestMessage) {
			requestMessage = (RFIDAuthRequestMessage) receivedMessage;
		} else {
			throw new WrongMessageException("Wrong message processed by the RFIDAuthRequestWorkflow, "
					+ "should've been a RFIDAuthRequestMessage, but instead was: " + receivedMessage.getClass());
		}

		Socket socket = serviceFactory.getOutletService().getSocketBySerialNumber(receivedMessage.getOutletId());
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

}
