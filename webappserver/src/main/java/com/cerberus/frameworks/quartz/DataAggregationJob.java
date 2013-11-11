package com.cerberus.frameworks.quartz;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.cerberus.frameworks.netty.ChannelOutletBinding;
import com.cerberus.frameworks.spring.CerberusApplicationContext;

public class DataAggregationJob extends QuartzJobBean {

	private final static Logger LOGGER = Logger.getLogger(DataAggregationJob.class);
	
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {

		LOGGER.info("Data Aggregation Triggered");
		
		while(!ChannelOutletBinding.isChannelBinded("001DC911B00A")){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		CerberusApplicationContext.getWorkflows().getUsageWorkflow().updateCurrentHour(new Date());
		
		
	}
}