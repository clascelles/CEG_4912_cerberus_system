package com.cerberus.daemon.message;

import com.cerberus.daemon.workflow.CurrentConsumptionWorkflow;
import com.cerberus.daemon.workflow.MessageWorkflow;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentConsumptionMessage extends Message {

	private final int current;
	private final String rfidNumber;

	@JsonCreator
	public CurrentConsumptionMessage(@JsonProperty("socketId") long socketId,
			@JsonProperty("timestamp") long timestamp,
			@JsonProperty("current") int current, @JsonProperty("rfidNumber") String rfidNumber) {
		super(socketId, timestamp);
		this.current = current;
		this.rfidNumber = rfidNumber;
	}

	public int getCurrent() {
		return current;
	}

	public String getRfidNumber() {
		return rfidNumber;
	}

	@Override
	@JsonIgnore
	public MessageWorkflow getWorkflow() {
		return new CurrentConsumptionWorkflow();
	}

}
