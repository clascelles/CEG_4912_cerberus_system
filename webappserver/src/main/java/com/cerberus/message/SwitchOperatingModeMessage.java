package com.cerberus.message;

import com.cerberus.logic.constants.SocketOperatingMode;
import com.cerberus.workflow.messageHandling.MessageWorkflow;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SwitchOperatingModeMessage extends Message {

	private final SocketOperatingMode opMode;
	private final int powerThreshold;

	@JsonCreator
	public SwitchOperatingModeMessage(@JsonProperty("socketId") long socketId,
			@JsonProperty("timestamp") long timestamp, @JsonProperty("opMode") SocketOperatingMode opMode,
			@JsonProperty("powerThreshold") int powerThreshold) {
		super(socketId, timestamp);
		this.opMode = opMode;
		this.powerThreshold = powerThreshold;
	}

	public SocketOperatingMode getOpMode() {
		return opMode;
	}

	public int getPowerThreshold() {
		return powerThreshold;
	}

	@Override
	@JsonIgnore
	public MessageWorkflow getWorkflow() {
		// TODO Auto-generated method stub
		return null;
	}

}
