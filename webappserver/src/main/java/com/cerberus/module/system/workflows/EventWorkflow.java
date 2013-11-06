package com.cerberus.module.system.workflows;

import java.sql.Timestamp;

import org.joda.time.DateTime;

import com.cerberus.model.outlets.bean.Outlet;
import com.cerberus.model.system.bean.Event;
import com.cerberus.model.system.bean.EventRecord;
import com.cerberus.module.generic.workflows.Workflow;
import com.cerberus.module.system.constants.EventType;
import com.cerberus.service.outlets.OutletService;
import com.cerberus.service.system.EventService;

public class EventWorkflow extends Workflow {

	public void logEvent(EventType type, Integer outletId) {
		EventService eventService = serviceFactory.getEventService();
		OutletService outletService = serviceFactory.getOutletService();

		Outlet outlet = outletService.getOutletById(outletId);
		Event event = eventService.getEventById(type.getId());;
		Timestamp timestamp = new Timestamp(DateTime.now().getMillis());

		EventRecord record = new EventRecord(outlet, event, timestamp);
		eventService.insertEventRecord(record);

		this.returnServiceFactory();
		// Could trigger a notification on the web client at this point
	}

}
