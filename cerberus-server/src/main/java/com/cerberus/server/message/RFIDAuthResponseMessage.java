package com.cerberus.server.message;

public class RFIDAuthResponseMessage extends Message {

	private final int rfidNumber;
	private final boolean isAuthorized;

	public RFIDAuthResponseMessage(int socketId, long timestamp, int rfidNumber, boolean isAuthorized) {
		super(MessageType.RFID_AUTH_RES, socketId, timestamp);
		this.rfidNumber = rfidNumber;
		this.isAuthorized = isAuthorized;
	}

	public int getRfidNumber() {
		return rfidNumber;
	}

	public boolean isAuthorized() {
		return isAuthorized;
	}


}
