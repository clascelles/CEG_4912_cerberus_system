package com.cerberus.model.usage.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.usage.bean.CurrentDayView;

public class CurrentDayViewDAO extends GenericDAO<CurrentDayView, Integer> {

	
	/***/
	public List<CurrentDayView> getAll(){
		return getAll(CurrentDayView.class);
	}
	
}
