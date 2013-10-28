package com.cerberus.model.usage.filter;

import java.sql.Date;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.cerberus.model.usage.bean.CurrentHourView;


public class CurrentHourViewFilter {
	
	public static DetachedCriteria getByLast24Hours(Integer systemId) {
		Long days = 1000L*60L*60L*24L*152L;
		Date from = new Date(new java.util.Date().getTime() - days);
		Date to = new Date(from.getTime()+ (1000*60*60*24));
		
		return DetachedCriteria.forClass(CurrentHourView.class).
				//add(Restrictions.between("timestampHour", new Date(new java.util.Date().getTime()), new Date(new java.util.Date().getTime()-86400000)));
				add(Restrictions.between("timestampHour", from, to)).
				add(Restrictions.eq("systemId", systemId));
	}
	
}
