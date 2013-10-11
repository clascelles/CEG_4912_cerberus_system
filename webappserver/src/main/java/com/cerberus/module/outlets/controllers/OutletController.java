package com.cerberus.module.outlets.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cerberus.daemon.constants.SocketOperatingMode;
import com.cerberus.daemon.message.SwitchOperatingModeMessage;
import com.cerberus.daemon.message.WrongMessageException;
import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.message.CerberusLogger;
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
	public String getOutletsPage(Model model)	{
		
		//Get the User object from the "bin"
		User user = getUser();
		
		//This is our Login Security. I know, not that great but good enough for a site that will never be published.
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
	public String getViewOutletPage(Model model, @RequestParam(value = "id") Integer id)	{
		
		//Get the User object from the "bin"
		User user = getUser();
		
		//This is our Login Security. I know, not that great but good enough for a site that will never be published.
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
	public String postOutletsPage(Model model, @ModelAttribute(CerberusConstants.NEW_OUTLET) OutletBackingObject newOutlet)	{
		CerberusLogger.post(CerberusConstants.OUTLETS_VIEW);
		
		//Add the outlet
		Outlet outlet = OutletBackingObjectFactory.INSTANCE.bind(newOutlet, getUser());
		CerberusApplicationContext.getWorkflows().getOutletWorkflow().insertOutlet(outlet);
		
		//Add the two sockets
		Socket socketA = Socket.create(outlet, Socket.TOP, Socket.getNewSerial());
		CerberusApplicationContext.getWorkflows().getOutletWorkflow().insertSocket(socketA);
		
		Socket socketB = Socket.create(outlet, Socket.BOTTOM, Socket.getNewSerial());
		CerberusApplicationContext.getWorkflows().getOutletWorkflow().insertSocket(socketB);
		
		return getOutletsPage(model);		
	}
	
	@RequestMapping(value=CerberusConstants.VIEW_OUTLET_MAPPING, method=RequestMethod.POST)
	public String postViewOutletsPage(Model model, @ModelAttribute(CerberusConstants.NEW_OUTLET) OutletBackingObject newOutlet)	{
		CerberusLogger.post(CerberusConstants.VIEW_OUTLET_VIEW);
		
		//Add the outlet
		OutletWorkflow outletWorkflow = CerberusApplicationContext.getWorkflows().getOutletWorkflow();
		Outlet outlet = outletWorkflow.getOutletById(newOutlet.getId());
		
		if(outlet.getMode().getId() != newOutlet.getModeId()) {
			outlet.setMode(outletWorkflow.getOutletOperationModeById(newOutlet.getModeId()));
			outletWorkflow.updateOutlet(outlet);
			
			SwitchOperatingModeMessage updateMessage = new SwitchOperatingModeMessage(
					String.format("%012d", outlet.getSerialNumber()), 1, new Date().getTime(), "F458C7AAE4", 
					SocketOperatingMode.fromIntValue(newOutlet.getModeId()), 0);
			
			try {
				CerberusApplicationContext.getWorkflows().getSwitchOperationModeWorkflow().handleSendingMessage(updateMessage);
			} catch (WrongMessageException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return getViewOutletPage(model, newOutlet.getId());		
	}

}
