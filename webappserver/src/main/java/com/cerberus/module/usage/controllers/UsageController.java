package com.cerberus.module.usage.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.account.bean.User;
import com.cerberus.module.generic.constants.CerberusConstants;
import com.cerberus.module.generic.controllers.CerberusController;
import com.cerberus.module.outlets.workflows.OutletWorkflow;
import com.cerberus.module.overview.backingobjects.TopBarBackingObject;
import com.cerberus.module.usage.constants.UsageConstants;
import com.cerberus.module.usage.workflows.UsageWorkflow;

@Controller
public class UsageController extends CerberusController {
	
	@RequestMapping(value=CerberusConstants.USAGE_VIEW, method=RequestMethod.GET)
	public String getLoginPage(Model model)	{
		
		User user = getUser();		
		if(user == null){
			return CerberusConstants.REDIRECT;
		}		s
		initTopBar(model, user);
		s
		
		UsageWorkflow usageWorkflow = CerberusApplicationContext.getWorkflows().getUsageWorkflow();
		
		//Get current comsumption per hour for the last 24 hours.
		Integer[] currentHourList = usageWorkflow.getCurrentByHourForLast24h(user);
		
		model.addAttribute(UsageConstants.CURRENT_HOUR_LIST, currentHourList);
		
		return "usage/index";
	}
	
	@RequestMapping(value="/usage/index", method=RequestMethod.POST)
	public String post(Model model)	{
		return null;
		
	}

}
