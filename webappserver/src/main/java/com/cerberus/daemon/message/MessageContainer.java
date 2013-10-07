package com.cerberus.daemon.message;

import org.jboss.netty.channel.Channel;

public class MessageContainer {

	private final Channel clientChannel;
	private final byte[] rawMessage;
	private Message message;

	/**
	 * Constructor used for the Decoder.
	 * @param clientChannel
	 * @param rawMessage
	 */
	public MessageContainer(Channel clientChannel, byte[] rawMessage){
		this.rawMessage = rawMessage;
		this.clientChannel = clientChannel;
		this.message = null;
	}

	public MessageContainer(Channel clientChannel, Message message) {
		this.rawMessage = null;
		this.clientChannel = clientChannel;
		this.message = message;
	}

	public byte[] getRawMessage() {
		return rawMessage;
	}

	public Channel getClientChannel() {
		return clientChannel;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message messageObject) {
		this.message = messageObject;
	}

}
