package com.cerberus.server.message;

import org.jboss.netty.channel.Channel;

public class MessageContainer {

	private String message;
	private Channel clientChannel;
	private int messageType;
	private Message messageObject;
	private int structureType;
	private Object messageDataStructure;
	
	/**
	 * Constructor used for the Decoder.
	 * @param message
	 * @param clientChannel
	 */
	public MessageContainer(String message, Channel clientChannel){
		this.message = message;
		this.clientChannel = clientChannel;
	}
	
	/**
	 * Constructor used for the Encoder
	 * @param messageDataStructure
	 * @param structureType
	 */
	public MessageContainer(Object messageDataStructure, int structureType){
		this.messageDataStructure = messageDataStructure;
		this.structureType = structureType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Channel getClientChannel() {
		return clientChannel;
	}

	public void setClientChannel(Channel clientChannel) {
		this.clientChannel = clientChannel;
	}

	public int getMessageType() {
		return messageType;
	}

	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}

	public Message getMessageObject() {
		return messageObject;
	}

	public void setMessageObject(Message messageObject) {
		this.messageObject = messageObject;
	}

	public int getStructureType() {
		return structureType;
	}

	public void setStructureType(int structureType) {
		this.structureType = structureType;
	}

	public Object getMessageDataStructure() {
		return messageDataStructure;
	}

	public void setMessageDataStructure(Object messageDataStructure) {
		this.messageDataStructure = messageDataStructure;
	}
	
	
}
