package com.cerberus.persistence.DAO;

import java.util.List;

import com.cerberus.persistence.beans.Current;

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
