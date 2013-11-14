package com.cerberus.daemon.message;

import org.joda.time.DateTime;

import com.cerberus.daemon.constants.MessageType;
import com.cerberus.daemon.workflow.MessageWorkflow;

public abstract class Message {

	private final MessageType type;
	private final String outletSerialNumber;
	private final int socket;
	private final long timestamp;
	private final String rfidNumber;

	public Message(MessageType type, String outletSerialNumber, int socket, long timestamp, String rfidNumber) {
		this.type = type;
		this.outletSerialNumber = outletSerialNumber;
		this.socket = socket;
		this.timestamp = timestamp;
		this.rfidNumber = rfidNumber;
	}

	public MessageType getType() {
		return type;
	}

	public String getOutletSerialNumber() {
		return outletSerialNumber;
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

	@Override
	public String toString() {
		String message = "";
		message += outletSerialNumber + ":";
		message += socket + ":";
		message += getDateTime().toString() + ":";
		message += rfidNumber;

		return message;
	}
}
