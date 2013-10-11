package com.cerberus.daemon.workflow;

import java.sql.Timestamp;

import org.apache.log4j.Logger;
import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;

import com.cerberus.daemon.message.CurrentConsumptionMessage;
import com.cerberus.daemon.message.Message;
import com.cerberus.daemon.message.WrongMessageException;
import com.cerberus.model.outlets.bean.Current;
import com.cerberus.model.outlets.bean.RfidTag;

public class StatusWorkflow extends MessageWorkflow {

	// Get Logger
	private final static Logger LOGGER = Logger.getLogger(CurrentConsumptionWorkflow.class);

	//private final ServiceFactory serviceFactory;

	public StatusWorkflow() {
		//serviceFactory = borrowServiceFactory();
		//LOGGER.info("[CurrentWorkflow]: Initializing. Borrowing Service Factory from ObjectPool");
	}

	@Override
	public boolean handleReceivedMessage(Message receivedMessage) throws WrongMessageException {

		
		return true;
	}

	@Override
	public boolean handleSendingMessage(Message sendingMessage) throws WrongMessageException {
		// TODO Auto-generated method stub
		return false;
	}

}
