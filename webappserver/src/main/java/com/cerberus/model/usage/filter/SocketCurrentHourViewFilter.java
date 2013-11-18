package com.cerberus.model.usage.filter;

import java.util.Date;
import java.sql.Timestamp;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;

import com.cerberus.model.usage.bean.SocketCurrentHourView;

public class SocketCurrentHourViewFilter {
	
	public static DetachedCriteria getByLast24Hours(Integer socketId) {	
		return SocketCurrentHourViewFilter.getByThisDay(socketId, new Date());
	}
	
	public static DetachedCriteria getByThisDay(Integer socketId, Date selectedDate) {
		DateTime now = new DateTime(selectedDate);
		DateTime fromDate = new DateTime(now.getYear(), now.getMonthOfYear(), now.getDayOfMonth(), 0, 0);
		DateTime toDate = new DateTime(fromDate.getMillis()).plusDays(1).minusSeconds(1);
		
		Timestamp from = new Timestamp(fromDate.getMillis());
		Timestamp to = new Timestamp(toDate.getMillis());
		
		return SocketCurrentHourViewFilter.getBetweenTimestamp(from, to, socketId);
	}
	
	public static DetachedCriteria getBetweenTimestamp(Timestamp from, Timestamp to, Integer socketId) {

		return DetachedCriteria.forClass(SocketCurrentHourView.class).
				add(Restrictions.between("timestampHour", from, to)).
				add(Restrictions.eq("socketId", socketId));
	}
	
}
