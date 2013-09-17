package com.cerberus.model.outlets.filter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.cerberus.model.outlets.bean.OutletOperationMode;

public class OutletOperationModeFilter {

	public static DetachedCriteria getById(Integer id){
		return DetachedCriteria.forClass(OutletOperationMode.class).
				add(Restrictions.eq("id", id));
	}
	
	public static DetachedCriteria getByName(String name) {
		return DetachedCriteria.forClass(OutletOperationMode.class).
				add(Restrictions.eq("name", name));
	}
	
}
