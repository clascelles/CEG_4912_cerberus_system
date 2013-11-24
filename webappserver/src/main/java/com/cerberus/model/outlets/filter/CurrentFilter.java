package com.cerberus.model.outlets.filter;

import java.sql.Time;
import java.util.Date;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;

import com.cerberus.model.outlets.bean.Current;

public class CurrentFilter {

	public static DetachedCriteria getBySocketId(Integer socketId){
		return DetachedCriteria.forClass(Current.class).
				add(Restrictions.eq("socket.id", socketId));
	}
	
	public static DetachedCriteria getDetachedCriteria(){
		return DetachedCriteria.forClass(Current.class);
	}
	
	public static DetachedCriteria addDateRestriction(DetachedCriteria criteria, String operator, Date date){
		if(operator.equals("<")){
			return criteria.add(Restrictions.lt("timestamp", date));
		}else if(operator.equals(">")){
			return criteria.add(Restrictions.gt("timestamp", date));
		}else if(operator.equals("=")){
			return criteria.add(Restrictions.eq("timestamp", date));
		}else{
			return criteria;
		}
	}
	
	public static DetachedCriteria addTimeRestriction(DetachedCriteria criteria, String operator, Time time){
		DateTime today = new DateTime();
		DateTime timeDate = new DateTime(time.getTime());
		today.minus(today.getMillisOfDay()).plus(timeDate.getMillisOfDay());		
		
		
		if(operator.equals("<")){
			return criteria.add(Restrictions.lt("timestamp", today));
		}else if(operator.equals(">")){
			return criteria.add(Restrictions.gt("timestamp", today));
		}else if(operator.equals("=")){
			return criteria.add(Restrictions.eq("timestamp", today));
		}else{
			return criteria;
		}
	}
	
	public static DetachedCriteria addConsumptionRestriction(DetachedCriteria criteria, String operator, double consumption){
		if(operator.equals("<")){
			return criteria.add(Restrictions.lt("current", consumption));
		}else if(operator.equals(">")){
			return criteria.add(Restrictions.gt("current", consumption));
		}else if(operator.equals("=")){
			return criteria.add(Restrictions.eq("current", consumption));
		}else{
			return criteria;
		}
	}
	
	public static DetachedCriteria addApplianceRestriction(DetachedCriteria criteria, String operator, Integer rfidTagId){
		if(operator.equals("<")){
			return criteria.add(Restrictions.lt("rfidTagId.id", rfidTagId));
		}else if(operator.equals(">")){
			return criteria.add(Restrictions.gt("rfidTagId.id", rfidTagId));
		}else if(operator.equals("=")){
			return criteria.add(Restrictions.eq("rfidTagId.id", rfidTagId));
		}else{
			return criteria;
		}
	}
	
	
}
