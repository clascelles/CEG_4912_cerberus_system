package com.cerberus.module.account.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cerberus.frameworks.logging.CerberusLogger;
import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.account.bean.User;
import com.cerberus.module.account.backingobjects.UserBackingObject;
import com.cerberus.module.account.backingobjects.UserBackingObjectFactory;
import com.cerberus.module.account.constants.AccountConstants;
import com.cerberus.module.account.workflows.AccountWorkflow;
import com.cerberus.module.generic.constants.CerberusConstants;
import com.cerberus.module.generic.controllers.CerberusController;
import com.cerberus.module.overview.backingobjects.TopBarBackingObject;

@Controller
public class AccountController extends CerberusController {

	@RequestMapping(value="/account/index", method=RequestMethod.GET)
	public String getProfilePage(HttpServletRequest request, Model model)	{


		User user = getUser(request);
		if(user == null){
			return CerberusConstants.REDIRECT;
		}
		initTopBar(model, user);

		TopBarBackingObject topBarBackingObject = new TopBarBackingObject();
		topBarBackingObject.setName(user.getInformation().getFirstName() + " " + user.getInformation().getLastName());

		model.addAttribute(AccountConstants.TOP_BAR_BACKING_OBJECT, topBarBackingObject);
		model.addAttribute(AccountConstants.USER, user);
		model.addAttribute(AccountConstants.USER_BACKING_OBJECT, UserBackingObjectFactory.INSTANCE.getBackingObject(user));

		CerberusLogger.get(CerberusConstants.ACCOUNT_VIEW);

		return "account/index";
	}

	@RequestMapping(value=CerberusConstants.ACCOUNT_MAPPING, method=RequestMethod.POST)
	public String post(Model model, @ModelAttribute(AccountConstants.USER_BACKING_OBJECT) UserBackingObject userBackingObject, HttpServletRequest request)	{
		CerberusLogger.post(CerberusConstants.ACCOUNT_VIEW);

		User sessionUser = getUser(request);
		User updated = UserBackingObjectFactory.INSTANCE.bind(userBackingObject, sessionUser);

		AccountWorkflow accountWorkflow = CerberusApplicationContext.getWorkflows().getAccountWorkflow();
		accountWorkflow.updateLogin(updated.getLogin());
		accountWorkflow.updatePersonalInformation(updated.getInformation());

		return getProfilePage(request, model);
	}
}
