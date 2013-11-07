package com.cerberus.service.system;

import java.util.List;

import com.cerberus.model.usage.bean.Event;
import com.cerberus.model.usage.bean.EventRecord;
import com.cerberus.model.usage.dao.EventDAO;
import com.cerberus.model.usage.dao.EventRecordDAO;

public class EventService {

	EventDAO eventDAO;
	EventRecordDAO eventRecordDAO;

	public EventService(){
		eventDAO = new EventDAO();
		eventRecordDAO = new EventRecordDAO();
	}

	//***************************************************
	//EventRecord
	//***************************************************

	public Integer insertEventRecord(EventRecord eventRecord){
		return eventRecordDAO.save(eventRecord);
	}

	public EventRecord updateEventRecord(EventRecord eventRecord){
		return eventRecordDAO.merge(eventRecord);
	}

	public void deleteEventRecord(EventRecord eventRecord){
		eventRecordDAO.delete(eventRecord);
	}

	public List<EventRecord> getAllEventRecordsByOutletId(Integer outletId) {
		return eventRecordDAO.getByOutletId(outletId);
	}

	//***************************************************
	//Event
	//***************************************************

	public List<Event> getAllEvents() {
		return eventDAO.getAll();
	}

}
