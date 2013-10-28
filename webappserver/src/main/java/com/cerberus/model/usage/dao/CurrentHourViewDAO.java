package com.cerberus.model.usage.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.usage.bean.CurrentHourView;

public class CurrentHourViewDAO extends GenericDAO<CurrentHourView, Integer> {

	
	/***/
	public List<CurrentHourView> getAll(){
		return getAll(CurrentHourView.class);
	}
	
}
