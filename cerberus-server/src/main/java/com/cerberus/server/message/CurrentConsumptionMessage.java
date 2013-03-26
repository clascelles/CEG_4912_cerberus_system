package com.cerberus.server.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentConsumptionMessage extends Message {

	private final int current;
	private final Long rfidNumber;

	@JsonCreator
	public CurrentConsumptionMessage(@JsonProperty("socketId") int socketId, @JsonProperty("timestamp") long timestamp,
			@JsonProperty("current") int current, @JsonProperty("rfidNumber") Long rfidNumber) {
		super(MessageType.CURRENT, socketId, timestamp);
		this.current = current;
		this.rfidNumber = rfidNumber;
	}

	public int getCurrent() {
		return current;
	}

	public Long getRfidNumber() {
		return rfidNumber;
	}

}
