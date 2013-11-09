package com.cerberus.frameworks.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.cerberus.daemon.scheduling.CerberusScheduler;

public class EventSchedulingJob extends QuartzJobBean {
	
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		
		// Scheduler Bootstrap		
		ClassPathResource res = new ClassPathResource("dynamic-jobs.xml");
        XmlBeanFactory factory = new XmlBeanFactory(res);

        //get the quartzFactory bean
        Scheduler scheduler = (Scheduler) factory.getBean("scheduler");

        CerberusScheduler cerberusScheduler = new CerberusScheduler();
        cerberusScheduler.init(scheduler);
        cerberusScheduler.start();

	}
}