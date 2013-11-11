package com.cerberus.daemon.workflow;

import java.util.concurrent.ExecutorService;

import org.apache.log4j.Logger;
import org.jboss.netty.channel.Channel;
import org.joda.time.DateTime;

import com.cerberus.daemon.constants.SocketOperatingMode;
import com.cerberus.daemon.executor.ExecutorServiceFactory;
import com.cerberus.daemon.message.Message;
import com.cerberus.daemon.message.MessageContainer;
import com.cerberus.daemon.message.SwitchOperatingModeMessage;
import com.cerberus.daemon.message.WrongMessageException;
import com.cerberus.daemon.response.MessageResponse;
import com.cerberus.frameworks.netty.ChannelOutletBinding;

public class SwitchOperationModeWorkflow extends MessageWorkflow {

	// Get Logger
	private final static Logger LOGGER = Logger.getLogger(SwitchOperationModeWorkflow.class);

	//private final ServiceFactory serviceFactory;

	public SwitchOperationModeWorkflow() {
		super(false);
		//serviceFactory = borrowServiceFactory();
		//LOGGER.info("[CurrentWorkflow]: Initializing. Borrowing Service Factory from ObjectPool");
	}

	@Override
	public boolean handleMessage(Message sendingMessage) throws WrongMessageException {

		SwitchOperatingModeMessage message = (SwitchOperatingModeMessage) sendingMessage;

		Channel c = ChannelOutletBinding.getChannelFromGroupByOutlet(sendingMessage.getOutletId());
		MessageContainer messageContainer = new MessageContainer(c, message);

		ExecutorService executor = ExecutorServiceFactory.getResponseLogicThreadPool();
		Runnable responseLogicTask = new MessageResponse(messageContainer);
		executor.execute(responseLogicTask);

		return true;
	}

	public boolean sendMessage(String serialNumber, int socket, String rfidNumber,
			SocketOperatingMode opMode, int powerThreshold) {

		DateTime dt = new DateTime();

		SwitchOperatingModeMessage message = new SwitchOperatingModeMessage(serialNumber, socket, dt.getMillis() / 1000, rfidNumber, opMode, powerThreshold);
		MessageContainer container = new MessageContainer(null, message);

		ExecutorService executor = ExecutorServiceFactory.getResponseLogicThreadPool();
		Runnable responseLogicTask = new MessageResponse(container);
		executor.execute(responseLogicTask);

		return true;
	}

}
