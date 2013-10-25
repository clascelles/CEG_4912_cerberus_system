package com.cerberus.module.usage.controllers;

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

@Controller
public class UsageController extends CerberusController {

	private static final String TOP_BAR_BACKING_OBJECT = "topBarBackingObject";
	
	@RequestMapping(value="/usage/index", method=RequestMethod.GET)
	public String getLoginPage(Model model)	{
		
		User user = getUser();		
		if(user == null){
			return CerberusConstants.REDIRECT;
		}		
		initTopBar(model, user);
		
		TopBarBackingObject topBarBackingObject = new TopBarBackingObject();
		topBarBackingObject.setName(user.getInformation().getFirstName() + " " + user.getInformation().getLastName());
		
		model.addAttribute(TOP_BAR_BACKING_OBJECT, topBarBackingObject);
		
		OutletWorkflow outletWorkflow = CerberusApplicationContext.getWorkflows().getOutletWorkflow();
		
		
		return "usage/index";
	}
	
	@RequestMapping(value="/usage/index", method=RequestMethod.POST)
	public String post(Model model)	{
		return null;
		
	}

}
