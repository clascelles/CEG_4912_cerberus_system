package com.cerberus.model.usage.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.usage.bean.RuleTipXref;

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
