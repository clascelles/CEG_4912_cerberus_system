package com.cerberus.daemon.response;

import java.util.concurrent.ExecutorService;

import org.apache.log4j.Logger;
import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;

import com.cerberus.daemon.encoder.JsonEncoder;
import com.cerberus.daemon.executor.ExecutorServiceFactory;
import com.cerberus.daemon.message.CurrentConsumptionMessage;
import com.cerberus.daemon.message.MessageContainer;

public class ResponseLogic implements Runnable {

	//Get Logger
	private final static Logger LOGGER = Logger.getLogger(ResponseLogic.class);

	MessageContainer messageContainer;

	public ResponseLogic(MessageContainer messageContainer) {
		this.messageContainer = messageContainer;
	}

	public void run() {

		StopWatch stopwatch = new Log4JStopWatch("ResponseLogic.run");
		LOGGER.info("[Response Logic]: Starting!");

		// TODO Add code for the Response Logic
		// Dummy message sent for now (to test encoding)...
		CurrentConsumptionMessage message = new CurrentConsumptionMessage(12345, System.currentTimeMillis() / 1000,
				1000, "1234567890");
		MessageContainer container = new MessageContainer(messageContainer.getClientChannel(), message);

		ExecutorService executor = ExecutorServiceFactory.getEncoderThreadPool();
		Runnable encoder = new JsonEncoder(container);
		executor.execute(encoder);
		stopwatch.stop();
	}

}
