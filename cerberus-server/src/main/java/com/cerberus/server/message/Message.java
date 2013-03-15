package com.cerberus.server.message;

import java.security.Timestamp;

public class Message {

	private int outletSerialNumber;
	private Timestamp timestamp;
	private int messageType;
	
	public int getOutletSerialNumber() {
		return outletSerialNumber;
	}
	public void setOutletSerialNumber(int outletSerialNumber) {
		this.outletSerialNumber = outletSerialNumber;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public int getMessageType() {
		return messageType;
	}
	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}
	
	
	
}
