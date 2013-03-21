package com.cerberus.server.message;

import com.cerberus.server.logic.constants.SocketStatus;

public class StatusMessage extends Message {

	private final SocketStatus status;

	public StatusMessage(int socketId, long timestamp, SocketStatus status) {
		super(MessageType.STATUS, socketId, timestamp);
		this.status = status;
	}

	public SocketStatus getStatus() {
		return status;
	}

}
