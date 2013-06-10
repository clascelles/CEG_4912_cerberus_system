package com.cerberus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cerberus.persistence.beans.User;

@Controller
@RequestMapping(value="/home/overview")
public class OverviewController extends CerberusController {

	
	@RequestMapping(method=RequestMethod.GET)
	public String getLoginPage(Model model) {
		
		//Get the User object from the "bin"
		User user = (User) bin.get("user");
		user.getId();
		
		//TO DO Build the overview page here
		
		return "home/overview";
	}

}
