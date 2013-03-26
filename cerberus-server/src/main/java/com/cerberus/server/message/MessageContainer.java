package com.cerberus.server.message;

import org.jboss.netty.channel.Channel;

public class MessageContainer {

	private String rawMessage;
	private Channel clientChannel;
	private Message message;

	/**
	 * Constructor used for the Decoder.
	 * @param rawMessage
	 * @param clientChannel
	 */
	public MessageContainer(String rawMessage, Channel clientChannel){
		this.rawMessage = rawMessage;
		this.clientChannel = clientChannel;
		this.message = null;
	}

	public MessageContainer(Channel clientChannel, Message message) {
		this.rawMessage = null;
		this.clientChannel = clientChannel;
		this.message = message;
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

}
