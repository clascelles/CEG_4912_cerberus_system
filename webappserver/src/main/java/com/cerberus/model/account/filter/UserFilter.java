package com.cerberus.model.account.filter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.cerberus.model.account.bean.User;

public class UserFilter {

	public static DetachedCriteria getUserByLoginId(Integer loginId){
		return DetachedCriteria.forClass(User.class).
				add(Restrictions.eq("login.id", loginId));
	}
	
}
