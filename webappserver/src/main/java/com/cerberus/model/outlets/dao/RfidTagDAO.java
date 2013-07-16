package com.cerberus.model.outlets.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.outlets.bean.RfidTag;

public class RfidTagDAO extends GenericDAO<RfidTag, Integer> {

	/***/
	public RfidTag getById(Integer id){
		return getById(RfidTag.class, id);
	}
	
	/***/
	public List<RfidTag> getAll(){
		return getAll(RfidTag.class);
	}
}
