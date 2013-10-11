package com.cerberus.module.schedules.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.account.bean.User;
import com.cerberus.model.system.bean.Room;
import com.cerberus.module.account.backingobjects.RoomBackingObject;
import com.cerberus.module.account.backingobjects.RoomBackingObjectFactory;
import com.cerberus.module.generic.constants.CerberusConstants;
import com.cerberus.module.generic.controllers.CerberusController;
import com.cerberus.module.outlets.backingobjects.OutletBackingObject;
import com.cerberus.module.outlets.backingobjects.OutletBackingObjectFactory;
import com.cerberus.module.outlets.workflows.OutletWorkflow;
import com.cerberus.module.system.workflows.SystemWorkflow;

@Controller
public class ScheduleController extends CerberusController {
	
	@RequestMapping(value=CerberusConstants.SCHEDULES_MAPPING, method=RequestMethod.GET)
	public String getLoginPage(Model model)	{
		
		//Get the User object from the "bin"
		User user = getUser();
		
		//This is our Login Security. I know, not that great but good enough for a site that will never be published.
		if(user == null){
			return CerberusConstants.REDIRECT;
		}
		
		initTopBar(model, user);
		
		Map<RoomBackingObject, List<OutletBackingObject>> outlets = new HashMap<RoomBackingObject, List<OutletBackingObject>>();
		
		SystemWorkflow systemWorkflow = CerberusApplicationContext.getWorkflows().getSystemWorkflow();
		OutletWorkflow outletWorkflow = CerberusApplicationContext.getWorkflows().getOutletWorkflow();
		
		List<Room> rooms = systemWorkflow.getRooms(user.getLogin().getSystem().getId());		
				
		for(Room room : rooms) {			
			List<OutletBackingObject> backingObjects = OutletBackingObjectFactory.INSTANCE.getBackingObjects(outletWorkflow.getOutletsByRoomId(room.getId()));
			if(!backingObjects.isEmpty()) {
				outlets.put(RoomBackingObjectFactory.getBackingObject(room), backingObjects);				
			}
		}
		
		model.addAttribute(CerberusConstants.OUTLETS, outlets);
		
		return CerberusConstants.SCHEDULES_VIEW;
	}
	
	@RequestMapping(value=CerberusConstants.SCHEDULES_MAPPING, method=RequestMethod.POST)
	public String post(Model model)	{
		return null;
		
	}

}
