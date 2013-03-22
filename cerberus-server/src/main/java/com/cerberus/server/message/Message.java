package com.cerberus.server.message;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
 @Type(value = RFIDAuthRequestMessage.class, name = "RFID_AUTH_REQ"),
		@Type(value = CurrentConsumptionMessage.class, name = "CURRENT"),
		@Type(value = StatusMessage.class, name = "STATUS"),
		@Type(value = RFIDAuthResponseMessage.class, name = "RFID_AUTH_RES"),
		@Type(value = SwitchOperatingModeMessage.class, name = "SWITCH_OP_MODE"),
		@Type(value = GenericInformationMessage.class, name = "GENERIC_INFO") })
public abstract class Message {

	public enum MessageType {
		RFID_AUTH_REQ, CURRENT, STATUS, RFID_AUTH_RES, SWITCH_OP_MODE, GENERIC_INFO
	}

	private final MessageType type;
	private final int socketId;
	private final DateTime timestamp;

	@JsonCreator
	public Message(@JsonProperty("type") MessageType type, @JsonProperty("socketId") int socketId,
			@JsonProperty("timestamp") long timestamp) {
		this.type = type;
		this.socketId = socketId;
		this.timestamp = new DateTime(timestamp);
	}

	public MessageType getType() {
		return type;
	}

	public int getSocketId() {
		return socketId;
	}

	public DateTime getTimestamp() {
		return timestamp;
	}

}
