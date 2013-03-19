package com.cerberus.server.message;

public class RFIDAuthRequestMessage extends Message {

	private final int rfidNumber;

	public RFIDAuthRequestMessage(MessageType type, int socketId, long timestamp, int rfidNumber) {
		super(type, socketId, timestamp);
		this.rfidNumber = rfidNumber;
	}

	public int getRfidNumber() {
		return rfidNumber;
	}

}
