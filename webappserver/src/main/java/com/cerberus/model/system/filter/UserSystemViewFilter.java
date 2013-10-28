package com.cerberus.model.system.filter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.cerberus.model.system.bean.UserSystemView;

public class UserSystemViewFilter {

	public static DetachedCriteria getByUserId(Integer id){
		return DetachedCriteria.forClass(UserSystemView.class).
				add(Restrictions.eq("userId", id));
	}
	
	public static DetachedCriteria getBySystemId(Integer id){
		return DetachedCriteria.forClass(UserSystemView.class).
				add(Restrictions.eq("systemId", id));
	}
	
}
