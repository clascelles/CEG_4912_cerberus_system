package com.cerberus.server.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RFIDAuthRequestMessage extends Message {

	private final int rfidNumber;

	@JsonCreator
	public RFIDAuthRequestMessage(@JsonProperty("socketId") long socketId, @JsonProperty("timestamp") long timestamp,
			@JsonProperty("rfidNumber") int rfidNumber) {
		super(MessageType.RFID_AUTH_REQ, socketId, timestamp);
		this.rfidNumber = rfidNumber;
	}

	public int getRfidNumber() {
		return rfidNumber;
	}

}
