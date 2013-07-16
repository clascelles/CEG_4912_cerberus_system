package com.cerberus.model.usage.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.usage.bean.ConnectionEvent;

public class ConnectionEventDAO extends GenericDAO<ConnectionEvent, Integer> {

	/***/
	public ConnectionEvent getById(Integer id){
		return getById(ConnectionEvent.class, id);
	}
	
	/***/
	public List<ConnectionEvent> getAll(){
		return getAll(ConnectionEvent.class);
	}
	
}
