package com.cerberus.server.message;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = RFIDAuthRequestMessage.class, name = "RFID_AUTH_REQ"),
		@Type(value = CurrentConsumptionMessage.class, name = "CURRENT"),
		@Type(value = StatusMessage.class, name = "STATUS"),
		@Type(value = RFIDAuthResponseMessage.class, name = "RFID_AUTH_RES"),
		@Type(value = SwitchOperatingModeMessage.class, name = "SWITCH_OP_MODE"),
		@Type(value = GenericInformationMessage.class, name = "GENERIC_INFO") })
public class Message {

	private final MessageType type;
	private final int socketId;
	private final long timestamp;

	public Message(MessageType type, int socketId, long timestamp) {
		this.type = type;
		this.socketId = socketId;
		this.timestamp = timestamp;
	}

	@JsonIgnore
	public MessageType getType() {
		return type;
	}

	public int getSocketId() {
		return socketId;
	}

	public long getTimestamp() {
		return timestamp;
	}

	@JsonIgnore
	public DateTime getDateTime() {
		return new DateTime(timestamp);
	}

}
