package com.cerberus.server.persistence.DAO;

import java.util.List;

import com.cerberus.server.persistence.beans.ScheduleStartMode;

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
