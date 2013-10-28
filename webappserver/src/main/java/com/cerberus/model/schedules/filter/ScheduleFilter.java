package com.cerberus.model.schedules.filter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.cerberus.model.schedules.bean.Schedule;

public class ScheduleFilter {

	public static DetachedCriteria getBySocketId(Integer socketId){
		return DetachedCriteria.forClass(Schedule.class).
				add(Restrictions.eq("socket.id", socketId));
	}
	
	public static DetachedCriteria getByUserId(Integer userId){
		return DetachedCriteria.forClass(Schedule.class).
				add(Restrictions.eq("user.id", userId));
	}
	
	public static DetachedCriteria getByRecurrenceId(Integer recurrenceId){
		return DetachedCriteria.forClass(Schedule.class).
				add(Restrictions.eq("recurrence.id", recurrenceId));
	}
	
}
