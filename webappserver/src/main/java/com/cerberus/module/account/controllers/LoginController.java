package com.cerberus.module.account.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.account.bean.Login;
import com.cerberus.model.account.bean.User;
import com.cerberus.module.account.backingobjects.LoginBackingObject;
import com.cerberus.module.account.workflows.AccountWorkflow;
import com.cerberus.module.generic.controllers.CerberusController;

@Controller
@RequestMapping(value="/")
public class LoginController extends CerberusController {
	
	//Model Attribute Name. Use a non-modifiable String constant so that the name set in the GET function can
	//be accessed in the POST function.
	private static final String LOGIN_BACKING_OBJECT = "loginBackingObject";
	
	//There is a "bin" Hashmap variable that was created in the parent class to have access to the browser session.
	//Any objects like the logged in user which needs to be accessed at any place in the site can be put in the session.
	//However, be careful using this. The session variable is a per browser thing so the same variables or information can
	//be accessed or overwritten by two different browser tabs.
	//protected HashMap<String, Object> bin;
	
	//The @RequestMapping can also be done at the method level if the same controller handles more than one mapping.
	//Just add the value="" to the current annotation.
	@RequestMapping(method=RequestMethod.GET)
	public String getLoginPage(Model model) {

		//Add all the "backingObject" that will be used in the page. A backing object is simply an object that often match
		//closely a real object but which only has the field displayed in the View. For example, the loginBackingObject
		//has the username, password and a resetPassword boolean, which the Login object doesn't. The Login object also has
		//more information like the ID, the createdDate, etc.
		model.addAttribute(LOGIN_BACKING_OBJECT, new LoginBackingObject());
		
		return "login";
	}
	
	//POST occurs when submitting a form. It is used to handle the data inputed or changed in the form, do some pre-processing
	//of the information and any database query necessary. In this case, the POST method uses the LoginBackingObject to get the
	//full login object and with that get the User object, which it puts in the session "bin" variable.
	@RequestMapping(method=RequestMethod.POST)
	public String validateLogin(Model model, 
			//The RedirectAttributes is VERY IMPORTANT. It is used to pass all the info that is useful to build the next page
			//in the GET method of the next controller. Use the addFlashAttribute function. The object added to the redirectAttrs
			//will survive a redirect to the next page. Objects added to the Model will not!
			final RedirectAttributes redirectAttrs,
			//Add all the model attributes in a neat list here. 
			@ModelAttribute (LOGIN_BACKING_OBJECT) LoginBackingObject loginBackingObject,			
			BindingResult result) {
		
		//Check for error binding the model attributes to their respective objects
		if (result.hasErrors()) {
			return "login";
		}
		
		//Get the AccountWorkflow from the ApplicationContext.
		//You can get any already instantiated beans from Spring through the Application Context.
		
		//Example:
		//ApplicationContext ctx = CerberusApplicationContext.getApplicationContext();
		//Bean bean = ctx.getBean("bean", Bean.class);
		
		AccountWorkflow accountWorkflow = CerberusApplicationContext.getWorkflows().getAccountWorkflow();
	
		//Look for a Login with the parameters from the backing object
		Login userLogin = accountWorkflow.getLoginInstance(loginBackingObject);
		
		//Make sure that it found a matching Login by confirming 
		//that the Login object return is a good instance and not NULL
		if (userLogin == null){
			return "login";
		}
		
		//Get the User object to have all the User information that are useful like the
		//First Name, and User Type. 
		User user = accountWorkflow.getUserByLogin(userLogin);
		
		//Add the User object to the "bin" to keep it and share it between controllers.
		bin.put("user", user);
		
		//Could have used the addFlashAttribute so that it would survive the next redirect, but not the best way for the
		//user variable because you would have to add it to the model in the GET method, and pull it again in the POST, etc.
		//redirectAttrs.addFlashAttribute("user", user);

		
		return "redirect:/home/index";
	}
	
}
