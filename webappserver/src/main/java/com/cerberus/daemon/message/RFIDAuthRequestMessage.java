package com.cerberus.daemon.message;

import com.cerberus.daemon.constants.MessageType;
import com.cerberus.daemon.workflow.MessageWorkflow;

public class RFIDAuthRequestMessage extends Message {

	public RFIDAuthRequestMessage(String outletId, int socket, long timestamp, String rfidNumber) {
		super(MessageType.RFID_AUTH_REQ, outletId, socket, timestamp, rfidNumber);
	}

	@Override
	public MessageWorkflow getWorkflow() {
		// TODO Create workflow for this message
		return null;
	}

}
