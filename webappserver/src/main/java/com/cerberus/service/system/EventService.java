package com.cerberus.service.system;

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

	//***************************************************
	//Event
	//***************************************************

	public Integer insertEvent(Event event){
		return eventDAO.save(event);
	}

	public Event updateEvent(Event event){
		return eventDAO.merge(event);
	}

	public void deleteEvent(Event event){
		eventDAO.delete(event);
	}

}
