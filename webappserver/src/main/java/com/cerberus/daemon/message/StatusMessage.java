package com.cerberus.daemon.message;

import com.cerberus.daemon.constants.MessageType;
import com.cerberus.daemon.constants.SocketStatus;
import com.cerberus.daemon.workflow.MessageWorkflow;

public class StatusMessage extends Message {

	private final SocketStatus status;

	public StatusMessage(String outletId, int socket, long timestamp, String rfidNumber, SocketStatus status) {
		super(MessageType.STATUS, outletId, socket, timestamp, rfidNumber);
		this.status = status;
	}

	public SocketStatus getStatus() {
		return status;
	}

	@Override
	public MessageWorkflow getWorkflow() {
		// TODO Create workflow for this message
		return null;
	}

}
