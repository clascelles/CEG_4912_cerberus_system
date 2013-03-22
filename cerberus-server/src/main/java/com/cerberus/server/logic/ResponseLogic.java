package com.cerberus.server.logic;

import java.util.logging.Logger;

import com.cerberus.server.message.MessageContainer;

public class ResponseLogic implements Runnable {

	//Get Logger
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); 
		
	MessageContainer messageContainer;
	
	public ResponseLogic(MessageContainer messageContainer) {
		this.messageContainer = messageContainer;
	}

	@Override
	public void run() {
		
		LOGGER.info("[Response Logic]: Starting!");
		
		// TODO Add code for the Response Logic
		
	}

}
