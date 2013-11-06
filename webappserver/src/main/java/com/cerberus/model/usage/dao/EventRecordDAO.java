package com.cerberus.model.usage.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.usage.bean.EventRecord;

public class EventRecordDAO extends GenericDAO<EventRecord, Integer> {

	/***/
	public EventRecord getById(Integer id){
		return getById(EventRecord.class, id);
	}
	
	/***/
	public List<EventRecord> getAll(){
		return getAll(EventRecord.class);
	}
	
}
