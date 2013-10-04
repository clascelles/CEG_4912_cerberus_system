package com.cerberus.daemon.message;

import com.cerberus.daemon.constants.MessageType;
import com.cerberus.daemon.workflow.MessageWorkflow;

public class RFIDAuthResponseMessage extends Message {

	private final boolean isAuthorized;

	public RFIDAuthResponseMessage(long socketId, long timestamp, String rfidNumber, boolean isAuthorized) {
		super(MessageType.RFID_AUTH_RES, socketId, timestamp, rfidNumber);
		this.isAuthorized = isAuthorized;
	}

	public boolean isAuthorized() {
		return isAuthorized;
	}

	@Override
	public MessageWorkflow getWorkflow() {
		// TODO Create workflow for this message
		return null;
	}

}
