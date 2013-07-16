package com.cerberus.model.schedules.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.schedules.bean.ScheduleStartMode;

public class ScheduleStartModeDAO extends GenericDAO<ScheduleStartMode, Integer> {

	/***/
	public ScheduleStartMode getById(Integer id){
		return getById(ScheduleStartMode.class, id);
	}
	
	/***/
	public List<ScheduleStartMode> getAll(){
		return getAll(ScheduleStartMode.class);
	}
	
}
