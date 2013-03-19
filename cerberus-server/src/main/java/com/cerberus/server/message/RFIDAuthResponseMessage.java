package com.cerberus.server.message;

public class RFIDAuthResponseMessage extends Message {

	private final int rfidNumber;
	private final boolean isAuthorized;

	public RFIDAuthResponseMessage(MessageType type, int socketId, long timestamp, int rfidNumber, boolean isAuthorized) {
		super(type, socketId, timestamp);
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
