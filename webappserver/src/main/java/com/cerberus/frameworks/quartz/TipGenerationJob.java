package com.cerberus.frameworks.quartz;

import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.cerberus.daemon.tips.TipRuleEngine;
import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.usage.bean.Tip;
import com.cerberus.module.usage.workflows.UsageWorkflow;


public class TipGenerationJob extends QuartzJobBean {

	private final static Logger LOGGER = Logger.getLogger(TipGenerationJob.class);
	
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {

		LOGGER.info("Tip Generator Triggered");
		
		UsageWorkflow usageWorkflow = CerberusApplicationContext.getWorkflows().getUsageWorkflow();
		
		//TODO: Get all the tips objects which have rules
		List<Tip> tips = usageWorkflow.getTips();
		
		for(int i=0; i<tips.size(); i++){
			List<Integer> currentList = TipRuleEngine.applyRules(tips.get(i));
			System.out.println(currentList.toString());
			//Match the list to systems
			//Add the Syste_Tip object for each system
						
		}
		
		
	}
}