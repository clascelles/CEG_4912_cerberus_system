package com.cerberus.daemon.workflow;

import org.apache.log4j.Logger;

import com.cerberus.daemon.message.Message;
import com.cerberus.daemon.message.WrongMessageException;

public class StatusWorkflow extends MessageWorkflow {

	// Get Logger
	private final static Logger LOGGER = Logger.getLogger(StatusWorkflow.class);

	//private final ServiceFactory serviceFactory;

	public StatusWorkflow() {
		//serviceFactory = borrowServiceFactory();
		//LOGGER.info("[CurrentWorkflow]: Initializing. Borrowing Service Factory from ObjectPool");
	}

	@Override
	public boolean handleMessage(Message receivedMessage) throws WrongMessageException {


		return true;
	}

}
