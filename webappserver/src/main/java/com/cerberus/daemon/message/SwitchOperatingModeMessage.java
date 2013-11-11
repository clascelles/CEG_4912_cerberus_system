package com.cerberus.daemon.message;

import com.cerberus.daemon.constants.MessageType;
import com.cerberus.daemon.workflow.MessageWorkflow;

public class SwitchOperatingModeMessage extends Message {

	private final int opMode;
	private final int powerThreshold;

	public SwitchOperatingModeMessage(String outletId, int socket, long timestamp, String rfidNumber,
			int opMode, int powerThreshold) {
		super(MessageType.OP_MODE_SWITCH, outletId, socket, timestamp, rfidNumber);
		this.opMode = opMode;
		this.powerThreshold = powerThreshold;
	}

	public int getOpMode() {
		return opMode;
	}

	public int getPowerThreshold() {
		return powerThreshold;
	}

	@Override
	public MessageWorkflow getWorkflow() {
		// Should never receive this kind of message
		return null;
	}

	@Override
	public String toString() {
		String message = super.toString();
		message += ":";
		message += opMode + ":";
		message += powerThreshold;

		return message;
	}

}
