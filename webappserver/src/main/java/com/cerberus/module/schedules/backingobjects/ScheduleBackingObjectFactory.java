package com.cerberus.module.schedules.backingobjects;

import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.account.bean.User;
import com.cerberus.model.schedules.bean.Schedule;
import com.cerberus.model.schedules.bean.ScheduleRecurrence;
import com.cerberus.module.generic.backingobjects.BackingObjectFactory;
import com.cerberus.module.outlets.workflows.OutletWorkflow;
import com.cerberus.module.schedules.workflows.ScheduleWorkflow;

public class ScheduleBackingObjectFactory 
	extends BackingObjectFactory<Schedule, ScheduleBackingObject> {
	
	public static ScheduleBackingObjectFactory INSTANCE = new ScheduleBackingObjectFactory();

	@Override
	public ScheduleBackingObject getBackingObject(User user) {
		ScheduleBackingObject backingObject = new ScheduleBackingObject();
		
		backingObject.setStartEvent(ScheduledEventBackingObjectFactory.INSTANCE.getBackingObject(user));
		backingObject.setEndEvent(ScheduledEventBackingObjectFactory.INSTANCE.getBackingObject(user));
		//outlet id left blank
		backingObject.setSocketId(0);
		backingObject.setUser(user);		
		
		return backingObject;
	}
	
	@Override
	public ScheduleBackingObject getBackingObject(Schedule object) {
		ScheduleBackingObject backingObject = new ScheduleBackingObject();
		
		backingObject.setStartEvent(ScheduledEventBackingObjectFactory.INSTANCE.getBackingObject(object.getStartEvent()));
		backingObject.setEndEvent(ScheduledEventBackingObjectFactory.INSTANCE.getBackingObject(object.getEndEvent()));
		backingObject.setSocket(object.getSocket());
		backingObject.setUser(object.getUser());
		backingObject.setEventDuration();
		
		return backingObject;
	}

	@Override
	public Schedule bind(ScheduleBackingObject backingObject, User user) {
		OutletWorkflow outletWorkflow = CerberusApplicationContext.getWorkflows().getOutletWorkflow();
		ScheduleWorkflow scheduleWorkflow = CerberusApplicationContext.getWorkflows().getScheduleWorkflow();
		Schedule event = new Schedule();
		
		event.setStartEvent(ScheduledEventBackingObjectFactory.INSTANCE.bind(backingObject.getStartEvent(), user));
		event.setEndEvent(ScheduledEventBackingObjectFactory.INSTANCE.bind(backingObject.getEndEvent(), user));
		if(backingObject.getSocket() != null) {
			event.setSocket(backingObject.getSocket());			
		} else {
			event.setSocket(outletWorkflow.getSocketById(backingObject.getSocketId()));			
		}
		event.setUser(user);
		event.setRecurrence(scheduleWorkflow.getRecurrenceById(ScheduleRecurrence.ONCE_ID));

		return event;
	}

	@Override
	public boolean isValid(ScheduleBackingObject backingObject) {
		return (ScheduledEventBackingObjectFactory.INSTANCE.isValid(backingObject.getStartEvent())
				&& ScheduledEventBackingObjectFactory.INSTANCE.isValid(backingObject.getEndEvent()));
	}
}
