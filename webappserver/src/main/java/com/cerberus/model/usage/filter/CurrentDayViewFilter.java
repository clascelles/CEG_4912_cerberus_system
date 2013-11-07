package com.cerberus.model.usage.filter;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;

import com.cerberus.model.usage.bean.CurrentDayView;


public class CurrentDayViewFilter {
	
	public static DetachedCriteria getByLastMonth(Integer systemId) {
		
		return CurrentDayViewFilter.getByThisMonth(systemId, new Date());
	}
	
	public static DetachedCriteria getByThisMonth(Integer systemId, Date selectedDate) {
		DateTime now = new DateTime(selectedDate);
		DateTime fromDate = new DateTime(now.getYear(), now.getMonthOfYear(), 1, 0, 0);
		DateTime toDate = new DateTime(fromDate.getMillis()).plusMonths(1).minusDays(1);
		
		Timestamp from = new Timestamp(fromDate.getMillis());
		Timestamp to = new Timestamp(toDate.getMillis());
		
		return CurrentDayViewFilter.getBetweenTimestamp(from, to, systemId);
	}
	
	
	public static DetachedCriteria getBetweenTimestamp(Timestamp from, Timestamp to, Integer systemId) {

		return DetachedCriteria.forClass(CurrentDayView.class).
				add(Restrictions.between("timestampDay", from, to)).
				add(Restrictions.eq("systemId", systemId));
	}
	
}
