package com.cerberus.model.usage.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.usage.bean.EventRecord;
import com.cerberus.model.usage.filter.EventRecordFilter;

public class EventRecordDAO extends GenericDAO<EventRecord, Integer> {

	/***/
	public EventRecord getById(Integer id){
		return getById(EventRecord.class, id);
	}

	/***/
	public List<EventRecord> getAll(){
		return getAll(EventRecord.class);
	}

	public List<EventRecord> getByOutletId(Integer outletId) {
		return getAllByFilter(EventRecordFilter.getByOutletId(outletId));
	}

}
