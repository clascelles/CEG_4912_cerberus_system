package com.cerberus.daemon.message;

import com.cerberus.daemon.constants.MessageType;
import com.cerberus.daemon.constants.SocketOperatingMode;
import com.cerberus.daemon.workflow.MessageWorkflow;

public class SwitchOperatingModeMessage extends Message {

	private final SocketOperatingMode opMode;
	private final int powerThreshold;

	public SwitchOperatingModeMessage(String outletId, int socket, long timestamp, String rfidNumber,
			SocketOperatingMode opMode, int powerThreshold) {
		super(MessageType.OP_MODE_SWITCH, outletId, socket, timestamp, rfidNumber);
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

	@Override
	public String toString() {
		String message = super.toString();
		message += ":";
		message += opMode.toString() + ":";
		message += powerThreshold;

		return message;
	}

}
