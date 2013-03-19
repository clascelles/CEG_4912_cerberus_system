package com.cerberus.server.json.decoder;

import java.util.logging.Logger;

import com.cerberus.server.message.MessageContainer;

public class JSONDecoder implements Runnable {
	
	//Get Logger
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);  
		
	private MessageContainer messageContainer;
	
	public JSONDecoder (MessageContainer messageContainer){
		this.messageContainer = messageContainer;
	}

	@Override
	public void run() {
		
		//Print the message to decode to test the framework
		LOGGER.info("[Decoder]: " + messageContainer.getMessage());
		
		//TODO Add Decoder code here
	}
	
	

}
