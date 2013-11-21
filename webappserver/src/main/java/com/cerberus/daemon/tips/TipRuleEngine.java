package com.cerberus.daemon.tips;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;

import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.outlets.filter.CurrentFilter;
import com.cerberus.model.usage.bean.Rule;
import com.cerberus.model.usage.bean.Tip;
import com.cerberus.module.usage.workflows.UsageWorkflow;

public class TipRuleEngine {

	public static List<Integer> applyRules (Tip tip){
		
		Set<Rule> rules = tip.getRules();
		Iterator<Rule> it = rules.iterator();
		
		//Build the DetachedCriteria Filter from the Rules attached to the Tip.
		DetachedCriteria criteria = CurrentFilter.getDetachedCriteria();
		while(it.hasNext()){
			Rule rule = it.next();
			
			switch(rule.getRuleType()){
			case 1:
				criteria = CurrentFilter.addDateRestriction(criteria, rule.getOperator(), rule.getDate());
				break;
			case 2:
				criteria = CurrentFilter.addTimeRestriction(criteria, rule.getOperator(), rule.getTime());
				break;
			case 3:
				criteria = CurrentFilter.addConsumptionRestriction(criteria, rule.getOperator(), rule.getConsumption());
				break;
			case 4:
				criteria = CurrentFilter.addApplianceRestriction(criteria, rule.getOperator(), rule.getAppliance());
				break;
			default:
				//TODO Handle exception
				break;
			}
		}
		
		criteria.setProjection(Projections.property("id"));
		
		//Get the Consumption Service to do the processing
		UsageWorkflow usageWorkflow = CerberusApplicationContext.getWorkflows().getUsageWorkflow();
		return usageWorkflow.matchCurrentUsage(criteria);
	}
	
}
