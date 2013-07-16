package com.cerberus.model.outlets.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.outlets.bean.OutletOperationMode;

public class OutletOperationModeDAO extends GenericDAO<OutletOperationMode, Integer> {

	/***/
	public OutletOperationMode getById(Integer id){
		return getById(OutletOperationMode.class, id);
	}
	
	/***/
	public List<OutletOperationMode> getAll(){
		return getAll(OutletOperationMode.class);
	}
	
}
