package com.cerberus.persistence.DAO;

import java.util.List;

import com.cerberus.persistence.beans.Rule;

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
