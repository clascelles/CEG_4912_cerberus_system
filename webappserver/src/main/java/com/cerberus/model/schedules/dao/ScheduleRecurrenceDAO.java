package com.cerberus.model.schedules.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.schedules.bean.ScheduleRecurrence;

public class ScheduleRecurrenceDAO extends GenericDAO<ScheduleRecurrence, Integer> {

	/***/
	public ScheduleRecurrence getById(Integer id){
		return getById(ScheduleRecurrence.class, id);
	}
	
	/***/
	public List<ScheduleRecurrence> getAll(){
		return getAll(ScheduleRecurrence.class);
	}
	
}
