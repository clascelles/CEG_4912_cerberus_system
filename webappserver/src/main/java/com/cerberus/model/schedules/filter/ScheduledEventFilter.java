package com.cerberus.model.schedules.filter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.cerberus.model.schedules.bean.ScheduledEvent;

public class ScheduledEventFilter {

	public static DetachedCriteria getBySocketId(Integer socketId){
		return DetachedCriteria.forClass(ScheduledEvent.class).
				add(Restrictions.eq("socket.id", socketId));
	}
	
}
