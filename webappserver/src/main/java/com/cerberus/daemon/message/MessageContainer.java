package com.cerberus.daemon.message;

import org.jboss.netty.channel.Channel;

public class MessageContainer {

	private final byte[] rawMessage;
	private Channel clientChannel;
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

	public void setClientChannel(Channel channel) {
		this.clientChannel = channel;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message messageObject) {
		this.message = messageObject;
	}

}
