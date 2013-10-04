package com.cerberus.daemon.message;

import com.cerberus.daemon.constants.MessageType;
import com.cerberus.daemon.workflow.CurrentConsumptionWorkflow;
import com.cerberus.daemon.workflow.MessageWorkflow;

public class CurrentConsumptionMessage extends Message {

	private final int current;

	public CurrentConsumptionMessage(long socketId, long timestamp, String rfidNumber, int current) {
		super(MessageType.CURRENT, socketId, timestamp, rfidNumber);
		this.current = current;
	}

	public int getCurrent() {
		return current;
	}

	@Override
	public MessageWorkflow getWorkflow() {
		return new CurrentConsumptionWorkflow();
	}

}
