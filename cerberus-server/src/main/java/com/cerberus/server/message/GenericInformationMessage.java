package com.cerberus.server.message;

public class GenericInformationMessage extends Message {

	private final String informationType;
	private final String information;

	public GenericInformationMessage(int socketId, long timestamp, String informationType, String information) {
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
