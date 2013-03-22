package com.cerberus.server.message;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GenericInformationMessage extends Message {

	private final String informationType;
	private final String information;

	@JsonCreator
	public GenericInformationMessage(@JsonProperty("socketId") int socketId, @JsonProperty("timestamp") long timestamp,
			@JsonProperty("informationType") String informationType, @JsonProperty("information") String information) {
		super(MessageType.GENERIC_INFO, socketId, timestamp);
		this.informationType = informationType;
		this.information = information;
	}

	public String getInformationType() {
		return informationType;
	}

	public String getInformation() {
		return information;
	}

}
