package com.cerberus.model.usage.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.usage.bean.Tip;

public class TipDAO extends GenericDAO<Tip, Integer> {

	/***/
	public Tip getById(Integer id){
		return getById(Tip.class, id);
	}
	
	/***/
	public List<Tip> getAll(){
		return getAll(Tip.class);
	}
}
