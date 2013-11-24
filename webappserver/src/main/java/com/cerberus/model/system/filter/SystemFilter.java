package com.cerberus.model.system.filter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;

public class SystemFilter {
	
	public static DetachedCriteria getSystemIds(){
		return DetachedCriteria.forClass(System.class).
				setProjection(Projections.property("id"));
	}
	
}
