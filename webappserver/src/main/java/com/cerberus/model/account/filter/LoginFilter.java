package com.cerberus.model.account.filter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.cerberus.model.account.bean.Login;

public class LoginFilter {

	public static DetachedCriteria getLoginByUsernameAndPassword(String username, String password){
		return DetachedCriteria.forClass(Login.class).
				add(Restrictions.like("username", username)).
				add(Restrictions.like("passwordValue", password));
	}
	
	public static DetachedCriteria getLoginsBySystemId(Integer systemId){
		return DetachedCriteria.forClass(Login.class).
				add(Restrictions.eq("system.id", systemId));
	}
	
	
}
