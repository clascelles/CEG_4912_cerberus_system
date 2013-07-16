package com.cerberus.model.outlets.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.outlets.bean.Current;

public class CurrentDAO extends GenericDAO<Current, Integer> {

	public CurrentDAO(){
		super();
	}
	
	/***/
	public Current getById(Integer id){
		return getById(Current.class, id);
	}
	
	/***/
	public List<Current> getAll(){
		return getAll(Current.class);
	}

}
