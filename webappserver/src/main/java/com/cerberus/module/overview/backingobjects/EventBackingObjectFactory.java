package com.cerberus.module.overview.backingobjects;

import java.text.SimpleDateFormat;

import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.account.bean.User;
import com.cerberus.model.system.bean.Event;
import com.cerberus.model.system.bean.EventRecord;
import com.cerberus.module.generic.backingobjects.BackingObjectFactory;
import com.cerberus.module.system.workflows.EventWorkflow;

public class EventBackingObjectFactory extends BackingObjectFactory<EventRecord, EventBackingObject> {

	public static EventBackingObjectFactory INSTANCE = new EventBackingObjectFactory();

	private static String TIMESTAMP_FORMAT = "dd/M/yyyy HH:mm:ss";

	@Override
	public EventBackingObject getBackingObject(User user) {
		EventBackingObject backingObject = new EventBackingObject();
		return backingObject;
	}

	@Override
	public EventBackingObject getBackingObject(EventRecord record) {
		EventBackingObject backingObject = new EventBackingObject();
		EventWorkflow eventWorkflow = CerberusApplicationContext.getWorkflows().getEventWorkflow();
		Event event = eventWorkflow.getEventFromId(record.getEventId());
		String message = eventWorkflow.getEventMessage(record);

		backingObject.setLevel(event.getEventLevel());
		backingObject.setMessage(message);
		// TODO: Format timestamp string
		SimpleDateFormat timestampFormat = new SimpleDateFormat(TIMESTAMP_FORMAT);
		backingObject.setTimestamp(timestampFormat.format(record.getTimestamp()));

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
