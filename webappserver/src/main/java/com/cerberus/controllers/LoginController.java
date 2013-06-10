package com.cerberus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cerberus.backingobjects.LoginBackingObject;
import com.cerberus.persistence.beans.Login;
import com.cerberus.persistence.beans.User;
import com.cerberus.workflow.userResquestHandling.AccountWorkflow;

@Controller
@RequestMapping(value="/")
public class LoginController extends CerberusController {
	
	private static final String LOGIN_BACKING_OBJECT = "loginBackingObject";
	
	//HashMap bin To use to pass 
	
	@RequestMapping(method=RequestMethod.GET)
	public String getLoginPage(Model model) {

		//Add all the "backingObject" that will be used in the page
		model.addAttribute(LOGIN_BACKING_OBJECT, new LoginBackingObject());
		
		return "welcome";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String validateLogin(LoginBackingObject loginBackingObject, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "welcome";
		}
		
		AccountWorkflow accountWorkflow = new AccountWorkflow();
		
		//Look for a Login with the parameters from the backing object
		Login userLogin = accountWorkflow.getLoginInstance(loginBackingObject);
		
		//Make sure that it found a matching Login by confirming 
		//that the Login object return is a good instance and not NULL
		if (userLogin == null){
			return "welcome";
		}
		
		//Get the User object to have all the User information that are useful like the
		//First Name, and User Type. 
		User user = accountWorkflow.getUserByLogin(userLogin);
		
		//Add the User object to the "bin" to keep it and share it between controllers.
		bin.put("user", user);
		
		return "redirect:/home/overview";
	}

	@RequestMapping(value="/forgot", method=RequestMethod.POST)
	public String forgotPassword( LoginBackingObject loginBackingObject, BindingResult result) {
		if (result.hasErrors()) {
			return "welcome";
		}
		
		//TO DO Send password to email address
		
		return "redirect:/welcome";
	}
	
}
