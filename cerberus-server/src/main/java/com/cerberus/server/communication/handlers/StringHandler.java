package com.cerberus.server.communication.handlers;

import java.util.concurrent.ExecutorService;
import java.util.logging.Logger;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.channel.WriteCompletionEvent;

import com.cerberus.server.communication.ChannelOutletBinding;
import com.cerberus.server.decoder.Decoder;
import com.cerberus.server.message.MessageContainer;
import com.cerberus.server.service.executor.ExecutorServiceFactory;

public class StringHandler extends SimpleChannelHandler {

	//Get Logger
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);  
		
	@Override
	public void channelBound(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		LOGGER.finest("Channel [" + e.getChannel().getId() + "," + e.getChannel().getRemoteAddress().toString() + "]: Bound");
		super.channelBound(ctx, e);
	}

	@Override
	public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		LOGGER.finest("Channel [" + e.getChannel().getId() + "," + e.getChannel().getRemoteAddress().toString() + "]: Closed");
		super.channelClosed(ctx, e);
	}

	@Override
	public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		LOGGER.finest("Channel [" + e.getChannel().getId() + "," + e.getChannel().getRemoteAddress().toString() + "]: Connected");
		super.channelConnected(ctx, e);
	}

	@Override
	public void channelDisconnected(ChannelHandlerContext ctx,
			ChannelStateEvent e) throws Exception {
		LOGGER.finest("Channel [" + e.getChannel().getId() + "," + e.getChannel().getRemoteAddress().toString() + "]: Disconnected");
		super.channelDisconnected(ctx, e);
	}

	@Override
	public void channelOpen(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		LOGGER.finest("Channel [" + e.getChannel().getId() + "," + e.getChannel().getRemoteAddress().toString() + "]: Open");
		ChannelOutletBinding.addChannelToGroup(e.getChannel());
		super.channelOpen(ctx, e);
	}

	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
			throws Exception {
			
		//Type cast received object to string. This will always come from the string decoder.
		String message = (String)e.getMessage();
		Channel channel = e.getChannel();
		
		//Log message received
		LOGGER.info("Channel [" + e.getChannel().getId() + "," + e.getChannel().getRemoteAddress().toString() + "]: Message Received");
				
		//Add a task to the Decoder Thread Pool.
		ExecutorService executor = ExecutorServiceFactory.getDecoderThreadPool();
		MessageContainer messageContainer = new MessageContainer(message, channel);
		Runnable decoderTask = new Decoder(messageContainer);
		executor.execute(decoderTask);

		super.messageReceived(ctx, e);
	}

	@Override
	public void writeComplete(ChannelHandlerContext ctx, WriteCompletionEvent e)
			throws Exception {
		LOGGER.finest("Channel [" + e.getChannel().getId() + "," + e.getChannel().getRemoteAddress().toString() + "]: Write Complete");
		super.writeComplete(ctx, e);
	}

}
