package com.cerberus.model.usage.filter;

import java.util.Date;
import java.sql.Timestamp;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;

import com.cerberus.model.usage.bean.CurrentHourView;


public class CurrentHourViewFilter {
	
	public static DetachedCriteria getByLast24Hours(Integer systemId) {	
		return CurrentHourViewFilter.getByThisDay(systemId, new Date());
	}
	
	public static DetachedCriteria getByThisDay(Integer systemId, Date selectedDate) {
		DateTime now = new DateTime(selectedDate);
		DateTime fromDate = new DateTime(now.getYear(), now.getMonthOfYear(), now.getDayOfMonth(), 0, 0);
		DateTime toDate = new DateTime(fromDate.getMillis()).plusDays(1).minusSeconds(1);
		
		Timestamp from = new Timestamp(fromDate.getMillis());
		Timestamp to = new Timestamp(toDate.getMillis());
		
		return CurrentHourViewFilter.getBetweenTimestamp(from, to, systemId);
	}
	
	public static DetachedCriteria getBetweenTimestamp(Timestamp from, Timestamp to, Integer systemId) {

		return DetachedCriteria.forClass(CurrentHourView.class).
				add(Restrictions.between("timestampHour", from, to)).
				add(Restrictions.eq("systemId", systemId));
	}
	
}
