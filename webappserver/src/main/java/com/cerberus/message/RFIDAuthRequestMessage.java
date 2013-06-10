package com.cerberus.message;

import com.cerberus.workflow.messageHandling.MessageWorkflow;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RFIDAuthRequestMessage extends Message {

	private final String rfidNumber;

	@JsonCreator
	public RFIDAuthRequestMessage(@JsonProperty("socketId") long socketId, @JsonProperty("timestamp") long timestamp,
			@JsonProperty("rfidNumber") String rfidNumber) {
		super(socketId, timestamp);
		this.rfidNumber = rfidNumber;
	}

	public String getRfidNumber() {
		return rfidNumber;
	}

	@Override
	@JsonIgnore
	public MessageWorkflow getWorkflow() {
		// TODO Auto-generated method stub
		return null;
	}

}
