package com.cerberus.server.encoder;

import java.util.logging.Logger;

import com.cerberus.server.message.MessageContainer;

public class Encoder implements Runnable {

	//Get Logger
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);  
		
	private MessageContainer messageContainer;
	
	public Encoder(MessageContainer messageContainer){
		this.messageContainer = messageContainer;
	}
	
	
	@Override
	public void run() {
		
		//Print the message to Encode to test the framework
		LOGGER.info("[Encoder]: " + messageContainer.getMessageDataStructure().toString());
		
		// TODO Add Encoder code here
		
	}

	
}
