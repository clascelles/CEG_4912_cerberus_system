package com.cerberus.server.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RFIDAuthResponseMessage extends Message {

	private final int rfidNumber;
	private final boolean isAuthorized;

	@JsonCreator
	public RFIDAuthResponseMessage(@JsonProperty("socketId") int socketId, @JsonProperty("timestamp") long timestamp,
			@JsonProperty("rfidNumber") int rfidNumber, @JsonProperty("authorized") boolean isAuthorized) {
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
