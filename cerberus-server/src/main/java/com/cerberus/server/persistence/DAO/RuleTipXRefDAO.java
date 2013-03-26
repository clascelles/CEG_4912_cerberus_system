package com.cerberus.server.persistence.DAO;

import java.util.List;

import com.cerberus.server.persistence.beans.RuleTipXref;

public class RuleTipXRefDAO extends GenericDAO<RuleTipXref, Integer> {

	/***/
	public RuleTipXref getById(Integer id){
		return getById(RuleTipXref.class, id);
	}
	
	/***/
	public List<RuleTipXref> getAll(){
		return getAll(RuleTipXref.class);
	}
	
}
