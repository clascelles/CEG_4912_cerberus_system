package com.cerberus.daemon.workflow;

import java.util.concurrent.ExecutorService;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import com.cerberus.daemon.constants.OperationMode;
import com.cerberus.daemon.executor.ExecutorServiceFactory;
import com.cerberus.daemon.message.Message;
import com.cerberus.daemon.message.MessageContainer;
import com.cerberus.daemon.message.SwitchOperatingModeMessage;
import com.cerberus.daemon.message.WrongMessageException;
import com.cerberus.daemon.response.MessageResponse;

public class SwitchOperationModeWorkflow extends MessageWorkflow {

	// Get Logger
	private final static Logger LOGGER = Logger.getLogger(SwitchOperationModeWorkflow.class);

	public SwitchOperationModeWorkflow() {
		super(false);
	}

	@Override
	public boolean handleMessage(Message sendingMessage) throws WrongMessageException {

		// Shouldn't be called for SwitchOp messages ...
		return false;
	}

	public boolean sendMessage(String serialNumber, int socket, String rfidNumber,
			OperationMode opMode, int powerThreshold) {

		DateTime dt = new DateTime();

		SwitchOperatingModeMessage message = new SwitchOperatingModeMessage(serialNumber, socket, dt.getMillis() / 1000, rfidNumber, opMode.getOperationMode(), powerThreshold);
		MessageContainer container = new MessageContainer(null, message);

		ExecutorService executor = ExecutorServiceFactory.getResponseLogicThreadPool();
		Runnable responseLogicTask = new MessageResponse(container);
		executor.execute(responseLogicTask);

		return true;
	}

}
