package com.cerberus.module.system.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.message.CerberusLogger;
import com.cerberus.model.account.bean.User;
import com.cerberus.model.outlets.bean.Outlet;
import com.cerberus.model.outlets.bean.Socket;
import com.cerberus.model.system.bean.CerberusSystem;
import com.cerberus.module.account.backingobjects.UserBackingObject;
import com.cerberus.module.account.backingobjects.UserBackingObjectFactory;
import com.cerberus.module.account.workflows.AccountWorkflow;
import com.cerberus.module.generic.constants.CerberusConstants;
import com.cerberus.module.generic.controllers.CerberusController;
import com.cerberus.module.outlets.backingobjects.OutletBackingObject;
import com.cerberus.module.outlets.backingobjects.OutletBackingObjectFactory;

@Controller
public class SystemController extends CerberusController {

	private static final String IS_SYS_ADMIN = "isSysAdmin";
	private static final String SYSTEM_SETTINGS = "systemSettings";
	private static final String USERS_LIST = "usersList";
	private static final String USER = "user";
	
	@RequestMapping(value=CerberusConstants.SYSTEM_MAPPING, method=RequestMethod.GET)
	public String getLoginPage(Model model)	{
		
		//Get the User object from the "bin"
		User user = getUser();
		
		//This is our Login Security. I know, not that great but good enough for a site that will never be published.
		if(user == null){
			return CerberusConstants.REDIRECT;
		}
		
		initTopBar(model, user);
		
		model.addAttribute(IS_SYS_ADMIN, user.getLogin().isSysAdmin());
		
		//TODO system settings backing object
		
		CerberusSystem system = user.getLogin().getSystem();
		List<User> users = CerberusApplicationContext.getWorkflows().getAccountWorkflow().getUsersForSystem(system);
		model.addAttribute(USERS_LIST, users);
		
		CerberusLogger.update(CerberusConstants.SYSTEM_VIEW);
		
		return CerberusConstants.SYSTEM_VIEW;
	}
	
	@RequestMapping(value=CerberusConstants.SYSTEM_USER_MAPPING, method=RequestMethod.GET)
	public String getViewUserPage(Model model, @RequestParam(value = "id") Integer id)	{
		
		User user = getUser();
		
		//This is our Login Security. I know, not that great but good enough for a site that will never be published.
		if(user == null){
			return CerberusConstants.REDIRECT;
		}
		
		initTopBar(model, user);
		
		model.addAttribute(USER, 
				UserBackingObjectFactory.INSTANCE.getBackingObject(
						CerberusApplicationContext.getWorkflows().getAccountWorkflow().
								getUserById(id)));
		
		CerberusLogger.get(CerberusConstants.SYSTEM_USER_VIEW);
		
		return CerberusConstants.SYSTEM_USER_VIEW;
	}
	
	@RequestMapping(value=CerberusConstants.SYSTEM_MAPPING, method=RequestMethod.POST)
	public String post(Model model)	{
		return null;
		
	}
	
	@RequestMapping(value=CerberusConstants.SYSTEM_USER_MAPPING, method=RequestMethod.POST, params="submit")
	public String submitUserChanges(Model model, 
			@RequestParam(value = "id") Integer id, 
			@ModelAttribute(USER) UserBackingObject userBackingObject)	{
		CerberusLogger.post(CerberusConstants.SYSTEM_USER_VIEW);
		
		User editedUser = CerberusApplicationContext.getWorkflows().getAccountWorkflow().getUserById(id);
		
		User updated = UserBackingObjectFactory.INSTANCE.bind(userBackingObject, editedUser);

		AccountWorkflow accountWorkflow = CerberusApplicationContext.getWorkflows().getAccountWorkflow();
		accountWorkflow.updateLogin(updated.getLogin());
		accountWorkflow.updatePersonalInformation(updated.getInformation());
		
		return getViewUserPage(model, id);		
	}
	
	
	@RequestMapping(value=CerberusConstants.SYSTEM_USER_MAPPING, method=RequestMethod.POST, params="reset")
	public String resetPassword(Model model, 
			@RequestParam(value = "id") Integer id,
			@ModelAttribute(USER) UserBackingObject userBackingObject)	{
		CerberusLogger.post(CerberusConstants.SYSTEM_USER_VIEW);
		
		User editedUser = CerberusApplicationContext.getWorkflows().getAccountWorkflow().getUserById(id);
		
		AccountWorkflow accountWorkflow = CerberusApplicationContext.getWorkflows().getAccountWorkflow();
		editedUser = accountWorkflow.resetUserPassword(editedUser);
		accountWorkflow.updateLogin(editedUser.getLogin());
		
		return getViewUserPage(model, id);		
	}

}
