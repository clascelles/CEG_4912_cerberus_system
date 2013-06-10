package com.cerberus.persistence.DAO;

import java.util.List;

import com.cerberus.persistence.beans.Event;


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
