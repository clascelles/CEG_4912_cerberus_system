package com.cerberus.module.schedules.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cerberus.frameworks.logging.CerberusLogger;
import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.account.bean.User;
import com.cerberus.model.schedules.bean.Schedule;
import com.cerberus.model.schedules.bean.ScheduledEvent;
import com.cerberus.model.system.bean.Room;
import com.cerberus.module.account.backingobjects.RoomBackingObject;
import com.cerberus.module.account.backingobjects.RoomBackingObjectFactory;
import com.cerberus.module.generic.constants.CerberusConstants;
import com.cerberus.module.generic.controllers.CerberusController;
import com.cerberus.module.outlets.backingobjects.OutletBackingObject;
import com.cerberus.module.outlets.backingobjects.OutletBackingObjectFactory;
import com.cerberus.module.outlets.backingobjects.SocketBackingObjectFactory;
import com.cerberus.module.outlets.backingobjects.SocketOperationModeBackingObjectFactory;
import com.cerberus.module.outlets.workflows.OutletWorkflow;
import com.cerberus.module.schedules.backingobjects.ScheduleBackingObject;
import com.cerberus.module.schedules.backingobjects.ScheduleBackingObjectFactory;
import com.cerberus.module.schedules.backingobjects.ScheduledEventBackingObject;
import com.cerberus.module.schedules.backingobjects.ScheduledEventBackingObjectFactory;
import com.cerberus.module.schedules.workflows.ScheduleWorkflow;
import com.cerberus.module.system.workflows.SystemWorkflow;

@Controller
public class ScheduleController extends CerberusController {

	
	/*
	 * Schedules page
	 */
	
	@RequestMapping(value=CerberusConstants.SCHEDULES_MAPPING, method=RequestMethod.GET)
	public String getSchedulesPage(Model model)	{

		User user = getUser();
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

		ScheduleWorkflow scheduleWorkflow = CerberusApplicationContext.getWorkflows().getScheduleWorkflow();

		scheduleWorkflow.cleanUserScheduledEvents(user);
		
		model.addAttribute(CerberusConstants.MODES, SocketOperationModeBackingObjectFactory.INSTANCE.getBackingObjects(outletWorkflow.getSocketOperationModes()));
		model.addAttribute(CerberusConstants.ROOMS, outlets);//OutletBackingObjectFactory.INSTANCE.getBackingObjects(outletWorkflow.getOutletFromUser(user)));

		model.addAttribute(CerberusConstants.SCHEDULED_EVENT,
				ScheduledEventBackingObjectFactory.INSTANCE.getBackingObject(user));

		model.addAttribute(CerberusConstants.SCHEDULE,
				ScheduleBackingObjectFactory.INSTANCE.getBackingObject(user));

		/*List<ScheduledEvent> events = scheduleWorkflow.getScheduledEventsForUser(user);
		model.addAttribute(CerberusConstants.SCHEDULED_EVENTS,
				ScheduledEventBackingObjectFactory.INSTANCE.getBackingObjects(events));*/

		return CerberusConstants.SCHEDULES_VIEW;
	}

	@RequestMapping(value=CerberusConstants.SCHEDULES_MAPPING, method=RequestMethod.POST, params="addEvent")
	public String addNewEvent(Model model,
			@ModelAttribute(CerberusConstants.SCHEDULED_EVENT) ScheduledEventBackingObject backingObject)	{
		CerberusLogger.post(CerberusConstants.SCHEDULES_VIEW);

		User user = getUser();	
		backingObject.setUserId(user.getId());
		
		if(ScheduledEventBackingObjectFactory.INSTANCE.isValid(backingObject)) {
			ScheduledEvent event = ScheduledEventBackingObjectFactory.INSTANCE.bind(backingObject, user);
			
			ScheduleWorkflow scheduleWorkflow = CerberusApplicationContext.getWorkflows().getScheduleWorkflow();
			scheduleWorkflow.insertScheduledEvent(event);
		}

		return getSchedulesPage(model);	
	}

	@RequestMapping(value=CerberusConstants.SCHEDULES_MAPPING, method=RequestMethod.POST, params="addSchedule")
	public String addNewSchedule(Model model,
			@ModelAttribute(CerberusConstants.SCHEDULE) ScheduleBackingObject backingObject)	{
		CerberusLogger.post(CerberusConstants.SCHEDULES_VIEW);

		if(ScheduleBackingObjectFactory.INSTANCE.isValid(backingObject)) {
			User user = getUser();
			Schedule schedule = ScheduleBackingObjectFactory.INSTANCE.bind(backingObject, user);
			
			ScheduleWorkflow scheduleWorkflow = CerberusApplicationContext.getWorkflows().getScheduleWorkflow();
			scheduleWorkflow.insertSchedule(schedule);			
		}

		return getSchedulesPage(model);	
	}

