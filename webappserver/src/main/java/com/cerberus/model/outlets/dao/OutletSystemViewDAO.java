package com.cerberus.model.outlets.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.outlets.bean.OutletSystemView;
import com.cerberus.model.outlets.filter.OutletSystemViewFilter;

public class OutletSystemViewDAO extends GenericDAO<OutletSystemView, Integer> {

	/***/
	public OutletSystemView getById(Integer id){
		return getById(OutletSystemView.class, id);
	}

	/***/
	public List<OutletSystemView> getAll(){
		return getAll(OutletSystemView.class);
	}

	public List<OutletSystemView> getBySystemId(Integer systemId) {
		return getAllByFilter(OutletSystemViewFilter.getBySystemId(systemId));
	}
}
