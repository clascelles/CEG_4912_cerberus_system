package com.cerberus.model.system.filter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import com.cerberus.model.system.bean.CerberusSystem;

public class SystemFilter {

	public static DetachedCriteria getSystemByUserId(Integer userId){
		return DetachedCriteria.forClass(CerberusSystem.class).
				add(Restrictions.eq("userId", userId));
	}
	
}
