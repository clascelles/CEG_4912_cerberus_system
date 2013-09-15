package com.cerberus.module.overview.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cerberus.model.account.bean.User;
import com.cerberus.module.generic.controllers.CerberusController;
import com.cerberus.module.overview.backingobjects.TopBarBackingObject;

@Controller
@RequestMapping(value="/home/index")
public class OverviewController extends CerberusController {

	private static final String TOP_BAR_BACKING_OBJECT = "topBarBackingObject";
	
	@RequestMapping(method=RequestMethod.GET)
	public String getLoginPage(Model model)
			//This is how you can retrieve the object from the redirectAttrs.addFlashAttribute() method. It behaves exactly
			//like a model attribute at this point.
			//@ModelAttribute("user") User user 
	{
		
		//Get the User object from the "bin"
		User user = (User) bin.get("user");
		
		//This is our Login Security. I know, not that great but good enough for a site that will never be published.
		if(user == null){
			return "redirect:/";
		}
		
		TopBarBackingObject topBarBackingObject = new TopBarBackingObject();
		topBarBackingObject.setName(user.getInformation().getFirstName() + " " + user.getInformation().getLastName());
		
		model.addAttribute(TOP_BAR_BACKING_OBJECT, topBarBackingObject);
		
		return "home/index";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String post(Model model)	{
		return null;
		
	}

}
