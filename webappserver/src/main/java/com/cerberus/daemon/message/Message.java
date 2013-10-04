package com.cerberus.daemon.message;

import org.joda.time.DateTime;

import com.cerberus.daemon.constants.MessageType;
import com.cerberus.daemon.workflow.MessageWorkflow;

public abstract class Message {

	private final MessageType type;
	private final String outletId;
	private final int socket;
	private final long timestamp;
	private final String rfidNumber;

	public Message(MessageType type, String outletId, int socket, long timestamp, String rfidNumber) {
		this.type = type;
		this.outletId = outletId;
		this.socket = socket;
		this.timestamp = timestamp;
		this.rfidNumber = rfidNumber;
	}

	public MessageType getType() {
		return type;
	}

	public String getOutletId() {
		return outletId;
	}

	public int getSocket() {
		return socket;
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
