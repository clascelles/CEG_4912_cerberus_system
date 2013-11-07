package com.cerberus.module.usage.workflows;

import java.util.Date;
import java.util.List;

import com.cerberus.model.account.bean.User;
import com.cerberus.model.usage.bean.CurrentDayView;
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

	public double[] getCurrentByHourForDay(User user, Date selectedDate){

		//Get the System that the user belongs
		SystemService systemService = serviceFactory.getSystemService();
		Integer systemId = systemService.getSystemIdByUserId(user.getId());

		ConsumptionService consumptionService = serviceFactory.getConsumptionService();
		List<CurrentHourView> currentHourViewList = consumptionService.getCurrentHourForDay(systemId, selectedDate);
		double[] currentHourList = new double[24];

		//Add the current hour to the list and handle the potential missing values.
		for(CurrentHourView currentHour: currentHourViewList){
			currentHourList[currentHour.getHour()] = currentHour.getCurrentHour();
		}

		return currentHourList;
	}
	
	public double[] getCurrentByDayForMonth(User user, Date selectedDate, Integer days){

		//Get the System that the user belongs
		SystemService systemService = serviceFactory.getSystemService();
		Integer systemId = systemService.getSystemIdByUserId(user.getId());

		ConsumptionService consumptionService = serviceFactory.getConsumptionService();
		List<CurrentDayView> currentDayViewList = consumptionService.getCurrentDayForMonth(systemId, selectedDate);
		double[] currentDayList = new double[days];

		//Add the current hour to the list and handle the potential missing values.
		for(CurrentDayView currentDay: currentDayViewList){
			currentDayList[currentDay.getDay()-1] = currentDay.getCurrentDay();
		}

		return currentDayList;	
	}

}
