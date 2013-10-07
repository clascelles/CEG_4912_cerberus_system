package com.cerberus.frameworks.netty.handlers;

import java.util.concurrent.ExecutorService;

import org.apache.log4j.Logger;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.channel.WriteCompletionEvent;
import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;

import com.cerberus.daemon.decoder.ByteMessageDecoder;
import com.cerberus.daemon.executor.ExecutorServiceFactory;
import com.cerberus.daemon.message.MessageContainer;
import com.cerberus.frameworks.netty.ChannelOutletBinding;

public class MessageHandler extends SimpleChannelUpstreamHandler {

	//Get Logger
	private final static Logger LOGGER = Logger.getLogger(MessageHandler.class);

	@Override
	public void channelBound(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		LOGGER.debug("Channel [" + e.getChannel().getId() + "," + e.getChannel().getRemoteAddress().toString()
				+ "]: Bound");
		super.channelBound(ctx, e);
	}

	@Override
	public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		LOGGER.debug("Channel [" + e.getChannel().getId() + "," + e.getChannel().getRemoteAddress().toString()
				+ "]: Closed");
		super.channelClosed(ctx, e);
	}

	@Override
	public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		LOGGER.debug("Channel [" + e.getChannel().getId() + "," + e.getChannel().getRemoteAddress().toString()
				+ "]: Connected");
		super.channelConnected(ctx, e);
	}

	@Override
	public void channelDisconnected(ChannelHandlerContext ctx,
			ChannelStateEvent e) throws Exception {
		LOGGER.debug("Channel [" + e.getChannel().getId() + "," + e.getChannel().getRemoteAddress().toString()
				+ "]: Disconnected");
		super.channelDisconnected(ctx, e);
	}

	@Override
	public void channelOpen(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		LOGGER.debug("Channel [" + e.getChannel().getId() + "," + e.getChannel().getRemoteAddress().toString()
				+ "]: Open");
		ChannelOutletBinding.addChannelToGroup(e.getChannel());
		super.channelOpen(ctx, e);
	}

	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
			throws Exception {

		StopWatch stopwatch = new Log4JStopWatch("MessageHandler.messageReceived");

		//String message = (String)e.getMessage();
		byte[] message = (byte[]) e.getMessage();
		Channel channel = e.getChannel();

		//Log message received
		LOGGER.debug("Channel [" + e.getChannel().getId() + "," + e.getChannel().getRemoteAddress().toString()
				+ "]: Message Received");

		//Add a task to the Decoder Thread Pool.
		ExecutorService executor = ExecutorServiceFactory.getDecoderThreadPool();
		MessageContainer messageContainer = new MessageContainer(channel, message);

		//Runnable decoderTask = new JsonDecoder(messageContainer);
		Runnable decoderTask = new ByteMessageDecoder(messageContainer);
		executor.execute(decoderTask);
		stopwatch.stop();
	}

	@Override
	public void writeComplete(ChannelHandlerContext ctx, WriteCompletionEvent e)
			throws Exception {
		LOGGER.debug("Channel [" + e.getChannel().getId() + "," + e.getChannel().getRemoteAddress().toString()
				+ "]: Write Complete");
		super.writeComplete(ctx, e);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
		LOGGER.warn("Channel [" + e.getChannel().getId() + "," + e.getChannel().getRemoteAddress().toString()
				+ "]: Exception caught: " + e.getCause().getMessage());
	}

}
