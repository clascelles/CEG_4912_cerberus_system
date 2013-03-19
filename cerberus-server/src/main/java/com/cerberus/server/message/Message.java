package com.cerberus.server.message;

import org.joda.time.DateTime;

public abstract class Message {

	private final MessageType type;
	private final int socketId;
	private final DateTime timestamp;

	public Message(MessageType type, int socketId, long timestamp) {
		this.type = type;
		this.socketId = socketId;
		this.timestamp = new DateTime(timestamp);
	}

	public MessageType getType() {
		return type;
	}

	public int getSocketId() {
		return socketId;
	}

	public DateTime getTimestamp() {
		return timestamp;
	}

}
