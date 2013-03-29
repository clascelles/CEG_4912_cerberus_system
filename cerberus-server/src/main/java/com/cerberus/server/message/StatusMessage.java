package com.cerberus.server.message;

import com.cerberus.server.logic.constants.SocketStatus;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StatusMessage extends Message {

	private final SocketStatus status;

	@JsonCreator
	public StatusMessage(@JsonProperty("socketId") long socketId, @JsonProperty("timestamp") long timestamp,
			@JsonProperty("status") SocketStatus status) {
		super(MessageType.STATUS, socketId, timestamp);
		this.status = status;
	}

	public SocketStatus getStatus() {
		return status;
	}

}
