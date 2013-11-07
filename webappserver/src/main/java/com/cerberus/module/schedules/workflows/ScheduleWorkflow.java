package com.cerberus.module.schedules.workflows;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.account.bean.User;
import com.cerberus.model.outlets.bean.Socket;
import com.cerberus.model.schedules.bean.Schedule;
import com.cerberus.model.schedules.bean.ScheduleRecurrence;
import com.cerberus.model.schedules.bean.ScheduledEvent;
import com.cerberus.module.generic.workflows.Workflow;
import com.cerberus.module.outlets.workflows.OutletWorkflow;
import com.cerberus.service.schedules.SchedulingService;

public class ScheduleWorkflow extends Workflow {

	public void insertScheduledEvent(ScheduledEvent event) {
		serviceFactory.getSchedulingService().insertScheduledEvent(event);
		this.returnServiceFactory();
	}

	public void updateScheduledEvent(ScheduledEvent event) {
		serviceFactory.getSchedulingService().updateScheduledEvent(event);
		this.returnServiceFactory();
	}
	
	public void removeScheduledEvent(ScheduledEvent event) {
		serviceFactory.getSchedulingService().deleteScheduledEvent(event);
		this.returnServiceFactory();		
	}
	
	public void insertSchedule(Schedule schedule) {
		serviceFactory.getSchedulingService().insertSchedule(schedule);
		this.returnServiceFactory();
	}

	public void updatedSchedule(Schedule schedule) {
		serviceFactory.getSchedulingService().updateSchedule(schedule);
		this.returnServiceFactory();
	}
	
	public ScheduledEvent getScheduledEventById(Integer id){
		SchedulingService scheduleService = serviceFactory.getSchedulingService();
		
		ScheduledEvent event = scheduleService.getScheduledEventById(id);

		this.returnServiceFactory();

		return event;
	}
	
	public List<ScheduledEvent> getScheduledEventsForSocket(Integer socketId){
		SchedulingService scheduleService = serviceFactory.getSchedulingService();
		
		List<ScheduledEvent> events = new ArrayList<ScheduledEvent>();
		List<ScheduledEvent> socketEvents = scheduleService.getScheduledEventBySocketId(socketId);
		if(socketEvents != null && !socketEvents.isEmpty()) {
			events.addAll(socketEvents);				
		}

		this.returnServiceFactory();

		return events;
	}
	
	public List<ScheduledEvent> getScheduledEventsForUser(User user){

		SchedulingService scheduleService = serviceFactory.getSchedulingService();
		OutletWorkflow outletWorkflow = CerberusApplicationContext.getWorkflows().getOutletWorkflow();
		
		List<ScheduledEvent> events = new ArrayList<ScheduledEvent>();	
		List<Socket> sockets = outletWorkflow.getSocketsByUser(user);
		
		for(Socket socket : sockets) {
			List<ScheduledEvent> socketEvents = scheduleService.getScheduledEventBySocketId(socket.getId());
			if(socketEvents != null && !socketEvents.isEmpty()) {
				events.addAll(socketEvents);				
			}
		}

		this.returnServiceFactory();

		return events;
	}
	
	// this method deletes all existing scheduled events with
	// a timestamp which comes before now
	public void cleanUserScheduledEvents(User user) {
		List<ScheduledEvent> events = getScheduledEventsForUser(user);
		
		Date currentDate = new Date();
		currentDate.setTime(currentDate.getTime() - 24*60*60*1000); //delete events older than one day ago
		
		for(ScheduledEvent event : events) {
			if(event.getTime().before(currentDate)) {
				removeScheduledEvent(event);
			}
		}
	}
	
	public List<Schedule> getSchedulesForUser(User user){

		SchedulingService scheduleService = serviceFactory.getSchedulingService();
		OutletWorkflow outletWorkflow = CerberusApplicationContext.getWorkflows().getOutletWorkflow();
		
		List<Schedule> schedules = new ArrayList<Schedule>();	
		List<Socket> sockets = outletWorkflow.getSocketsByUser(user);
		
		for(Socket socket : sockets) {
			List<Schedule> socketSchedules = scheduleService.getSchedulesBySocketId(socket.getId());
			if(socketSchedules != null && !socketSchedules.isEmpty()) {
				schedules.addAll(socketSchedules);				
			}
		}

		this.returnServiceFactory();

		return schedules;
	}
	
	public ScheduleRecurrence getRecurrenceById(Integer id) {
		ScheduleRecurrence recurrence = serviceFactory.getSchedulingService().getScheduleRecurrenceById(id);
		this.returnServiceFactory();
		return recurrence;
	}
	
}
