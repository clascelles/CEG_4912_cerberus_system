package com.cerberus.daemon.message;

import com.cerberus.daemon.constants.MessageType;
import com.cerberus.daemon.constants.SocketOperatingMode;
import com.cerberus.daemon.workflow.MessageWorkflow;

public class SwitchOperatingModeMessage extends Message {

	private final SocketOperatingMode opMode;
	private final int powerThreshold;

	public SwitchOperatingModeMessage(long socketId, long timestamp, String rfidNumber,
			SocketOperatingMode opMode, int powerThreshold) {
		super(MessageType.OP_MODE_SWITCH, socketId, timestamp, rfidNumber);
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
	public MessageWorkflow getWorkflow() {
		// TODO Create workflow for this message
		return null;
	}

}
