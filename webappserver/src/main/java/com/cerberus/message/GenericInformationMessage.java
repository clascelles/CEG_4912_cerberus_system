package com.cerberus.message;

import com.cerberus.workflow.messageHandling.MessageWorkflow;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GenericInformationMessage extends Message {

	private final String informationType;
	private final String information;

	@JsonCreator
	public GenericInformationMessage(@JsonProperty("socketId") long socketId,
			@JsonProperty("timestamp") long timestamp,
			@JsonProperty("informationType") String informationType, @JsonProperty("information") String information) {
		super(socketId, timestamp);
		this.informationType = informationType;
		this.information = information;
	}

	public String getInformationType() {
		return informationType;
	}

	public String getInformation() {
		return information;
	}

	@Override
	@JsonIgnore
	public MessageWorkflow getWorkflow() {
		// TODO Auto-generated method stub
		return null;
	}

}
