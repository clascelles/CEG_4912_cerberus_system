package com.cerberus.model.system.filter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.cerberus.model.system.bean.EventRecord;

public class EventRecordFilter {

	public static DetachedCriteria getByOutletId(Integer outletId){
		return DetachedCriteria.forClass(EventRecord.class).
				add(Restrictions.eq("outletId", outletId));
	}

}
