package com.cerberus.server.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RFIDAuthRequestMessage extends Message {

	private final String rfidNumber;

	@JsonCreator
	public RFIDAuthRequestMessage(@JsonProperty("socketId") long socketId, @JsonProperty("timestamp") long timestamp,
			@JsonProperty("rfidNumber") String rfidNumber) {
		super(MessageType.RFID_AUTH_REQ, socketId, timestamp);
		this.rfidNumber = rfidNumber;
	}

	public String getRfidNumber() {
		return rfidNumber;
	}

}
