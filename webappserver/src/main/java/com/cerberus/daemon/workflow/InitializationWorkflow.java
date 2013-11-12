package com.cerberus.daemon.workflow;

import java.util.concurrent.ExecutorService;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import com.cerberus.daemon.executor.ExecutorServiceFactory;
import com.cerberus.daemon.message.InitMessage;
import com.cerberus.daemon.message.Message;
import com.cerberus.daemon.message.MessageContainer;
import com.cerberus.daemon.message.WrongMessageException;
import com.cerberus.daemon.response.MessageResponse;

public class InitializationWorkflow extends MessageWorkflow {

	// Get Logger
	private final static Logger LOGGER = Logger.getLogger(InitializationWorkflow.class);

	//private final ServiceFactory serviceFactory;

	public InitializationWorkflow() {
		super(false);
	}

	@Override
	public boolean handleMessage(Message sendingMessage) throws WrongMessageException {
		return false;
	}

	public boolean sendMessage(String serialNumber) {

		LOGGER.debug("Sending acknowledgment message to newly connected outlet: " + serialNumber);
		DateTime dt = new DateTime();

		InitMessage message = new InitMessage(serialNumber, dt.getMillis() / 1000);
		MessageContainer container = new MessageContainer(null, message);

		ExecutorService executor = ExecutorServiceFactory.getResponseLogicThreadPool();
		Runnable responseLogicTask = new MessageResponse(container);
		executor.execute(responseLogicTask);

		return true;
	}

}
