package com.cerberus.server.message;

public class CurrentConsumptionMessage extends Message {

	private final int current;
	private final int rfidNumber;

	public CurrentConsumptionMessage(int socketId, long timestamp, int current, int rfidNumber) {
		super(MessageType.CURRENT, socketId, timestamp);
		this.current = current;
		this.rfidNumber = rfidNumber;
	}

	public int getCurrent() {
		return current;
	}

	public int getRfidNumber() {
		return rfidNumber;
	}

}
