package com.cerberus.frameworks.quartz;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.module.usage.workflows.UsageWorkflow;


public class TipGenerationJob extends QuartzJobBean {

	private final static Logger LOGGER = Logger.getLogger(TipGenerationJob.class);
	
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {

		LOGGER.info("Tip Generator Triggered");
		
		UsageWorkflow usageWorkflow = CerberusApplicationContext.getWorkflows().getUsageWorkflow();
		
		//TODO: Get all the tips objects which have rules
		//List<Tip>
		
		//foreach tip, try to find a current entry which match that tip
		
		//Generate a random tip from the tips which do not have rules.
		
		
	}
}