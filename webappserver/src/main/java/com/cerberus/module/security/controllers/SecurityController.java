package com.cerberus.module.security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cerberus.message.CerberusLogger;
import com.cerberus.model.account.bean.User;
import com.cerberus.module.generic.constants.CerberusConstants;
import com.cerberus.module.generic.controllers.CerberusController;

// TODO: TODO!!

@Controller
public class SecurityController extends CerberusController {

	@RequestMapping(value=CerberusConstants.SECURITY_MAPPING, method=RequestMethod.GET)
	public String getSecurityPage(Model model)	{

		User user = getUser();

		if(user == null){
			return CerberusConstants.REDIRECT;
		}

		initTopBar(model, user);

		//TODO: Get RFID list from system associated with user

		//Get the outlet list for the current user.
		/*
		OutletWorkflow outletWorkflow = CerberusApplicationContext.getWorkflows().getOutletWorkflow();
		List<OutletBackingObject> outletBackingObjects = OutletBackingObjectFactory.INSTANCE.getBackingObjects(outletWorkflow.getOutletFromUser(user));
		model.addAttribute(CerberusConstants.USER_OUTLETS, outletBackingObjects);

		SystemWorkflow systemWorkflow = CerberusApplicationContext.getWorkflows().getSystemWorkflow();
		List<RoomBackingObject> rooms = systemWorkflow.getRoomBackingObjects(user);
		model.addAttribute(CerberusConstants.ROOMS, rooms);

		OutletBackingObject newOutlet = OutletBackingObjectFactory.INSTANCE.getBackingObject(user);
		model.addAttribute(CerberusConstants.NEW_OUTLET, newOutlet);
		*/

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

		// TODO: Get RFID from passed ID

		/*
		OutletWorkflow outletWorkflow = CerberusApplicationContext.getWorkflows().getOutletWorkflow();
		Outlet outlet = outletWorkflow.getOutletById(id);
		model.addAttribute(CerberusConstants.OUTLET, OutletBackingObjectFactory.INSTANCE.getBackingObject(outlet));

		model.addAttribute(CerberusConstants.SOCKETS, SocketBackingObjectFactory.INSTANCE.getBackingObjects(outletWorkflow.getSocketsByOutlet(outlet)));

		List<OutletOperationMode> modes = outletWorkflow.getOutletOperationModes();
		model.addAttribute(CerberusConstants.MODES, OutletOperationModeBackingObjectFactory.INSTANCE.getBackingObjects(modes));

		model.addAttribute(CerberusConstants.USER, UserBackingObjectFactory.INSTANCE.getBackingObject(user));
		*/

		CerberusLogger.get(CerberusConstants.VIEW_RFID_VIEW);

		return CerberusConstants.VIEW_RFID_VIEW;
	}

	// TODO: Create POST methods for security and view RFID pages!

	/*
	@RequestMapping(value=CerberusConstants.SECURITY_MAPPING, method=RequestMethod.POST)
	public String postSecurityPage(Model model, @ModelAttribute(CerberusConstants.NEW_OUTLET) OutletBackingObject newOutlet)	{
		CerberusLogger.post(CerberusConstants.OUTLETS_VIEW);

		OutletWorkflow outletWorkflow = CerberusApplicationContext.getWorkflows().getOutletWorkflow();

		//Add the outlet
		Outlet outlet = OutletBackingObjectFactory.INSTANCE.bind(newOutlet, getUser());
		outletWorkflow.insertOutlet(outlet);

		//Add the two sockets
		Socket socketA = Socket.create(outlet, Socket.TOP, Socket.getNewSerial());
		outletWorkflow.insertSocket(socketA);

		Socket socketB = Socket.create(outlet, Socket.BOTTOM, Socket.getNewSerial());
		outletWorkflow.insertSocket(socketB);

		return getSecurityPage(model);
	}

	@RequestMapping(value=CerberusConstants.VIEW_RFID_MAPPING, method=RequestMethod.POST)
	public String postViewRfidPage(Model model, @ModelAttribute(CerberusConstants.NEW_OUTLET) OutletBackingObject newOutlet)	{
		CerberusLogger.post(CerberusConstants.VIEW_OUTLET_VIEW);

		//Add the outlet
		OutletWorkflow outletWorkflow = CerberusApplicationContext.getWorkflows().getOutletWorkflow();
		outletWorkflow.updateOutletOperationMode(newOutlet);

		return getViewRfidPage(model, newOutlet.getId());
	}

	*/

}