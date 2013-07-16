package com.cerberus.model.outlets.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.outlets.bean.SocketOperationMode;

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
