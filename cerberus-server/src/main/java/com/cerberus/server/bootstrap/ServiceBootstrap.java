package com.cerberus.server.bootstrap;

import java.util.logging.Logger;

import com.cerberus.server.service.executor.ExecutorServiceFactory;

public class ServiceBootstrap extends Thread {

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	@Override
	public void run() {

		// Creates all the thread pools with default pool count of 10.
		// Also available is the ExecutorServiceFactory(int, int, int)
		// constructor
		new ExecutorServiceFactory();
		LOGGER.info("Started the ExecutorServiceFactory.");

	}

}
