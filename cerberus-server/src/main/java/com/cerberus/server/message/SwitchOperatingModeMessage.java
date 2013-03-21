package com.cerberus.server.message;

import com.cerberus.server.logic.constants.SocketOperatingMode;

public class SwitchOperatingModeMessage extends Message {

	private final SocketOperatingMode opMode;
	private final int powerThreshold;

	public SwitchOperatingModeMessage(int socketId, long timestamp, SocketOperatingMode opMode, int powerThreshold) {
		super(MessageType.OUTLET_PROFILE, socketId, timestamp);
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
