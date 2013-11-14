package com.cerberus.module.overview.backingobjects;

import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.account.bean.User;
import com.cerberus.model.system.bean.Event;
import com.cerberus.model.system.bean.EventRecord;
import com.cerberus.module.generic.backingobjects.BackingObjectFactory;

public class EventBackingObjectFactory extends BackingObjectFactory<EventRecord, EventBackingObject> {

	public static EventBackingObjectFactory INSTANCE = new EventBackingObjectFactory();

	@Override
	public EventBackingObject getBackingObject(User user) {
		EventBackingObject backingObject = new EventBackingObject();
		return backingObject;
	}

	@Override
	public EventBackingObject getBackingObject(EventRecord record) {
		EventBackingObject backingObject = new EventBackingObject();
		Event event = CerberusApplicationContext.getWorkflows().getEventWorkflow().getEventFromId(record.getEventId());

		backingObject.setLevel(event.getEventLevel());
		backingObject.setMessage(event.getMessage());
		// TODO: Format timestamp string
		backingObject.setTimestamp(record.getTimestamp().toString());

		return backingObject;
	}

	@Override
	public EventRecord bind(EventBackingObject backingObject, User user) {
		//TODO

		return null;
	}

	@Override
	public boolean isValid(EventBackingObject backingObject) {
		// TODO Auto-generated method stub
		return false;
	}

}
