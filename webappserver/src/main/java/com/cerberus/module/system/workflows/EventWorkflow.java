package com.cerberus.module.system.workflows;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import com.cerberus.model.outlets.bean.Outlet;
import com.cerberus.model.outlets.bean.OutletSystemView;
import com.cerberus.model.system.bean.Event;
import com.cerberus.model.system.bean.EventRecord;
import com.cerberus.module.generic.workflows.Workflow;
import com.cerberus.module.system.constants.EventRecordComparator;
import com.cerberus.module.system.constants.EventType;
import com.cerberus.service.outlets.OutletService;
import com.cerberus.service.system.EventService;

public class EventWorkflow extends Workflow {

	private static Logger LOGGER = Logger.getLogger(EventWorkflow.class);

	public Event getEventFromId(Integer eventId) {
		return serviceFactory.getEventService().getEventById(eventId);
	}

	public void logEvent(EventType type, String outletSerialNumber) {
		OutletService outletService = serviceFactory.getOutletService();
		Outlet outlet = outletService.getOutletBySerialNumber(outletSerialNumber);

		logEvent(type, outlet);
	}

	public void logEvent(EventType type, Outlet outlet) {
		if(outlet != null) {
			logEvent(type, outlet.getId());
		}
	}

	public void logEvent(EventType type, Integer outletId) {
		EventService eventService = serviceFactory.getEventService();

		LOGGER.info("Outlet: " + outletId);
		LOGGER.info("Logging event! Event: " + type);
		Timestamp timestamp = new Timestamp(DateTime.now().getMillis());

		EventRecord record = new EventRecord(outletId, type.getId(), timestamp);
		eventService.insertEventRecord(record);

		this.returnServiceFactory();
		// Could trigger a notification on the web client at this point
	}

	public List<EventRecord> getMostRecentEvents(Integer systemId, int limit) {
		EventService eventService = serviceFactory.getEventService();
		OutletService outletService = serviceFactory.getOutletService();

		Comparator<EventRecord> comparator = new EventRecordComparator();
		Set<EventRecord> records = new TreeSet<EventRecord>(comparator);

		List<OutletSystemView> outlets = outletService.getOutletsBySystemId(systemId);

		for(OutletSystemView outlet : outlets) {
			records.addAll(eventService.getAllEventRecordsByOutletId(outlet.getId()));
		}

		List<EventRecord> orderedRecords = new ArrayList<EventRecord>(records);
		List<EventRecord> latestRecords = orderedRecords;

		if(limit <= orderedRecords.size()) {
			latestRecords = orderedRecords.subList(0, limit);
		}

		return latestRecords;
	}

	public String getEventMessage(EventRecord eventRecord) {
		EventService eventService = serviceFactory.getEventService();
		OutletService outletService = serviceFactory.getOutletService();
		String formattedMessage = null;

		Event event = eventService.getEventById(eventRecord.getEventId());
		Outlet outlet = outletService.getOutletById(eventRecord.getOutletId());
		String message = event.getMessage();

		formattedMessage = String.format(message, outlet.getSerialNumber(), outlet.getMode().getName());

		return formattedMessage;
	}

}
