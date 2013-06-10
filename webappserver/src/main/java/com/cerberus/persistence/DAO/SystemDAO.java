package com.cerberus.persistence.DAO;

import java.util.List;

import com.cerberus.persistence.beans.System;

public class SystemDAO extends GenericDAO<System, Integer> {

	public System getById(Integer systemId){
		return getById(System.class, systemId);
	}
	
	/***/
	public List<System> getAll(){
		return getAll(System.class);
	}
	
}
