package com.cerberus.module.usage.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.account.bean.User;
import com.cerberus.module.generic.constants.CerberusConstants;
import com.cerberus.module.generic.controllers.CerberusController;
import com.cerberus.module.usage.backingobjects.UsageBackingObject;
import com.cerberus.module.usage.constants.UsageConstants;
import com.cerberus.module.usage.workflows.UsageWorkflow;

@Controller
public class UsageController extends CerberusController {

	@RequestMapping(value=CerberusConstants.USAGE_VIEW, method=RequestMethod.GET)
	public String getUsagePage(Model model,  HttpServletRequest request)	{
		
		return buildUsagePage(model, new UsageBackingObject(), request);
	}

	@RequestMapping(value=CerberusConstants.USAGE_VIEW, method=RequestMethod.POST)
	public String postUsageOptions(Model model, @ModelAttribute(UsageConstants.USAGE_OPTIONS) UsageBackingObject usageOptions,  HttpServletRequest request)	{

		return buildUsagePage(model, usageOptions, request);

	}

	private String buildUsagePage(Model model, UsageBackingObject usageOptions,  HttpServletRequest request){

		User user = getUser(request);

		if(user == null){
			return CerberusConstants.REDIRECT;
		}
		initTopBar(model, user);

		UsageWorkflow usageWorkflow = CerberusApplicationContext.getWorkflows().getUsageWorkflow();

		//Get current comsumption per hour for the last 24 hours.
		double[] currentList;
		
		switch(usageOptions.getTimeSpan()){
		case 1:
			currentList = usageWorkflow.getCurrentByHourForDay(user, usageOptions.getSelectedDate());
			usageOptions.setGraphForDay();
			break;
		case 2:
			DateTime tempDate = new DateTime(usageOptions.getSelectedDate());
			DateTime beginningOfMonth = new DateTime(tempDate.getYear(), tempDate.getMonthOfYear(), 1, 0, 0);
			usageOptions.setNumberOfDataPoints(beginningOfMonth.plusMonths(1).minusDays(1).getDayOfMonth());
			usageOptions.setGraphForMonth();
			currentList = usageWorkflow.getCurrentByDayForMonth(user, new Date(beginningOfMonth.getMillis()), usageOptions.getNumberOfDataPoints());
			break;
		default:
			currentList = null;
		}

		usageOptions.setMaximumYAxisValue(maxValue(currentList));

		//Conversion of the current array to String
		String currentListString = arrayToJavascript(currentList);
		
		model.addAttribute(UsageConstants.USAGE_OPTIONS, usageOptions);
		model.addAttribute(UsageConstants.CURRENT_HOUR_LIST, currentListString);

		return "usage/index";
	}
	
	public static String arrayToJavascript(double values[]){
		StringBuilder stringValues = new StringBuilder(150);
		
		for(int i=0; i<values.length; i++){
			stringValues.append(values[i]);
			if((i+1) < values.length){
				stringValues.append(",");
			}
		}
		
		
		return stringValues.toString();
	}
	
	public static Integer maxValue(double values[]){
		double max = 0.0;
		
		for(int i=0; i<values.length; i++){
			if(values[i] > max){
				max = values[i];
			}
		}

		return (int) Math.ceil(max);
	}

}
