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
		
		ClassPathResource res = new ClassPathResource("dynamic-jobs.xml");
        XmlBeanFactory factory = new XmlBeanFactory(res);

        //get the quartzFactory bean
        Scheduler scheduler = (Scheduler) factory.getBean("scheduler");

        CerberusScheduler cerberusScheduler = new CerberusScheduler();
        cerberusScheduler.init(scheduler, factory);
        cerberusScheduler.start();
        
        LOGGER.info("Done Scheduler Bootstrap, ready to schedule events");
	}
	
}
