package com.cerberus.module.usage.workflows;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.joda.time.DateTime;

import com.cerberus.model.account.bean.User;
import com.cerberus.model.outlets.bean.Current;
import com.cerberus.model.outlets.bean.Socket;
import com.cerberus.model.usage.bean.CurrentDayView;
import com.cerberus.model.usage.bean.CurrentHourView;
import com.cerberus.model.usage.bean.SocketCurrentHourView;
import com.cerberus.model.usage.bean.SystemTip;
import com.cerberus.model.usage.bean.Tip;
import com.cerberus.module.generic.workflows.Workflow;
import com.cerberus.module.usage.constants.UsageConstants;
import com.cerberus.service.system.SystemService;
import com.cerberus.service.usage.ConsumptionService;

public class UsageWorkflow extends Workflow {

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
	
	public double[] getSocketCurrentByHourForDay(Socket socket, Date selectedDate){

		ConsumptionService consumptionService = serviceFactory.getConsumptionService();
		List<SocketCurrentHourView> currentHourViewList = consumptionService.getSocketCurrentHourForDay(socket.getId(), selectedDate);
		double[] currentHourList = new double[24];

		//Add the current hour to the list and handle the potential missing values.
		for(SocketCurrentHourView currentHour: currentHourViewList){
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

	public void updateCurrentHour(Date date){
		DateTime threshold = new DateTime(date.getTime()).minusDays(UsageConstants.KEEP_FOR_DAYS);
		ConsumptionService consumptionService = serviceFactory.getConsumptionService();

		consumptionService.updateCurrentHour(threshold);
		consumptionService.deleteCurrentByThreshold(threshold);
	}
	
	public List<Tip> getTipsWithRules(){
		ConsumptionService consumptionService = serviceFactory.getConsumptionService();
		return consumptionService.getTipsWithRules();
	}
	
	public List<Tip> getTipsWithoutRules(){
		ConsumptionService consumptionService = serviceFactory.getConsumptionService();
		return consumptionService.getTipsWithoutRules();
	}
	
	public Current getCurrentForSocket(Socket socket) {
		ConsumptionService consumptionService = serviceFactory.getConsumptionService();
		List<Current> currents = consumptionService.getCurrentBySocketId(socket.getId());
		
		if(currents.isEmpty()) {
			return null;
		}
		
		Current mostRecent = null;
		for(Current current : currents) {
			if((mostRecent == null) 
				|| (current.getTimestamp().before(mostRecent.getTimestamp()))) {
				mostRecent = current;
			}
		}
		return mostRecent;
	}
	
	public String getCurrentUsageForSocket(Socket socket) {
		Current current = getCurrentForSocket(socket);
		if(current == null) {
			return "0 kWh";
		} else {
			return current.getCurrent() + " kWh";			
		}
	}

	public List<Integer> matchCurrentUsage(DetachedCriteria criteria) {
		ConsumptionService consumptionService = serviceFactory.getConsumptionService();
		return consumptionService.listCurrent(criteria);
		
	}
	
	public List<Integer> getSystemList(List<Integer> currentList){
		ConsumptionService consumptionService = serviceFactory.getConsumptionService();
		return consumptionService.getSystemListFromCurrentList(currentList);
	}
	
	public Integer insertSystemTip(Integer tipId, Integer systemId ){
		ConsumptionService consumptionService = serviceFactory.getConsumptionService();
		return consumptionService.insertSystemTip(new SystemTip(systemId, tipId));
	}
	
	public List<Tip> getLatest10Tips(Integer systemId){
		ConsumptionService consumptionService = serviceFactory.getConsumptionService();
		List<Tip> tips = new ArrayList<Tip>(10);
		List<Integer> tipIds = consumptionService.getSystemTipIdList(systemId, 10);
		for(Integer id: tipIds){
			tips.add(consumptionService.getTipsById(id));
		}
		return tips;
	}
	
	public List<SystemTip> getLatest10SystemTips(Integer systemId){
		ConsumptionService consumptionService = serviceFactory.getConsumptionService();
		return consumptionService.getSystemTipList(systemId, 10);
	}
	
	public List<Integer> getSystemIds(){
		return serviceFactory.getSystemService().getAllSystemIds();
	}

}
