package com.cerberus.server.workflow;

import org.apache.log4j.Logger;

import com.cerberus.server.message.RFIDAuthRequestMessage;
import com.cerberus.server.persistence.beans.RfidAuthentication;
import com.cerberus.server.persistence.beans.RfidTag;
import com.cerberus.server.persistence.beans.Socket;
import com.cerberus.server.persistence.beans.User;
import com.cerberus.server.service.pool.ServiceFactory;
import com.cerberus.server.service.pool.ServiceFactoryPool;

public class RfidWorkflow extends Workflow{


	// Get Logger
	private final static Logger LOGGER = Logger.getLogger(RfidWorkflow.class);

	ServiceFactory serviceFactory;

	public RfidWorkflow() {
		serviceFactory = borrowServiceFactory();
		LOGGER.info("[CurrentWorkflow]: Initializing. Borrowing Service Factory from ObjectPool");
	}

	public boolean authorizeRfidTag(RFIDAuthRequestMessage message) {
		Socket socket = serviceFactory.getOutletService().getSocketBySerialNumber(message.getSocketId());
		User user = serviceFactory.getUserService().getUserBySocketId(socket.getId());

		RfidTag rfidTag = serviceFactory.getRfidService().getRfidTagByNumber(message.getRfidNumber());

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
	public void returnServiceFactory() {
		try {
			ServiceFactoryPool.returnServiceFactory(serviceFactory);
		} catch (Throwable e) {
			LOGGER.error("ERROR Returning Service Factory");
			e.printStackTrace();
		}
	}



}