	@RequestMapping(value=CerberusConstants.SCHEDULES_MAPPING, method=RequestMethod.POST, params="viewExistingSchedules")
	public String viewExistingEvents(Model model,
			@ModelAttribute(CerberusConstants.SCHEDULED_EVENT) ScheduledEventBackingObject backingObject)	{
		CerberusLogger.post(CerberusConstants.SCHEDULES_VIEW);
					
		if(backingObject.getOutletId() != null) {			
			User user = getUser();
			ScheduledEvent event = ScheduledEventBackingObjectFactory.INSTANCE.bind(backingObject, user);
			
			List<ScheduledEventBackingObject> eventBackingObjects = new ArrayList<ScheduledEventBackingObject>();
			
			if(event.getSocket() != null) {
				ScheduleWorkflow scheduleWorkflow = CerberusApplicationContext.getWorkflows().getScheduleWorkflow();
				List<ScheduledEvent> events = scheduleWorkflow.getScheduledEventsForSocket(event.getSocket().getId());
			
				model.addAttribute(CerberusConstants.SOCKET, SocketBackingObjectFactory.INSTANCE.getBackingObject(event.getSocket()));

				eventBackingObjects = ScheduledEventBackingObjectFactory.INSTANCE.getBackingObjects(events);
			}
			
			model.addAttribute(CerberusConstants.SCHEDULED_EVENTS, eventBackingObjects);	
			
		}
		
		return getSchedulesPage(model);	
	}
	
	/*
	 * Edit schedules
	 */	
	@RequestMapping(value=CerberusConstants.EDIT_SCHEDULES_MAPPING, method=RequestMethod.GET)
	public String getEditSchedulesPage(Model model, @RequestParam(value = "id") Integer id)	{
		CerberusLogger.post(CerberusConstants.EDIT_SCHEDULES_VIEW);

		User user = getUser();
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

		ScheduleWorkflow scheduleWorkflow = CerberusApplicationContext.getWorkflows().getScheduleWorkflow();
		
		scheduleWorkflow.cleanUserScheduledEvents(user);
		
		ScheduledEvent event = scheduleWorkflow.getScheduledEventById(id);
		
		model.addAttribute(CerberusConstants.MODES, SocketOperationModeBackingObjectFactory.INSTANCE.getBackingObjects(outletWorkflow.getSocketOperationModes()));
		model.addAttribute(CerberusConstants.ROOMS, outlets);

		model.addAttribute(CerberusConstants.SCHEDULED_EVENT,
				ScheduledEventBackingObjectFactory.INSTANCE.getBackingObject(event));

		model.addAttribute(CerberusConstants.SCHEDULE,
				ScheduleBackingObjectFactory.INSTANCE.getBackingObject(user));

		/*List<ScheduledEvent> events = scheduleWorkflow.getScheduledEventsForUser(user);
		model.addAttribute(CerberusConstants.SCHEDULED_EVENTS,
				ScheduledEventBackingObjectFactory.INSTANCE.getBackingObjects(events));*/

		return CerberusConstants.EDIT_SCHEDULES_VIEW;
	}
	
	@RequestMapping(value=CerberusConstants.EDIT_SCHEDULES_MAPPING, method=RequestMethod.POST, params="editEvent")
	public String editEvent(Model model, 
			@RequestParam(value = "id") Integer id,
			@ModelAttribute(CerberusConstants.SCHEDULED_EVENT) ScheduledEventBackingObject backingObject)	{
		CerberusLogger.post(CerberusConstants.EDIT_SCHEDULES_VIEW);

		User user = getUser();	
		backingObject.setUserId(user.getId());
		
		if(ScheduledEventBackingObjectFactory.INSTANCE.isValid(backingObject)) {
			ScheduledEvent event = ScheduledEventBackingObjectFactory.INSTANCE.bind(backingObject, user);
			
			ScheduleWorkflow scheduleWorkflow = CerberusApplicationContext.getWorkflows().getScheduleWorkflow();
			scheduleWorkflow.updateScheduledEvent(event);
		}

		return getEditSchedulesPage(model, id);
	}

}
