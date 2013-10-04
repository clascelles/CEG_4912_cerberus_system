package com.cerberus.daemon.message;

import com.cerberus.daemon.constants.MessageType;
import com.cerberus.daemon.workflow.MessageWorkflow;

public class GenericInformationMessage extends Message {

	private final String informationType;
	private final String information;

	public GenericInformationMessage(String outletId, int socket, long timestamp, String rfidNumber,
			String informationType, String information) {
		super(MessageType.GENERIC, outletId, socket, timestamp, rfidNumber);
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
	public MessageWorkflow getWorkflow() {
		// TODO Create workflow for this message
		return null;
	}

}
