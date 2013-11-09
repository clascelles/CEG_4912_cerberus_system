package com.cerberus.module.schedules.backingobjects;

import com.cerberus.model.account.bean.User;
import com.cerberus.model.schedules.bean.ScheduleRecurrence;
import com.cerberus.module.generic.backingobjects.BackingObjectFactory;

public class ScheduleRecurrenceBackingObjectFactory 
	extends BackingObjectFactory<ScheduleRecurrence, ScheduleRecurrenceBackingObject>{

	public static ScheduleRecurrenceBackingObjectFactory INSTANCE = new ScheduleRecurrenceBackingObjectFactory();
	
	@Override
	public ScheduleRecurrenceBackingObject getBackingObject(User user) {		
		return new ScheduleRecurrenceBackingObject();
	}

	@Override
	public ScheduleRecurrenceBackingObject getBackingObject(
			ScheduleRecurrence object) {
		ScheduleRecurrenceBackingObject backingObject = new ScheduleRecurrenceBackingObject();
		
		backingObject.setId(object.getId());
		backingObject.setName(object.getName());
		
		return backingObject;
	}

	@Override
	public ScheduleRecurrence bind(
			ScheduleRecurrenceBackingObject backingObject, User user) {
		//unused
		return null;
	}

	//shouldn't need to validate these - they don't get updated
	@Override
	public boolean isValid(ScheduleRecurrenceBackingObject backingObject) {
		return false;
	}

}
