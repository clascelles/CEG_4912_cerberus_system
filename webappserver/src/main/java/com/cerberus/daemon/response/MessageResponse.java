package com.cerberus.daemon.response;

import java.util.concurrent.ExecutorService;

import org.apache.log4j.Logger;
import org.jboss.netty.channel.Channel;
import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;

import com.cerberus.daemon.encoder.ByteMessageEncoder;
import com.cerberus.daemon.executor.ExecutorServiceFactory;
import com.cerberus.daemon.message.MessageContainer;
import com.cerberus.frameworks.netty.ChannelOutletBinding;

public class MessageResponse implements Runnable {

	//Get Logger
	private final static Logger LOGGER = Logger.getLogger(MessageResponse.class);

	MessageContainer messageContainer;

	public MessageResponse(MessageContainer messageContainer) {
		this.messageContainer = messageContainer;
	}

	public void run() {

		StopWatch stopwatch = new Log4JStopWatch("ResponseLogic.run");
		LOGGER.info("[Response Logic]: Starting!");

		// If client channel is null, then find the channel linked to the outletId
		if(messageContainer.getClientChannel() == null) {
			String outletId = messageContainer.getMessage().getOutletId();
			Channel channel = ChannelOutletBinding.getChannelFromGroupByOutlet(messageContainer.getMessage().getOutletId());
			if(channel != null) {
				messageContainer.setClientChannel(channel);
			} else {
				LOGGER.error("Cannot find the channel linked to outletID: " + outletId + ", discarding the message.");
				LOGGER.error("Message: " + messageContainer.getMessage().toString());
			}
		}

		// Send to encoder
		ExecutorService executor = ExecutorServiceFactory.getEncoderThreadPool();
		Runnable encoder = new ByteMessageEncoder(messageContainer);
		executor.execute(encoder);
		stopwatch.stop();
	}

}
