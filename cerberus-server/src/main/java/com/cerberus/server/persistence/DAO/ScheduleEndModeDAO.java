package com.cerberus.server.persistence.DAO;

import java.util.List;

import com.cerberus.server.persistence.beans.ScheduleEndMode;

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
