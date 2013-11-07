package com.cerberus.module.security.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cerberus.frameworks.logging.CerberusLogger;
import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.account.bean.User;
import com.cerberus.model.security.bean.RfidTagView;
import com.cerberus.module.generic.constants.CerberusConstants;
import com.cerberus.module.generic.controllers.CerberusController;
import com.cerberus.module.security.backingobjects.RfidTagViewBackingObject;
import com.cerberus.module.security.backingobjects.RfidTagViewBackingObjectFactory;
import com.cerberus.module.security.constants.RfidPermission;
import com.cerberus.module.security.workflows.SecurityWorkflow;

@Controller
public class SecurityController extends CerberusController {

	@RequestMapping(value=CerberusConstants.SECURITY_MAPPING, method=RequestMethod.GET)
	public String getSecurityPage(Model model)	{

		User user = getUser();

		if(user == null){
			return CerberusConstants.REDIRECT;
		}

		initTopBar(model, user);

		SecurityWorkflow securityWorkflow = CerberusApplicationContext.getWorkflows().getSecurityWorkflow();
		List<RfidTagView> rfidTagsFromSystem = securityWorkflow.getRfidTagsFromSystem(user.getLogin().getSystem());
		List<RfidTagViewBackingObject> tags = RfidTagViewBackingObjectFactory.INSTANCE.getBackingObjects(rfidTagsFromSystem);

		model.addAttribute(CerberusConstants.RFID_TAGS, tags);

		CerberusLogger.get(CerberusConstants.SECURITY_VIEW);

		return CerberusConstants.SECURITY_VIEW;
	}

	@RequestMapping(value=CerberusConstants.VIEW_RFID_MAPPING, method=RequestMethod.GET)
	public String getViewRfidPage(Model model, @RequestParam(value = "id") Integer id)	{

		User user = getUser();

		if(user == null){
			return CerberusConstants.REDIRECT;
		}

		initTopBar(model, user);

		SecurityWorkflow securityWorkflow = CerberusApplicationContext.getWorkflows().getSecurityWorkflow();
		RfidTagView rfidTag = securityWorkflow.getRfidTagViewById(id);
		RfidTagViewBackingObject rfidTagBO = RfidTagViewBackingObjectFactory.INSTANCE.getBackingObject(rfidTag);

		List<String> profileNames = securityWorkflow.getAllProfileNames();

		model.addAttribute(CerberusConstants.RFID_TAG, rfidTagBO);
		model.addAttribute("profiles", profileNames);

		model.addAttribute("denied", RfidPermission.DENIED);
		model.addAttribute("allowed", RfidPermission.ALLOWED);

		CerberusLogger.get(CerberusConstants.VIEW_RFID_VIEW);

		return CerberusConstants.VIEW_RFID_VIEW;
	}

	@RequestMapping(value=CerberusConstants.VIEW_RFID_MAPPING, method=RequestMethod.POST)
	public String postViewRfidPage(Model model, @ModelAttribute(CerberusConstants.RFID_TAG) RfidTagViewBackingObject rfidTag)	{
		CerberusLogger.post(CerberusConstants.VIEW_RFID_VIEW);

		//Update the rfid tag
		SecurityWorkflow securityWorkflow = CerberusApplicationContext.getWorkflows().getSecurityWorkflow();
		RfidTagView newRfidTagView = RfidTagViewBackingObjectFactory.INSTANCE.bind(rfidTag, getUser());
		securityWorkflow.updateRfidTagView(newRfidTagView);

		return getSecurityPage(model);
	}

}
