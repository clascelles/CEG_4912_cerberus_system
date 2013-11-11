package com.cerberus.module.outlets.controllers;

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
import com.cerberus.model.outlets.bean.Outlet;
import com.cerberus.model.outlets.bean.OutletOperationMode;
import com.cerberus.model.outlets.bean.Socket;
import com.cerberus.module.account.backingobjects.RoomBackingObject;
import com.cerberus.module.account.backingobjects.UserBackingObjectFactory;
import com.cerberus.module.generic.constants.CerberusConstants;
import com.cerberus.module.generic.controllers.CerberusController;
import com.cerberus.module.outlets.backingobjects.OutletBackingObject;
import com.cerberus.module.outlets.backingobjects.OutletBackingObjectFactory;
import com.cerberus.module.outlets.backingobjects.OutletOperationModeBackingObjectFactory;
import com.cerberus.module.outlets.backingobjects.SocketBackingObjectFactory;
import com.cerberus.module.outlets.workflows.OutletWorkflow;
import com.cerberus.module.system.workflows.SystemWorkflow;

@Controller
public class OutletController extends CerberusController {

	@RequestMapping(value=CerberusConstants.OUTLETS_MAPPING, method=RequestMethod.GET)
	public String getOutletsPage(Model model, HttpServletRequest request)	{

		User user = (User) request.getSession().getAttribute("user");

		if(user == null){
			return CerberusConstants.REDIRECT;
		}

		initTopBar(model, user);

		//Get the outlet list for the current user.
		OutletWorkflow outletWorkflow = CerberusApplicationContext.getWorkflows().getOutletWorkflow();
		List<OutletBackingObject> outletBackingObjects = OutletBackingObjectFactory.INSTANCE.getBackingObjects(outletWorkflow.getOutletFromUser(user));
		model.addAttribute(CerberusConstants.USER_OUTLETS, outletBackingObjects);

		SystemWorkflow systemWorkflow = CerberusApplicationContext.getWorkflows().getSystemWorkflow();
		List<RoomBackingObject> rooms = systemWorkflow.getRoomBackingObjects(user);
		model.addAttribute(CerberusConstants.ROOMS, rooms);

		OutletBackingObject newOutlet = OutletBackingObjectFactory.INSTANCE.getBackingObject(user);
		model.addAttribute(CerberusConstants.NEW_OUTLET, newOutlet);

		CerberusLogger.get(CerberusConstants.OUTLETS_VIEW);

		return CerberusConstants.OUTLETS_VIEW;
	}

	@RequestMapping(value=CerberusConstants.VIEW_OUTLET_MAPPING, method=RequestMethod.GET)
	public String getViewOutletPage(Model model, @RequestParam(value = "id") Integer id, HttpServletRequest request)	{

		User user = (User) request.getSession().getAttribute("user");

		if(user == null){
			return CerberusConstants.REDIRECT;
		}

		initTopBar(model, user);

		OutletWorkflow outletWorkflow = CerberusApplicationContext.getWorkflows().getOutletWorkflow();
		Outlet outlet = outletWorkflow.getOutletById(id);
		model.addAttribute(CerberusConstants.OUTLET, OutletBackingObjectFactory.INSTANCE.getBackingObject(outlet));

		model.addAttribute(CerberusConstants.SOCKETS, SocketBackingObjectFactory.INSTANCE.getBackingObjects(outletWorkflow.getSocketsByOutlet(outlet)));

		List<OutletOperationMode> modes = outletWorkflow.getOutletOperationModes();
		model.addAttribute(CerberusConstants.MODES, OutletOperationModeBackingObjectFactory.INSTANCE.getBackingObjects(modes));

		model.addAttribute(CerberusConstants.USER, UserBackingObjectFactory.INSTANCE.getBackingObject(user));

		CerberusLogger.get(CerberusConstants.VIEW_OUTLET_VIEW);

		return CerberusConstants.VIEW_OUTLET_VIEW;
	}

	@RequestMapping(value=CerberusConstants.OUTLETS_MAPPING, method=RequestMethod.POST)
	public String postOutletsPage(Model model, @ModelAttribute(CerberusConstants.NEW_OUTLET) OutletBackingObject newOutlet, HttpServletRequest request)	{
		CerberusLogger.post(CerberusConstants.OUTLETS_VIEW);

		User user = (User) request.getSession().getAttribute("user");
		OutletWorkflow outletWorkflow = CerberusApplicationContext.getWorkflows().getOutletWorkflow();

		//Add the outlet
		Outlet outlet = OutletBackingObjectFactory.INSTANCE.bind(newOutlet, user);
		outletWorkflow.insertOutlet(outlet);

		//Add the two sockets
		Socket socketA = Socket.create(outlet, Socket.TOP);
		outletWorkflow.insertSocket(socketA);

		Socket socketB = Socket.create(outlet, Socket.BOTTOM);
		outletWorkflow.insertSocket(socketB);

		return getOutletsPage(model, request);
	}

	@RequestMapping(value=CerberusConstants.VIEW_OUTLET_MAPPING, method=RequestMethod.POST)
	public String postViewOutletsPage(Model model, @ModelAttribute(CerberusConstants.NEW_OUTLET) OutletBackingObject newOutlet, HttpServletRequest request)	{
		CerberusLogger.post(CerberusConstants.VIEW_OUTLET_VIEW);

		//Add the outlet
		OutletWorkflow outletWorkflow = CerberusApplicationContext.getWorkflows().getOutletWorkflow();
		outletWorkflow.updateOutletOperationMode(newOutlet);

		return getViewOutletPage(model, newOutlet.getId(), request);
	}

}
