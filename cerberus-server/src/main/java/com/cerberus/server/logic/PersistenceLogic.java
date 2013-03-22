package com.cerberus.server.logic;

import java.util.concurrent.ExecutorService;
import java.util.logging.Logger;

import com.cerberus.server.message.CurrentConsumptionMessage;
import com.cerberus.server.message.MessageContainer;
import com.cerberus.server.service.executor.ExecutorServiceFactory;
import com.cerberus.server.workflow.CurrentWorkflow;

public class PersistenceLogic implements Runnable {

	//Get Logger
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	MessageContainer messageContainer;

	public PersistenceLogic (MessageContainer messageContainer){
		this.messageContainer = messageContainer;
	}


	@Override
	public void run() {

		LOGGER.info("[Persistence Logic]: Starting.");

		//Get the message type from the message container and instantiate the right
		//workflow class to persisted the message if necessary. Once the message has
		//been persisted, pass it to the response logic thread to see if a response
		//needs to be generated.
		switch(messageContainer.getMessage().getType()){
		case RFID_AUTH_REQ:
			break;
		case CURRENT:

			//Instantiate the appropriate workflow
			//Gets the Service Factory in the constructor
			CurrentWorkflow currentWorkflow = new CurrentWorkflow();

			//Type cast the message object into a current consumption message object
			CurrentConsumptionMessage currentMessage = (CurrentConsumptionMessage) messageContainer.getMessage();

			//Persist the current consumption message
			currentWorkflow.persistCurrentMessage(currentMessage);

			//Return the Service Factory to the pool
			currentWorkflow.returnServiceFactory();

			break;
		case SWITCH_OP_MODE:
			break;
		case RFID_AUTH_RES:
			break;
		case STATUS:
			break;
		default:
			break;
		}

		ExecutorService executor = ExecutorServiceFactory.getResponseLogicThreadPool();
		Runnable responseLogicTask = new ResponseLogic(messageContainer);
		executor.execute(responseLogicTask);



	}


}
