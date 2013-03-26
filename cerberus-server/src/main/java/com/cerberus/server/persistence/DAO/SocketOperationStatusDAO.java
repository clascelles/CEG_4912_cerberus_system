package com.cerberus.server.persistence.DAO;

import java.util.List;

import com.cerberus.server.persistence.beans.SocketOperationStatus;

public class SocketOperationStatusDAO extends GenericDAO<SocketOperationStatus, Integer> {

	/***/
	public SocketOperationStatus getById(Integer id){
		return getById(SocketOperationStatus.class, id);
	}
	
	/***/
	public List<SocketOperationStatus> getAll(){
		return getAll(SocketOperationStatus.class);
	}
}
