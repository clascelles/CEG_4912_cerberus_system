package com.cerberus.server.bootstrap;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import com.cerberus.server.communication.pipeline.SimpleChannelPipelineFactory;

public class CommunicationBootstrap extends Thread{

	private final static Logger LOGGER = Logger.getLogger(CommunicationBootstrap.class);

	//This runs when the thread is started
	@Override
	public void run(){

		LOGGER.info("Starting Communication Initialization Thread");
		/*
		 * Create the ChannelFactory by creating two thread pools, the Boss and the Workers.
		 * ChannelFactory: Data structure which creates and holds Channels.
		 * BossThread: Bind sockets and pass them off to the worker thread.
		 * WorkerThread: Perform all the asynchronous I/O
		 */
		 NioServerSocketChannelFactory channelFactory = new NioServerSocketChannelFactory(
			     Executors.newCachedThreadPool(),
			     Executors.newCachedThreadPool());

		 /*
		  * Create the bootstrap, which wraps the Channels, ChannelFactory and the
		  * ChannelPipeline into one object.
		  */
		 ServerBootstrap bootstrap = new ServerBootstrap(channelFactory);

		 // Set up the pipeline factory.
		 bootstrap.setPipelineFactory(new SimpleChannelPipelineFactory());

		 // Bind and start to accept incoming connections.
		bootstrap.bind(new InetSocketAddress("localhost", 8080));
		 LOGGER.info("Done Binding in Communication Bootstrap, ready to accept clients");
	}

}
