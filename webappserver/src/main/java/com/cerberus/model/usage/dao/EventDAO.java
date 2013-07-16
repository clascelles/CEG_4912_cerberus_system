package com.cerberus.model.usage.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.usage.bean.Event;


public class EventDAO extends GenericDAO<Event, Integer> {

	/***/
	public Event getById(Integer id){
		return getById(Event.class, id);
	}
	
	/***/
	public List<Event> getAll(){
		return getAll(Event.class);
	}
	
}
