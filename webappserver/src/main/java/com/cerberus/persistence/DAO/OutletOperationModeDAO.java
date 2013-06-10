package com.cerberus.persistence.DAO;

import java.util.List;

import com.cerberus.persistence.beans.OutletOperationMode;

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
