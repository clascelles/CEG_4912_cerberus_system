package com.cerberus.model.system.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.system.bean.EventLevel;


public class EventLevelDAO extends GenericDAO<EventLevel, Integer> {

	/***/
	public EventLevel getById(Integer id){
		return getById(EventLevel.class, id);
	}

	/***/
	public List<EventLevel> getAll(){
		return getAll(EventLevel.class);
	}

}
