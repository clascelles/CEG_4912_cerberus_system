package com.cerberus.server.persistence.DAO;

import java.util.List;

import com.cerberus.server.persistence.beans.RfidTag;

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
