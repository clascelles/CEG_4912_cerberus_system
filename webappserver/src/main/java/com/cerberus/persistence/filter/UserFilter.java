package com.cerberus.persistence.filter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.cerberus.persistence.beans.User;

public class UserFilter {

	public static DetachedCriteria getUserByLoginId(Integer loginId){
		return DetachedCriteria.forClass(User.class).
				add(Restrictions.eq("login.id", loginId));
	}
	
}
