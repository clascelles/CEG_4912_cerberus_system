package com.cerberus.model.outlets.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.outlets.bean.SocketOperationStatus;

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
