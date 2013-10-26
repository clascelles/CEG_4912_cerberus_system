package com.cerberus.daemon.persistence;

import java.util.concurrent.ExecutorService;

import org.apache.log4j.Logger;
import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;

import com.cerberus.daemon.executor.ExecutorServiceFactory;
import com.cerberus.daemon.message.MessageContainer;
import com.cerberus.daemon.message.WrongMessageException;
import com.cerberus.daemon.response.MessageResponse;
import com.cerberus.daemon.workflow.MessageWorkflow;

public class MessageProcessor implements Runnable {

	//Get Logger
	private final static Logger LOGGER = Logger.getLogger(MessageProcessor.class);

	MessageContainer messageContainer;

	public MessageProcessor (MessageContainer messageContainer){
		this.messageContainer = messageContainer;
	}

	public void run() {
		StopWatch stopwatch = new Log4JStopWatch("PersistenceLogic.run");
		LOGGER.info("[Persistence Logic]: Starting.");

		boolean messageProcessed = false;
		MessageWorkflow messageWorkflow = messageContainer.getMessage().getWorkflow();

		try {
			messageProcessed = messageWorkflow.handleMessage(messageContainer.getMessage());
		} catch(WrongMessageException e) {
			// TODO: message didn't have the appropriate workflow, wtf happened?
		}

		if (messageProcessed) {
			messageWorkflow.returnServiceFactory();
			ExecutorService executor = ExecutorServiceFactory.getResponseLogicThreadPool();
			Runnable responseLogicTask = new MessageResponse(messageContainer);
			executor.execute(responseLogicTask);
		} else {
			// TODO: Message was not processed properly. Do we try again or
			// discard the message?
		}

		stopwatch.stop();
	}


}
