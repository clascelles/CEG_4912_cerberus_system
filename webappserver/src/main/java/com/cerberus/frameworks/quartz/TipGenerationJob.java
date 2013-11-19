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
		List<Tip> tips = usageWorkflow.getTipsWithRules();
		
		for(int i=0; i<tips.size(); i++){
			Tip tip = tips.get(i);
			List<Integer> currentList = TipRuleEngine.applyRules(tip);
			if(currentList.size() > 0){
				List<Integer> systemList = usageWorkflow.getSystemList(currentList);
				for(int j=0; j<systemList.size(); j++){
					usageWorkflow.insertSystemTip(tip.getId(), systemList.get(j));
				}
			}
		}
		
		
	}
}