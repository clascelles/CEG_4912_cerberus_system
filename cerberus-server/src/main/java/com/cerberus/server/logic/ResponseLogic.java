package com.cerberus.server.logic;

import java.util.concurrent.ExecutorService;

import org.apache.log4j.Logger;

import com.cerberus.server.json.encoder.JsonEncoder;
import com.cerberus.server.message.CurrentConsumptionMessage;
import com.cerberus.server.message.MessageContainer;
import com.cerberus.server.service.executor.ExecutorServiceFactory;

public class ResponseLogic implements Runnable {

	//Get Logger
	private final static Logger LOGGER = Logger.getLogger(ResponseLogic.class);

	MessageContainer messageContainer;

	public ResponseLogic(MessageContainer messageContainer) {
		this.messageContainer = messageContainer;
	}

	@Override
	public void run() {

		LOGGER.info("[Response Logic]: Starting!");

		// TODO Add code for the Response Logic
		// Dummy message sent for now (to test encoding)...
		CurrentConsumptionMessage message = new CurrentConsumptionMessage(12345, System.currentTimeMillis() / 1000,
				1000, 1234567890L);
		MessageContainer container = new MessageContainer(messageContainer.getClientChannel(), message);

		ExecutorService executor = ExecutorServiceFactory.getEncoderThreadPool();
		Runnable encoder = new JsonEncoder(container);
		executor.execute(encoder);
	}

}
