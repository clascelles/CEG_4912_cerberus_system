package com.cerberus.model.system.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.system.bean.Event;


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
