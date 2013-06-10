package com.cerberus.persistence.filter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.cerberus.persistence.beans.Login;

public class LoginFilter {

	public static DetachedCriteria getLoginByUsernameAndPassword(String username, String password){
		return DetachedCriteria.forClass(Login.class).
				add(Restrictions.like("username", username)).
				add(Restrictions.like("passwordValue", password));
	}
	
}
