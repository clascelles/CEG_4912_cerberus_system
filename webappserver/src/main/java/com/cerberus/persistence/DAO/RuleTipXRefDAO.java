package com.cerberus.persistence.DAO;

import java.util.List;

import com.cerberus.persistence.beans.RuleTipXref;

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
