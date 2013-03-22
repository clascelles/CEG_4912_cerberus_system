package com.cerberus.server.message;

import org.jboss.netty.channel.Channel;

public class MessageContainer {

	private String rawMessage;
	private Channel clientChannel;
	private Message message;
	private int structureType;
	private Object messageDataStructure;
	
	/**
	 * Constructor used for the Decoder.
	 * @param rawMessage
	 * @param clientChannel
	 */
	public MessageContainer(String rawMessage, Channel clientChannel){
		this.rawMessage = rawMessage;
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

	public String getRawMessage() {
		return rawMessage;
	}

	public void setRawMessage(String message) {
		this.rawMessage = message;
	}

	public Channel getClientChannel() {
		return clientChannel;
	}

	public void setClientChannel(Channel clientChannel) {
		this.clientChannel = clientChannel;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message messageObject) {
		this.message = messageObject;
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
