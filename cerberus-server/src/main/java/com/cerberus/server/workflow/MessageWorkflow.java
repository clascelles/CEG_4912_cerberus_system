package com.cerberus.server.workflow;

import org.apache.log4j.Logger;

import com.cerberus.server.message.Message;
import com.cerberus.server.message.WrongMessageException;
import com.cerberus.server.service.pool.ServiceFactory;
import com.cerberus.server.service.pool.ServiceFactoryPool;

public abstract class MessageWorkflow {

	//Get Logger
	private final static Logger LOGGER = Logger.getLogger(MessageWorkflow.class);

	// Method needs to be implemented by the workflows to process messages
	public abstract boolean handleReceivedMessage(Message receivedMessage) throws WrongMessageException;

	public abstract boolean handleSendingMessage(Message sendingMessage) throws WrongMessageException;

	//Method used by the constructor to get the Service Factory
	protected ServiceFactory borrowServiceFactory(){
		ServiceFactory serviceFactory = null;
		try {
			serviceFactory = ServiceFactoryPool.borrowServiceFactory();
		} catch (Throwable e) {
			LOGGER.error("ERROR Obtaining Service Factory");
			e.printStackTrace();
		}
		return serviceFactory;
	}

	// Method needs to be implemented by the workflows to return
	// the Service Factory
	public abstract void returnServiceFactory();

}
