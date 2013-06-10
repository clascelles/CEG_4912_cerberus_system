package com.cerberus.bootstrap;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class CerberusServerBootstrap extends Thread {

	private final static String LOG4J_XML = "src/main/resource/log4j.xml";
	private final static Logger LOGGER = Logger.getLogger(CerberusServerBootstrap.class);

	@Override
	public void run() {

		DOMConfigurator.configure(LOG4J_XML);

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
