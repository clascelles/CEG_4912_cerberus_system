package com.cerberus.module.usage.workflows;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.joda.time.DateTime;

import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.account.bean.User;
import com.cerberus.model.outlets.bean.Current;
import com.cerberus.model.outlets.bean.Socket;
import com.cerberus.model.usage.bean.CurrentDayView;
import com.cerberus.model.usage.bean.CurrentHourView;
import com.cerberus.model.usage.bean.SocketCurrentHourView;
import com.cerberus.model.usage.bean.SystemTip;
import com.cerberus.model.usage.bean.Tip;
import com.cerberus.module.generic.workflows.Workflow;
import com.cerberus.module.outlets.workflows.OutletWorkflow;
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

	public double[] getCostSavingsForDay(User user, Date selectedDate){

		double peakRate = 0.129;
		double midPeakRate = 0.109;
		double offPeakRate = 0.072;

		List<Integer> peak = new ArrayList<Integer>();
		List<Integer> midPeak = new ArrayList<Integer>();

		peak.add(7); 	peak.add(8);	peak.add(9);	peak.add(10);

		midPeak.add(11); midPeak.add(12); midPeak.add(13);
		midPeak.add(14); midPeak.add(15); midPeak.add(16);

		peak.add(17); peak.add(18);

		//Get the System that the user belongs
		SystemService systemService = serviceFactory.getSystemService();
		Integer systemId = systemService.getSystemIdByUserId(user.getId());

		ConsumptionService consumptionService = serviceFactory.getConsumptionService();
		List<CurrentHourView> currentHourViewList = consumptionService.getCurrentHourForDay(systemId, selectedDate);

		double[] costSavings = new double[2];

		//Add the current hour to the list and handle the potential missing values.
		for(CurrentHourView currentHour : currentHourViewList){
			Double cost = 0.0;
			Double savings = 0.0;
			Double usage = currentHour.getCurrentHour();

			// if weekend
			if(currentHour.getTimestampHour().getDay() == 0 ||
					currentHour.getTimestampHour().getDay() == 6) {

				cost = usage * offPeakRate;
				savings = usage * (peakRate - offPeakRate);

			// if weekday
			} else {

				if(peak.contains(currentHour.getHour())) {
					cost = usage * peakRate;
				} else if(midPeak.contains(currentHour.getHour())) {
					cost = usage * midPeakRate;
					savings = usage * (peakRate - midPeakRate);
				} else {
					cost = usage * offPeakRate;
					savings = usage * (peakRate - offPeakRate);
				}

			}

			costSavings[0] += cost;
			costSavings[1] += savings;
		}

		NumberFormat formatter = new DecimalFormat();
		formatter.setMaximumFractionDigits(3);
		costSavings[0] = Double.parseDouble(formatter.format(costSavings[0]));
		costSavings[1] = Double.parseDouble(formatter.format(costSavings[1]));

		return costSavings;
	}

	public double[] getCostSavingsForMonth(User user, Date selectedDate){

		List<Date> dates = new ArrayList<Date>();

		for(int i=1; i<selectedDate.getDate()+1; i++) {
			dates.add(new Date(selectedDate.getYear(), selectedDate.getMonth(), i, 0, 0));
		}

		double[] costSavings = new double[2];
		costSavings[0] = 0.0;
		costSavings[1] = 0.0;

		for(Date date : dates) {
			double[] cs = getCostSavingsForDay(user, date);
			costSavings[0] += cs[0];
			costSavings[1] += cs[1];
		}

		return costSavings;
	}

	public void updateCurrentHour(Date date){
		DateTime threshold = new DateTime(date.getTime()).minusDays(UsageConstants.KEEP_FOR_DAYS);
		threshold = threshold.minusMinutes(threshold.getMinuteOfDay());
		threshold = threshold.minusSeconds(threshold.getSecondOfMinute());

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
		return consumptionService.getMostRecentCurrentBySocketId(socket.getId());
	}

	public String getCurrentUsageForSocket(Socket socket) {
		Current current = getCurrentForSocket(socket);
		if(current == null) {
			return "0 W/s";
		} else {
			return current.getCurrent() + " W/s";
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

	public Double getCurrentTotalUsage(User user) {
		OutletWorkflow outletWorkflow = CerberusApplicationContext.getWorkflows().getOutletWorkflow();
		List<Socket> sockets = outletWorkflow.getSocketsByUser(user);

		ConsumptionService consumptionService = serviceFactory.getConsumptionService();

		Date oneMinuteAgo = new Date(new Date().getTime() - 1000*30);

		Double total = 0.0;

		for(Socket socket : sockets) {
			List<Current> currents = consumptionService.getCurrentBySocketId(socket.getId());

			for(Current current : currents) {
				if(current.getTimestamp().after(oneMinuteAgo)) {
					total += current.getCurrent();
				}
			}
		}

		return total;
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
