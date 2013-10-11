package com.cerberus.daemon.workflow;

import java.sql.Timestamp;
import java.util.concurrent.ExecutorService;

import org.apache.log4j.Logger;
import org.jboss.netty.channel.Channel;
import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;

import com.cerberus.daemon.executor.ExecutorServiceFactory;
import com.cerberus.daemon.message.CurrentConsumptionMessage;
import com.cerberus.daemon.message.Message;
import com.cerberus.daemon.message.MessageContainer;
import com.cerberus.daemon.message.SwitchOperatingModeMessage;
import com.cerberus.daemon.message.WrongMessageException;
import com.cerberus.daemon.response.ResponseLogic;
import com.cerberus.frameworks.netty.ChannelOutletBinding;
import com.cerberus.model.outlets.bean.Current;
import com.cerberus.model.outlets.bean.RfidTag;

public class SwitchOperationModeWorkflow extends MessageWorkflow {

	// Get Logger
	private final static Logger LOGGER = Logger.getLogger(CurrentConsumptionWorkflow.class);

	//private final ServiceFactory serviceFactory;

	public SwitchOperationModeWorkflow() {
		//serviceFactory = borrowServiceFactory();
		//LOGGER.info("[CurrentWorkflow]: Initializing. Borrowing Service Factory from ObjectPool");
	}

	@Override
	public boolean handleReceivedMessage(Message receivedMessage) throws WrongMessageException {
		//Should never receive this message from an Outlet.
		return true;
	}

	@Override
	public boolean handleSendingMessage(Message sendingMessage) throws WrongMessageException {

		SwitchOperatingModeMessage message = (SwitchOperatingModeMessage) sendingMessage;
		
		Channel c =ChannelOutletBinding.getChannelFromGroupByOutlet(sendingMessage.getOutletId());
		MessageContainer messageContainer = new MessageContainer(c, message);
		
		ExecutorService executor = ExecutorServiceFactory.getResponseLogicThreadPool();
		Runnable responseLogicTask = new ResponseLogic(messageContainer);
		executor.execute(responseLogicTask);
		
		return false;
	}

}
