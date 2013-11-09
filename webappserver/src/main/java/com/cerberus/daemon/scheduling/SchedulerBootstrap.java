package com.cerberus.daemon.scheduling;

import org.apache.log4j.Logger;
import org.quartz.Scheduler;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class SchedulerBootstrap extends Thread {
	
	private final static Logger LOGGER = Logger.getLogger(SchedulerBootstrap.class);

	@Override
	public void run(){
		
		LOGGER.info("Starting Scheduler Initialization Thread");
        
        LOGGER.info("Done Scheduler Bootstrap, ready to schedule events");
	}
	
}
