package com.cerberus.server.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentConsumptionMessage extends Message {

	private final int current;
	private final String rfidNumber;

	@JsonCreator
	public CurrentConsumptionMessage(@JsonProperty("socketId") long socketId,
			@JsonProperty("timestamp") long timestamp,
			@JsonProperty("current") int current, @JsonProperty("rfidNumber") String rfidNumber) {
		super(MessageType.CURRENT, socketId, timestamp);
		this.current = current;
		this.rfidNumber = rfidNumber;
	}

	public int getCurrent() {
		return current;
	}

	public String getRfidNumber() {
		return rfidNumber;
	}

}
