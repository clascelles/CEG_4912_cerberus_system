package com.cerberus.bootstrap;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class StartDaemonServerJob extends QuartzJobBean {
	private CerberusServerBootstrap startServerTask;

	public void setStartServerTask(CerberusServerBootstrap startServerTask) {
		this.startServerTask = startServerTask;
	}

	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {

		startServerTask.run();

	}
}