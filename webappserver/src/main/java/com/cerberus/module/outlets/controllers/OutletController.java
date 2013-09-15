package com.cerberus.module.outlets.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.account.bean.User;
import com.cerberus.module.generic.controllers.CerberusController;
import com.cerberus.module.outlets.backingobjects.OutletBackingObject;
import com.cerberus.module.outlets.workflows.OutletWorkflow;
import com.cerberus.module.overview.backingobjects.TopBarBackingObject;

@Controller
public class OutletController extends CerberusController {

	private static final String TOP_BAR_BACKING_OBJECT = "topBarBackingObject";
	private static final String OUTLET_BACKING_OBJECT = "outletBackingObject";
	
	@RequestMapping(value="/outlets/index", method=RequestMethod.GET)
	public String getLoginPage(Model model)	{
		
		//Get the User object from the "bin"
		User user = (User) bin.get("user");
		
		//This is our Login Security. I know, not that great but good enough for a site that will never be published.
		if(user == null){
			return "redirect:/";
		}
		
		//Get user's full name for top bar display.
		TopBarBackingObject topBarBackingObject = new TopBarBackingObject();
		topBarBackingObject.setName(user.getInformation().getFirstName() + " " + user.getInformation().getLastName());
		model.addAttribute(TOP_BAR_BACKING_OBJECT, topBarBackingObject);
		
		//Get the outlet list for the current user.
		OutletWorkflow outletWorkflow = CerberusApplicationContext.getWorkflows().getOutletWorkflow();
		List<OutletBackingObject> outletUserList = outletWorkflow.getOutletFromUser(user);
		model.addAttribute(OUTLET_BACKING_OBJECT, outletUserList);
		
		return "outlets/index";
	}
	
	@RequestMapping(value="/outlets/index", method=RequestMethod.POST)
	public String post(Model model)	{
		return null;
		
	}

}
