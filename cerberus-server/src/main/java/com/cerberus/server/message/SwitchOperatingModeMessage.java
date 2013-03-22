package com.cerberus.server.message;

import com.cerberus.server.logic.constants.SocketOperatingMode;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SwitchOperatingModeMessage extends Message {

	private final SocketOperatingMode opMode;
	private final int powerThreshold;

	@JsonCreator
	public SwitchOperatingModeMessage(@JsonProperty("socketId") int socketId,
			@JsonProperty("timestamp") long timestamp, @JsonProperty("opMode") SocketOperatingMode opMode,
			@JsonProperty("powerThreshold") int powerThreshold) {
		super(MessageType.SWITCH_OP_MODE, socketId, timestamp);
		this.opMode = opMode;
		this.powerThreshold = powerThreshold;
	}

	public SocketOperatingMode getOpMode() {
		return opMode;
	}

	public int getPowerThreshold() {
		return powerThreshold;
	}

}
