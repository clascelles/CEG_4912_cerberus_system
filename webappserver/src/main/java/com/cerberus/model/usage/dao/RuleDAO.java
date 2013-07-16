package com.cerberus.model.usage.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.usage.bean.Rule;

public class RuleDAO extends GenericDAO<Rule, Integer> {

	/***/
	public Rule getById(Integer id){
		return getById(Rule.class, id);
	}
	
	/***/
	public List<Rule> getAll(){
		return getAll(Rule.class);
	}
}
