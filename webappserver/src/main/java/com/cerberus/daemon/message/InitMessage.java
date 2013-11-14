package com.cerberus.daemon.message;

import com.cerberus.daemon.constants.MessageType;
import com.cerberus.daemon.workflow.MessageWorkflow;

public class InitMessage extends Message {

	public InitMessage(String outletSerialNumber,long timestamp) {
		super(MessageType.INIT, outletSerialNumber, 0, timestamp, "0000000000");
	}

	@Override
	public MessageWorkflow getWorkflow() {
		// TODO Create workflow for this message
		return null;
	}

}
