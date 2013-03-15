package com.cerberus.server.decoder;

import com.cerberus.server.message.MessageContainer;

public class Decoder implements Runnable {
	
	private MessageContainer messageContainer;
	
	public Decoder (MessageContainer messageContainer){
		this.messageContainer = messageContainer;
	}

	@Override
	public void run() {
		
		//Print the message to decode to test the framework
		System.out.println("[Decoder]: " + messageContainer.getMessage());
		
		//TODO Add Decoder Code Here
	}
	
	

}
