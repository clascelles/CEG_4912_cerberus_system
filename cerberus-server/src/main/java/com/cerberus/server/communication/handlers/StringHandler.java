package com.cerberus.server.communication.handlers;

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

public class StringHandler extends SimpleChannelHandler {

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
		// TODO Auto-generated method stub
		System.out.println("Message Received");

		// Type cast received object to string. This will always come from the
		// string decoder.
		String message = (String) e.getMessage();
		System.out.println(message);

		// Add Newline character so that the client can read it.
		message = message + "\n";

		Channel channel = e.getChannel();

		// Print Channel characteristics
		System.out.println("Channel ID: " + channel.getId());
		System.out.println("Channel IP: "
				+ channel.getRemoteAddress().toString());

		// Send the message back to the client that sent it.
		ChannelFuture channelFuture = Channels.future(channel);
		ChannelEvent responseEvent = new DownstreamMessageEvent(channel,
				channelFuture, message, channel.getRemoteAddress());
		ctx.sendDownstream(responseEvent);

		// TODO Add message to list or Executor service request (We need to talk
		// about this)

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
