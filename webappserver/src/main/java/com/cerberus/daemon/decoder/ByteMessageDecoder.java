package com.cerberus.daemon.decoder;

import java.util.concurrent.ExecutorService;

import org.apache.log4j.Logger;
import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;

import com.cerberus.daemon.bytemessage.ByteMessageHandlerFactory;
import com.cerberus.daemon.bytemessage.ByteMessageReader;
import com.cerberus.daemon.executor.ExecutorServiceFactory;
import com.cerberus.daemon.message.Message;
import com.cerberus.daemon.message.MessageContainer;
import com.cerberus.daemon.processing.MessageProcessor;
import com.cerberus.frameworks.netty.ChannelOutletBinding;
import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.module.system.workflows.SystemWorkflow;

public class ByteMessageDecoder implements Runnable {

	//Get Logger
	private final static Logger LOGGER = Logger.getLogger(ByteMessageDecoder.class);

	private final MessageContainer messageContainer;

	public ByteMessageDecoder (MessageContainer messageContainer){
		this.messageContainer = messageContainer;
	}

	public void run() {

		//Print the message to decode to test the framework
		StopWatch stopwatch = new Log4JStopWatch("ByteMessageDecoder.run");
		LOGGER.debug("[Decoder]: " + messageContainer.getRawMessage());		
		
		ExecutorService executor = ExecutorServiceFactory.getPersistenceLogicThreadPool();
		ByteMessageReader reader = ByteMessageHandlerFactory.getReader();
		try {
			Message message = reader.read(messageContainer.getRawMessage());
			messageContainer.setMessage(message);

			// Start a new thread for the persistence logic with the message
			Runnable persistenceLogic = new MessageProcessor(messageContainer);
			executor.execute(persistenceLogic);

		} catch (IllegalArgumentException e) {
			LOGGER.error("Exception caught when trying to decode this incoming byte message: "
					+ messageContainer.getRawMessage());
			e.printStackTrace();
		} finally {
			stopwatch.stop();
		}
	}



}
