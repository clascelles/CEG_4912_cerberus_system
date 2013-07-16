package com.cerberus.model.system.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.system.bean.System;

public class SystemDAO extends GenericDAO<System, Integer> {

	public System getById(Integer systemId){
		return getById(System.class, systemId);
	}
	
	/***/
	public List<System> getAll(){
		return getAll(System.class);
	}
	
}
