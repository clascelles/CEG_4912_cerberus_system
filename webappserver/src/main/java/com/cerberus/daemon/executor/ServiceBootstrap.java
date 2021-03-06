package com.cerberus.daemon.executor;

import org.apache.log4j.Logger;


public class ServiceBootstrap extends Thread {

	private final static Logger LOGGER = Logger.getLogger(ServiceBootstrap.class);

	@Override
	public void run() {

		// Creates all the thread pools with default pool count of 10.
		// Also available is the ExecutorServiceFactory(int, int, int, int)
		// constructor
		new ExecutorServiceFactory(1, 8, 1, 1);
		LOGGER.info("Started the ExecutorServiceFactory.");

	}

}
