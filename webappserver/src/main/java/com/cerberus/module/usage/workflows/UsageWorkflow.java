package com.cerberus.module.usage.workflows;

import java.util.ArrayList;

import java.util.List;

import com.cerberus.model.account.bean.User;
import com.cerberus.model.usage.bean.CurrentHourView;
import com.cerberus.module.generic.workflows.Workflow;
import com.cerberus.service.system.SystemService;
import com.cerberus.service.usage.ConsumptionService;

public class UsageWorkflow extends Workflow {

	public List<Integer> getCurrentConsumptionForUser(User user){

		//Get the System that the user belongs
		SystemService systemService = serviceFactory.getSystemService();

		//ConsumptionService consumptionService = serviceFactory.getConsumptionService();
		//List<Current> systemCurrentList = consumptionService.getCurrentListBySystemId(system.getId());



		return null;

	}

	public Integer[] getCurrentByHourForLast24h(User user){

		//Get the System that the user belongs
		SystemService systemService = serviceFactory.getSystemService();
		Integer systemId = systemService.getSystemIdByUserId(user.getId());

		ConsumptionService consumptionService = serviceFactory.getConsumptionService();
		List<CurrentHourView> currentHourViewList = consumptionService.getCurrentHourForLast24h(systemId);
		Integer[] currentHourList = new Integer[24];

		//Add the current hour to the list and handle the potential missing values.
		for(CurrentHourView currentHour: currentHourViewList){
			Integer index = currentHour.getHour();
			Integer current = currentHour.getCurrentHour();
			currentHourList[index] = current;
		}

		return currentHourList;	
	}

}
