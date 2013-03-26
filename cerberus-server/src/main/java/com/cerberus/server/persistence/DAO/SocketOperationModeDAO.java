package com.cerberus.server.persistence.DAO;

import java.util.List;

import com.cerberus.server.persistence.beans.SocketOperationMode;

public class SocketOperationModeDAO extends GenericDAO<SocketOperationMode, Integer> {

	/***/
	public SocketOperationMode getById(Integer id){
		return getById(SocketOperationMode.class, id);
	}
	
	/***/
	public List<SocketOperationMode> getAll(){
		return getAll(SocketOperationMode.class);
	}
	
}
