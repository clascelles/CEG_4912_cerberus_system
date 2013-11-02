package com.cerberus.model.security.filter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.cerberus.model.security.bean.RfidAuthentication;

public class RfidAuthenticationFilter {

	public static DetachedCriteria getRfidAuthenticationByRfidTagId(Integer rfidTagId){
		return DetachedCriteria.forClass(RfidAuthentication.class).
				add(Restrictions.eq("rfidTagId", rfidTagId));
	}

}
