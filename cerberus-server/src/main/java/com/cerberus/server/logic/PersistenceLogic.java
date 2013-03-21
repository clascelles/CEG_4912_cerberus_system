package com.cerberus.server.logic;

import java.util.logging.Logger;

import com.cerberus.server.message.MessageContainer;

public class PersistenceLogic implements Runnable {

	//Get Logger
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); 

	MessageContainer messageContainer;

	public PersistenceLogic (MessageContainer messageContainer){
		this.messageContainer = messageContainer;
	}


	@Override
	public void run() {

		LOGGER.info("Starting Persistence Logic");

		//Get the message type from the message container and instantiate the right
		//workflow class to persisted the message if necessary. Once the message has
		//been persisted, pass it to the response logic thread to see if a response
		//needs to be generated.
		switch(messageContainer.getMessageObject().getType()){
		case RFID_AUTH_REQ:

			break;
		case CURRENT:
			break;
		case OUTLET_PROFILE:
			break;
		case RFID_AUTH_RES:
			break;
		case STATUS:
			break;
		default:
			break;
		}


	}


}
