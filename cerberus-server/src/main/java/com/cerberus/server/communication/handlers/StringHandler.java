package com.cerberus.server.communication.handlers;

import java.util.concurrent.ExecutorService;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelEvent;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.DownstreamMessageEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;
import org.jboss.netty.channel.WriteCompletionEvent;

import com.cerberus.server.decoder.Decoder;
import com.cerberus.server.message.MessageContainer;
import com.cerberus.server.service.executor.ExecutorServiceFactory;

public class StringHandler extends SimpleChannelHandler{

	@Override
	public void channelBound(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Channel is Bound");		
		super.channelBound(ctx, e);
	}

	@Override
	public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Channel is Closed");
		super.channelClosed(ctx, e);
	}

	@Override
	public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Channel is Connected");
		super.channelConnected(ctx, e);
	}

	@Override
	public void channelDisconnected(ChannelHandlerContext ctx,
			ChannelStateEvent e) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Channel is Disconnected");
		super.channelDisconnected(ctx, e);
	}

	@Override
	public void channelOpen(ChannelHandlerContext ctx, ChannelStateEvent e)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Channel is Open");
		super.channelOpen(ctx, e);
	}

	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
			throws Exception {
			
		//Type cast received object to string. This will always come from the string decoder.
		String message = (String)e.getMessage();
		Channel channel = e.getChannel();
		
		//Log message received
		System.out.println("Message Received [ID: " + channel.getId() + " IP: " + channel.getRemoteAddress().toString() + "]");
				
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
		// TODO Auto-generated method stub
		System.out.println("Write Complete");
		super.writeComplete(ctx, e);
	}

}
