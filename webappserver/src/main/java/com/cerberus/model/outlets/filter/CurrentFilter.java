package com.cerberus.model.outlets.filter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.cerberus.model.outlets.bean.Current;

public class CurrentFilter {

	public static DetachedCriteria getBySocketId(Integer socketId){
		return DetachedCriteria.forClass(Current.class).
				add(Restrictions.eq("socket.id", socketId));
	}
}
