package com.cerberus.server.json.decoder;

import java.io.IOException;
import java.util.concurrent.ExecutorService;

import org.apache.log4j.Logger;
import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;

import com.cerberus.server.json.JsonDataBinderFactory;
import com.cerberus.server.logic.PersistenceLogic;
import com.cerberus.server.message.Message;
import com.cerberus.server.message.MessageContainer;
import com.cerberus.server.service.executor.ExecutorServiceFactory;
import com.fasterxml.jackson.databind.ObjectReader;

public class JsonDecoder implements Runnable {

	//Get Logger
	private final static Logger LOGGER = Logger.getLogger(JsonDecoder.class);

	private final MessageContainer messageContainer;

	public JsonDecoder (MessageContainer messageContainer){
		this.messageContainer = messageContainer;
	}

	@Override
	public void run() {

		//Print the message to decode to test the framework
		StopWatch stopwatch = new Log4JStopWatch("JsonDecoder.run");
		LOGGER.debug("[Decoder]: " + messageContainer.getRawMessage());

		ExecutorService executor = ExecutorServiceFactory.getPersistenceLogicThreadPool();

		ObjectReader reader = JsonDataBinderFactory.getReader(Message.class);
		try {
			Message message = reader.readValue(messageContainer.getRawMessage());
			messageContainer.setMessage(message);

			// Start a new thread for the persistence logic with the message
			Runnable persistenceLogic = new PersistenceLogic(messageContainer);
			executor.execute(persistenceLogic);

		} catch (IOException e) {
			LOGGER.error("Exception caught when trying to decode this incoming JSON message: "
					+ messageContainer.getRawMessage());
			e.printStackTrace();
		} finally {
			stopwatch.stop();
		}
	}



}
