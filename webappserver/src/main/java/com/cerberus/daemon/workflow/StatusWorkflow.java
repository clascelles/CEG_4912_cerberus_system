package com.cerberus.daemon.workflow;

import com.cerberus.daemon.message.Message;
import com.cerberus.daemon.message.WrongMessageException;

public class StatusWorkflow extends MessageWorkflow {

	// Get Logger
	// private final static Logger LOGGER = Logger.getLogger(StatusWorkflow.class);

	public StatusWorkflow() {
		super(false); //TODO: Check this
	}

	@Override
	public boolean handleMessage(Message receivedMessage) throws WrongMessageException {

		return false;
	}

}
