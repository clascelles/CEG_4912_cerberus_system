package com.cerberus.service.system;

import com.cerberus.model.usage.dao.EventDAO;

public class EventService {

	EventDAO eventDAO;

	public EventService(){
		eventDAO = new EventDAO();
	}

}
