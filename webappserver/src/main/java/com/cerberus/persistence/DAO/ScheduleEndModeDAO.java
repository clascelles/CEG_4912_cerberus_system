package com.cerberus.persistence.DAO;

import java.util.List;

import com.cerberus.persistence.beans.ScheduleEndMode;

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
