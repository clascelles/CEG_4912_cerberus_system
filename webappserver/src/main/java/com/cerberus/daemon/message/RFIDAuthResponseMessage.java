package com.cerberus.daemon.message;

import com.cerberus.daemon.constants.MessageType;
import com.cerberus.daemon.workflow.MessageWorkflow;
import com.cerberus.daemon.workflow.RFIDAuthMessageWorkflow;

public class RFIDAuthResponseMessage extends Message {

	private final boolean isAuthorized;

	public RFIDAuthResponseMessage(String outletId, int socket, long timestamp, String rfidNumber, boolean isAuthorized) {
		super(MessageType.RFID_AUTH_RES, outletId, socket, timestamp, rfidNumber);
		this.isAuthorized = isAuthorized;
	}

	public boolean isAuthorized() {
		return isAuthorized;
	}

	@Override
	public MessageWorkflow getWorkflow() {
		return new RFIDAuthMessageWorkflow();
	}

}
