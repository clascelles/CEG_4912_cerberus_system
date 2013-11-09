package com.cerberus.frameworks.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class ScheduledEventJob extends QuartzJobBean {
	private ScheduledEventTask scheduledEventTask;

	public void setStartServerTask(ScheduledEventTask scheduledEventTask) {
		this.scheduledEventTask = scheduledEventTask;
	}

	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {

		scheduledEventTask.execute();

	}
}