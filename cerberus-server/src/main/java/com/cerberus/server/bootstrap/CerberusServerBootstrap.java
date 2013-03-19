package com.cerberus.server.bootstrap;

import java.util.logging.Logger;


public class CerberusServerBootstrap extends Thread {

	private final static Logger LOGGER = Logger
			.getLogger(Logger.GLOBAL_LOGGER_NAME);

	@Override
	public void run() {

		LOGGER.info("Bootsrapping the Cerberus server.");
		// Start all bootstrap threads here

		// Executor Services Bootstrap
		ServiceBootstrap service = new ServiceBootstrap();
		service.start();

		// Netty Communication Bootstrap
		CommunicationBootstrap communication = new CommunicationBootstrap();
		communication.start();

	}
}
