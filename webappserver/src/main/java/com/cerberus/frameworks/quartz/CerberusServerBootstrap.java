package com.cerberus.frameworks.quartz;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.cerberus.daemon.executor.ServiceBootstrap;
import com.cerberus.daemon.scheduling.SchedulerBootstrap;
import com.cerberus.frameworks.netty.CommunicationBootstrap;
import com.cerberus.frameworks.spring.ServerContext;

public class CerberusServerBootstrap extends Thread {

	
	private static String SERVER_ROOT;
	private final static String LOG4J_XML = "WEB-INF\\classes\\log4j.xml";
	private final static Logger LOGGER = Logger.getLogger(CerberusServerBootstrap.class);

	@Override
	public void run() {
		
		//Get the Server ROOT directory.
		SERVER_ROOT = ServerContext.getServerRootUrl();
		
		DOMConfigurator.configure(SERVER_ROOT + LOG4J_XML);

		LOGGER.info("Bootstrapping the Cerberus server.");
		// Start all bootstrap threads here

		// Executor Services Bootstrap
		ServiceBootstrap service = new ServiceBootstrap();
		service.start();

		// Netty Communication Bootstrap
		CommunicationBootstrap communication = new CommunicationBootstrap();
		communication.start();
		
		// Scheduler Bootstrap
		SchedulerBootstrap scheduler = new SchedulerBootstrap();
		scheduler.start();
	}
}
