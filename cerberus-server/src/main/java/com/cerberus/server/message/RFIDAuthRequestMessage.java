package com.cerberus.server.message;

public class RFIDAuthRequestMessage extends Message {

	private final int rfidNumber;

	public RFIDAuthRequestMessage(int socketId, long timestamp, int rfidNumber) {
		super(MessageType.RFID_AUTH_REQ, socketId, timestamp);
		this.rfidNumber = rfidNumber;
	}

	public int getRfidNumber() {
		return rfidNumber;
	}

}
