package com.cerberus.model.schedules.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.schedules.bean.Schedule;

public class ScheduleDAO extends GenericDAO<Schedule, Integer> {

	/***/
	public Schedule getById(Integer id){
		return getById(Schedule.class, id);
	}
	
	/***/
	public List<Schedule> getAll(){
		return getAll(Schedule.class);
	}
	
}
