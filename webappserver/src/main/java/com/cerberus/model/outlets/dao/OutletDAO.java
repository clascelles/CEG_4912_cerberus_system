package com.cerberus.model.outlets.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.outlets.bean.Outlet;

public class OutletDAO extends GenericDAO<Outlet, Integer> {

	/***/
	public Outlet getById(Integer id){
		return getById(Outlet.class, id);
	}
	
	/***/
	public List<Outlet> getAll(){
		return getAll(Outlet.class);
	}
	
}
