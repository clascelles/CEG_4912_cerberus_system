package com.cerberus.model.schedules.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.schedules.bean.ScheduleEndMode;

public class ScheduleEndModeDAO extends GenericDAO<ScheduleEndMode, Integer> {

	/***/
	public ScheduleEndMode getById(Integer id){
		return getById(ScheduleEndMode.class, id);
	}
	
	/***/
	public List<ScheduleEndMode> getAll(){
		return getAll(ScheduleEndMode.class);
	}
	
}
