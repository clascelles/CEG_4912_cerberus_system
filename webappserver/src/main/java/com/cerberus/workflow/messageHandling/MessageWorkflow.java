package com.cerberus.workflow.messageHandling;

import com.cerberus.message.Message;
import com.cerberus.message.WrongMessageException;
import com.cerberus.workflow.Workflow;

public abstract class MessageWorkflow extends Workflow {

	// Method needs to be implemented by the workflows to process messages
	public abstract boolean handleReceivedMessage(Message receivedMessage) throws WrongMessageException;

	public abstract boolean handleSendingMessage(Message sendingMessage) throws WrongMessageException;

}
