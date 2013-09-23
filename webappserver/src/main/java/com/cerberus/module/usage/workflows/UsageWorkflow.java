package com.cerberus.module.usage.workflows;

import java.util.List;

import com.cerberus.model.account.bean.User;
import com.cerberus.module.generic.workflows.Workflow;
import com.cerberus.service.system.SystemService;
public class UsageWorkflow extends Workflow {
	
	public List<Integer> getCurrentConsumptionForUser(User user){
		
		//Get the System that the user belongs
		SystemService systemService = serviceFactory.getSystemService();
		
		//ConsumptionService consumptionService = serviceFactory.getConsumptionService();
		//List<Current> systemCurrentList = consumptionService.getCurrentListBySystemId(system.getId());
		
		
		
		return null;
	
	}

}
