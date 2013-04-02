package com.cerberus.server.logic;

import java.util.concurrent.ExecutorService;

import org.apache.log4j.Logger;

import com.cerberus.server.message.CurrentConsumptionMessage;
import com.cerberus.server.message.MessageContainer;
import com.cerberus.server.message.RFIDAuthRequestMessage;
import com.cerberus.server.service.executor.ExecutorServiceFactory;
import com.cerberus.server.workflow.CurrentWorkflow;
import com.cerberus.server.workflow.RfidWorkflow;

public class PersistenceLogic implements Runnable {

	//Get Logger
	private final static Logger LOGGER = Logger.getLogger(PersistenceLogic.class);

	MessageContainer messageContainer;

	public PersistenceLogic (MessageContainer messageContainer){
		this.messageContainer = messageContainer;
	}


	public void run() {

		LOGGER.info("[Persistence Logic]: Starting.");

		//Get the message type from the message container and instantiate the right
		//workflow class to persisted the message if necessary. Once the message has
		//been persisted, pass it to the response logic thread to see if a response
		//needs to be generated.
		switch(messageContainer.getMessage().getType()){
		case RFID_AUTH_REQ:

			RfidWorkflow rfidWorkflow = new RfidWorkflow();
			RFIDAuthRequestMessage message = (RFIDAuthRequestMessage) messageContainer.getMessage();
			rfidWorkflow.authorizeRfidTag(message);
			rfidWorkflow.returnServiceFactory();
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
