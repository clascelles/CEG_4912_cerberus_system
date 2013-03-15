package com.cerberus.server;

import java.util.logging.Logger;

import com.cerberus.server.communication.CommunicationBootstrap;
import com.cerberus.server.logging.ServerLogger;
import com.cerberus.server.service.executor.ExecutorServiceFactory;

public class ServerConnection {

	//Get Logger
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);  
			
	public static void main (String[] args){
				
		//Setup the logging functions and formatting
		ServerLogger.setup("Log.txt");
		LOGGER.info("Server Started.");
		
		//Creates all the thread pools with default pool count of 10.
		//Also available is the ExecutorServiceFactory(int, int, int) constructor
		new ExecutorServiceFactory();
		LOGGER.info("Started the ExecutorServiceFactory.");
		
		//Start the Netty communication Bootstrap.
		CommunicationBootstrap communication = new CommunicationBootstrap();
		LOGGER.info("Starting Communication Initialization Thread");
		communication.start();
	}
}
