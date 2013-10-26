package com.cerberus.daemon.workflow;

import com.cerberus.daemon.message.Message;
import com.cerberus.daemon.message.WrongMessageException;
import com.cerberus.module.generic.workflows.Workflow;

public abstract class MessageWorkflow extends Workflow {

	// Method needs to be implemented by the workflows to process messages
	public abstract boolean handleMessage(Message receivedMessage) throws WrongMessageException;

}
