package com.cerberus.model.security.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.security.bean.RfidTagView;
import com.cerberus.model.security.filter.RfidTagViewFilter;

public class RfidTagViewDAO extends GenericDAO<RfidTagView, Integer> {

	/***/
	public RfidTagView getById(Integer id){
		return getById(RfidTagView.class, id);
	}

	/***/
	public List<RfidTagView> getAll(){
		return getAll(RfidTagView.class);
	}

	public List<RfidTagView> getByUserId(Integer userId) {
		return getAllByFilter(RfidTagViewFilter.getRfidTagsByUserId(userId));
	}
}
