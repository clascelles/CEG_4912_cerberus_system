package com.cerberus.model.outlets.filter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.cerberus.model.outlets.bean.Outlet;

public class OutletFilter {

	public static DetachedCriteria getBySystemId(Integer systemId){
		return DetachedCriteria.forClass(Outlet.class).
				add(Restrictions.eq("systemId", systemId));
	}
	
}
