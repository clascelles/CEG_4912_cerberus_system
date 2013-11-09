package com.cerberus.module.system.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cerberus.frameworks.logging.CerberusLogger;
import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.account.bean.User;
import com.cerberus.model.outlets.bean.OutletOperationMode;
import com.cerberus.model.system.bean.CerberusSystem;
import com.cerberus.module.account.backingobjects.UserBackingObject;
import com.cerberus.module.account.backingobjects.UserBackingObjectFactory;
import com.cerberus.module.account.workflows.AccountWorkflow;
import com.cerberus.module.generic.constants.CerberusConstants;
import com.cerberus.module.generic.controllers.CerberusController;
import com.cerberus.module.outlets.backingobjects.OutletOperationModeBackingObjectFactory;
import com.cerberus.module.outlets.workflows.OutletWorkflow;
import com.cerberus.module.system.backingobjects.SystemBackingObject;
import com.cerberus.module.system.backingobjects.SystemBackingObjectFactory;
import com.cerberus.module.system.workflows.SystemWorkflow;

@Controller
public class SystemController extends CerberusController {

	@RequestMapping(value=CerberusConstants.SYSTEM_MAPPING, method=RequestMethod.GET)
	public String getSystemPage(Model model, HttpServletRequest request)	{

		//Get the User object from the "bin"
		User user = getUser(request);

		//This is our Login Security. I know, not that great but good enough for a site that will never be published.
		if(user == null){
			return CerberusConstants.REDIRECT;
		}

		initTopBar(model, user);

		CerberusSystem system = user.getLogin().getSystem();

		OutletWorkflow outletWorkflow = CerberusApplicationContext.getWorkflows().getOutletWorkflow();
		List<OutletOperationMode> modes = outletWorkflow.getOutletOperationModes();
		model.addAttribute(CerberusConstants.MODES, OutletOperationModeBackingObjectFactory.INSTANCE.getBackingObjects(modes));

		model.addAttribute(CerberusConstants.SYSTEM_SETTINGS, SystemBackingObjectFactory.INSTANCE.getBackingObject(system));

		List<User> users = CerberusApplicationContext.getWorkflows().getAccountWorkflow().getUsersForSystem(system);
		model.addAttribute(CerberusConstants.USERS_LIST, users);

		CerberusLogger.update(CerberusConstants.SYSTEM_VIEW);

		return CerberusConstants.SYSTEM_VIEW;
	}

	@RequestMapping(value=CerberusConstants.SYSTEM_USER_MAPPING, method=RequestMethod.GET)
	public String getViewUserPage(Model model, @RequestParam(value = "id") Integer id, HttpServletRequest request)	{

		User user = getUser(request);
		if(user == null){
			return CerberusConstants.REDIRECT;
		}
		initTopBar(model, user);

		model.addAttribute(CerberusConstants.USER,
				UserBackingObjectFactory.INSTANCE.getBackingObject(
						CerberusApplicationContext.getWorkflows().getAccountWorkflow().
								getUserById(id)));

		CerberusLogger.get(CerberusConstants.SYSTEM_USER_VIEW);

		return CerberusConstants.SYSTEM_USER_VIEW;
	}

	@RequestMapping(value=CerberusConstants.SYSTEM_MAPPING, method=RequestMethod.POST, params="submit")
	public String submitSystemChanges(Model model,
			@ModelAttribute(CerberusConstants.SYSTEM_SETTINGS) SystemBackingObject systemBackingObject, HttpServletRequest request)	{
		CerberusLogger.post(CerberusConstants.SYSTEM_VIEW);

		User user = getUser(request);

		SystemWorkflow systemWorkflow = CerberusApplicationContext.getWorkflows().getSystemWorkflow();
		systemWorkflow.updateSystem(SystemBackingObjectFactory.INSTANCE.bind(systemBackingObject, user));

		return getSystemPage(model,request);
	}

	@RequestMapping(value=CerberusConstants.SYSTEM_MAPPING, method=RequestMethod.POST, params="resetSettings")
	public String resetSystemChanges(Model model,
			@ModelAttribute(CerberusConstants.SYSTEM_SETTINGS) SystemBackingObject systemBackingObject,  HttpServletRequest request)	{
		return getSystemPage(model, request);
	}

	@RequestMapping(value=CerberusConstants.SYSTEM_USER_MAPPING, method=RequestMethod.POST, params="submit")
	public String submitUserChanges(Model model,
			@RequestParam(value = "id") Integer id,
			@ModelAttribute(CerberusConstants.USER) UserBackingObject userBackingObject,  HttpServletRequest request)	{
		CerberusLogger.post(CerberusConstants.SYSTEM_USER_VIEW);

		User editedUser = CerberusApplicationContext.getWorkflows().getAccountWorkflow().getUserById(id);

		User updated = UserBackingObjectFactory.INSTANCE.bind(userBackingObject, editedUser);

		AccountWorkflow accountWorkflow = CerberusApplicationContext.getWorkflows().getAccountWorkflow();
		accountWorkflow.updateLogin(updated.getLogin());
		accountWorkflow.updatePersonalInformation(updated.getInformation());

		return getViewUserPage(model, id, request);
	}

	@RequestMapping(value=CerberusConstants.SYSTEM_USER_MAPPING, method=RequestMethod.POST, params="reset")
	public String resetPassword(Model model,
			@RequestParam(value = "id") Integer id,
			@ModelAttribute(CerberusConstants.USER) UserBackingObject userBackingObject,  HttpServletRequest request)	{
		CerberusLogger.post(CerberusConstants.SYSTEM_USER_VIEW);

		User editedUser = CerberusApplicationContext.getWorkflows().getAccountWorkflow().getUserById(id);

		AccountWorkflow accountWorkflow = CerberusApplicationContext.getWorkflows().getAccountWorkflow();
		editedUser = accountWorkflow.resetUserPassword(editedUser);
		accountWorkflow.updateLogin(editedUser.getLogin());

		return getViewUserPage(model, id, request);
	}

}
