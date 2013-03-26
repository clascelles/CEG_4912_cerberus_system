package com.cerberus.server.persistence.DAO;

import java.util.List;

import com.cerberus.server.persistence.beans.ConnectionEvent;

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
