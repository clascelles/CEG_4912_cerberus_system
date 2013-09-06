package com.cerberus.model.system.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.system.bean.CerberusSystem;

public class SystemDAO extends GenericDAO<CerberusSystem, Integer> {

	public CerberusSystem getById(Integer systemId){
		return getById(CerberusSystem.class, systemId);
	}
	
	/***/
	public List<CerberusSystem> getAll(){
		return getAll(CerberusSystem.class);
	}
	
}
