package com.cerberus.module.account.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cerberus.frameworks.logging.CerberusLogger;
import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.account.bean.Login;
import com.cerberus.model.account.bean.User;
import com.cerberus.model.system.bean.CerberusSystem;
import com.cerberus.module.account.backingobjects.NewAccountBackingObject;
import com.cerberus.module.account.constants.AccountConstants;
import com.cerberus.module.account.workflows.AccountWorkflow;
import com.cerberus.module.generic.controllers.CerberusController;
import com.cerberus.module.system.workflows.SystemWorkflow;

@Controller
public class NewAccountController extends CerberusController {

	@RequestMapping(value="create", method=RequestMethod.GET)
	public String getCreateAccountPage(HttpServletRequest request, Model model,
			@ModelAttribute(AccountConstants.NEW_ACCOUNT_BACKING_OBJECT) NewAccountBackingObject newAccountBackingObject)	{

		if(newAccountBackingObject == null) {
			newAccountBackingObject = new NewAccountBackingObject();
		}
		System.out.println("ERROR: " + newAccountBackingObject.getError());

		model.addAttribute(AccountConstants.NEW_ACCOUNT_BACKING_OBJECT, newAccountBackingObject);

		CerberusLogger.get("/create");

		return "create";
	}

	@RequestMapping(value="create", method=RequestMethod.POST)
	public String createPost(Model model,
			final RedirectAttributes redirectAttrs,
			@ModelAttribute(AccountConstants.NEW_ACCOUNT_BACKING_OBJECT) NewAccountBackingObject newAccountBackingObject,
			HttpServletRequest request)	{

		CerberusLogger.post("/create");
		System.out.println(newAccountBackingObject.getUsername() + ":" + newAccountBackingObject.getPassword());
		AccountWorkflow accountWorkflow = CerberusApplicationContext.getWorkflows().getAccountWorkflow();
		SystemWorkflow systemWorkflow = CerberusApplicationContext.getWorkflows().getSystemWorkflow();

		// Check if username and password fields are not empty
		if(accountWorkflow.isAccountValid(newAccountBackingObject)) {

			// Check if username is unique
			if(accountWorkflow.isUsernameUnique(newAccountBackingObject.getUsername())) {

				// Create new system for account
				CerberusSystem system = systemWorkflow.createNewSystem(newAccountBackingObject.getFirstname());
				if(system != null) {

					// Create account as sys owner of the system
					accountWorkflow.createNewUser(newAccountBackingObject, system);

					// Try to login new user
					Login userLogin = accountWorkflow.getLoginInstance(newAccountBackingObject.getUsername(), newAccountBackingObject.getPassword());
					if (userLogin == null){
						newAccountBackingObject.setError("Unable to login with your new account. Please contact customer support for more help.");
						redirectAttrs.addFlashAttribute(AccountConstants.NEW_ACCOUNT_BACKING_OBJECT, newAccountBackingObject);
						return "redirect:/create";
					}
					User user = accountWorkflow.getUserByLogin(userLogin);
					request.getSession().setAttribute("user", user);

				} else {

					// Couldn't create system for some reason
					newAccountBackingObject.setError("Unable to generate system for the user. Please contact customer support for more help.");
					redirectAttrs.addFlashAttribute(AccountConstants.NEW_ACCOUNT_BACKING_OBJECT, newAccountBackingObject);
					return "redirect:/create";
				}
			} else {

				// Username not unique
				newAccountBackingObject.setError("Your account username is not unique. Please select a different username.");
				redirectAttrs.addFlashAttribute(AccountConstants.NEW_ACCOUNT_BACKING_OBJECT, newAccountBackingObject);
				return "redirect:/create";
			}
		} else {

			// Username or password field is empty
			newAccountBackingObject.setError("Please input a valid username and password.");
			redirectAttrs.addFlashAttribute(AccountConstants.NEW_ACCOUNT_BACKING_OBJECT, newAccountBackingObject);
			return "redirect:/create";
		}

		return "redirect:/home/index";
	}

	@RequestMapping(value="cancel", method=RequestMethod.POST)
	public String cancelPost(Model model,
			@ModelAttribute(AccountConstants.NEW_ACCOUNT_BACKING_OBJECT) NewAccountBackingObject newAccountBackingObject,
			HttpServletRequest request)	{

		return "redirect:/";
	}
}
