package com.cerberus.server.bootstrap;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class CerberusServerBootstrap extends Thread {

	private final static String LOG4J_PROPERTIES = "log4j.properties";
	private final static Logger LOGGER = Logger.getLogger(CerberusServerBootstrap.class);

	@Override
	public void run() {

		PropertyConfigurator.configure(LOG4J_PROPERTIES);

		LOGGER.info("Bootstrapping the Cerberus server.");
		// Start all bootstrap threads here

		// Executor Services Bootstrap
		ServiceBootstrap service = new ServiceBootstrap();
		service.start();

		// Netty Communication Bootstrap
		CommunicationBootstrap communication = new CommunicationBootstrap();
		communication.start();

	}
}
