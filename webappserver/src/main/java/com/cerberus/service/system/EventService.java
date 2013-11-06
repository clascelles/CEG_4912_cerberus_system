package com.cerberus.service.system;

import java.util.List;

import com.cerberus.model.system.bean.Event;
import com.cerberus.model.system.bean.EventRecord;
import com.cerberus.model.system.dao.EventDAO;
import com.cerberus.model.system.dao.EventRecordDAO;

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

	public Event getEventById(Integer id) {
		return eventDAO.getById(id);
	}

	public List<Event> getAllEvents() {
		return eventDAO.getAll();
	}

}
