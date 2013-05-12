package com.cerberus.server.message;

import com.cerberus.server.workflow.MessageWorkflow;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RFIDAuthResponseMessage extends Message {

	private final String rfidNumber;
	private final boolean isAuthorized;

	@JsonCreator
	public RFIDAuthResponseMessage(@JsonProperty("socketId") long socketId, @JsonProperty("timestamp") long timestamp,
			@JsonProperty("rfidNumber") String rfidNumber, @JsonProperty("authorized") boolean isAuthorized) {
		super(socketId, timestamp);
		this.rfidNumber = rfidNumber;
		this.isAuthorized = isAuthorized;
	}

	public String getRfidNumber() {
		return rfidNumber;
	}

	public boolean isAuthorized() {
		return isAuthorized;
	}

	@Override
	@JsonIgnore
	public MessageWorkflow getWorkflow() {
		// TODO Auto-generated method stub
		return null;
	}

}
