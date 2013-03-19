package com.cerberus.server.message;

public class CurrentConsumptionMessage extends Message {

	private final int current;
	private final int rfidNumber;

	public CurrentConsumptionMessage(MessageType type, int socketId, long timestamp, int current, int rfidNumber) {
		super(type, socketId, timestamp);
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
