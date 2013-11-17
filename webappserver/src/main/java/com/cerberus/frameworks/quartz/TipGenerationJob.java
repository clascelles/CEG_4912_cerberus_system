package com.cerberus.frameworks.quartz;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.usage.bean.Rule;
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
		
		Set<Rule> rules = tips.get(0).getRules();
		Iterator<Rule> it = rules.iterator();
		for(int i=0; i<rules.size(); i++){
			if(it.hasNext()){
				System.out.println(it.next().toString());
			}
		}
		
		
		//foreach tip, try to find a current entry which match that tip
		
		//Generate a random tip from the tips which do not have rules.
		
		
	}
}