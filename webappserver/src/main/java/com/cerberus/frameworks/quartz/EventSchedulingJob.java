package com.cerberus.frameworks.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class EventSchedulingJob extends QuartzJobBean {

	
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {

		System.out.println("Event Scheduling Triggered");

	}
}