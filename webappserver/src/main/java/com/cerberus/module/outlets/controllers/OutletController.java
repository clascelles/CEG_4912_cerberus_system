package com.cerberus.module.outlets.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.account.bean.User;
import com.cerberus.module.account.backingobjects.RoomBackingObject;
import com.cerberus.module.account.workflows.AccountWorkflow;
import com.cerberus.module.generic.controllers.CerberusController;
import com.cerberus.module.home.backingobjects.TopBarBackingObject;
import com.cerberus.module.outlets.backingobjects.OutletBackingObject;
import com.cerberus.module.outlets.workflows.OutletWorkflow;

@Controller
public class OutletController extends CerberusController {

	private static final String TOP_BAR_BACKING_OBJECT = "topBarBackingObject";
	private static final String OUTLET_BACKING_OBJECT = "outletBackingObject";
	private static final String ROOMS = "rooms";
		
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
		
		//Get the outlet list for the current user.
		AccountWorkflow accountWorkflow = CerberusApplicationContext.getWorkflows().getAccountWorkflow();
		List<RoomBackingObject> rooms = accountWorkflow.getRoomsForUser(user);
		model.addAttribute(ROOMS, rooms);
		
		System.out.println("loading outlets/index");
		
		return "outlets/index";
	}
	
	@RequestMapping(value = "/addOutlet", method=RequestMethod.POST)
	public String addButtonClicked(Model model)	{
		System.out.println("add button clicked");
		return null;		
	}
	
	@RequestMapping(value="/outlets/index", method=RequestMethod.POST)
	public String post(Model model)	{
		System.out.println("outlets/index generic post submitted");
		return null;		
	}
	
	@RequestMapping(params = "add", method = RequestMethod.POST)
	public String addOutlet(HttpServletRequest request, @ModelAttribute User user, BindingResult result, SessionStatus status) {
	    // validate your result
	    // if no errors, save it and redirect to successView.
		System.out.println("add outlet button clicked");
		return "ok";
	}

}
