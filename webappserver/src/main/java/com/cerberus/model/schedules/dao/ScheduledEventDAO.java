package com.cerberus.model.schedules.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.schedules.bean.ScheduledEvent;

public class ScheduledEventDAO extends GenericDAO<ScheduledEvent, Integer> {

	/***/
	public ScheduledEvent getById(Integer id){
		return getById(ScheduledEvent.class, id);
	}
	
	/***/
	public List<ScheduledEvent> getAll(){
		return getAll(ScheduledEvent.class);
	}
	
}
