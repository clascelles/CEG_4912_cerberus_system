package com.cerberus.server;

import java.util.logging.Logger;

import com.cerberus.server.bootstrap.CerberusServerBootstrap;
import com.cerberus.server.logging.ServerLogger;

public class ServerConnection {

	private final static String LOG_FILE = "Log.txt";

	//Get Logger
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public static void main (String[] args){

		ServerLogger.setup(LOG_FILE);
		LOGGER.info("Server Started.");		

		// Bootstrap the server.
		CerberusServerBootstrap bootstrap = new CerberusServerBootstrap();
		bootstrap.start();
	}
}
