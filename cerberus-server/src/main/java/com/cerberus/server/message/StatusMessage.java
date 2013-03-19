package com.cerberus.server.message;

public class StatusMessage extends Message {

	private final MessageStatusType statusType;

	public StatusMessage(MessageType type, int socketId, long timestamp, MessageStatusType status) {
		super(type, socketId, timestamp);
		this.statusType = status;
	}

	public MessageStatusType getStatusType() {
		return statusType;
	}

}
