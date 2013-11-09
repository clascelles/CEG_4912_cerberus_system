package com.cerberus.frameworks.quartz;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.cerberus.frameworks.spring.CerberusApplicationContext;

public class DataAggregationJob extends QuartzJobBean {

	private final static Logger LOGGER = Logger.getLogger(DataAggregationJob.class);
	
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {

		LOGGER.info("Data Aggregation Triggered");
		
		CerberusApplicationContext.getWorkflows().getUsageWorkflow().updateCurrentHour(new Date());
		
		
	}
}