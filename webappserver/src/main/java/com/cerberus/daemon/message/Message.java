package com.cerberus.daemon.message;

import org.joda.time.DateTime;

import com.cerberus.daemon.constants.MessageType;
import com.cerberus.daemon.workflow.MessageWorkflow;

public abstract class Message {

	private final MessageType type;
	private final long socketId;
	private final long timestamp;
	private final String rfidNumber;

	public Message(MessageType type, long socketId, long timestamp, String rfidNumber) {
		this.type = type;
		this.socketId = socketId;
		this.timestamp = timestamp;
		this.rfidNumber = rfidNumber;
	}

	public MessageType getType() {
		return type;
	}

	public long getSocketId() {
		return socketId;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public DateTime getDateTime() {
		return new DateTime(timestamp);
	}

	public String getRfidNumber() {
		return rfidNumber;
	}

	public abstract MessageWorkflow getWorkflow();
}
