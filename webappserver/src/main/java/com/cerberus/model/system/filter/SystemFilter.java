package com.cerberus.model.system.filter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import com.cerberus.model.system.bean.CerberusSystem;

public class SystemFilter {
	
	public static DetachedCriteria getSystemIds(){
		return DetachedCriteria.forClass(CerberusSystem.class).
				setProjection(Projections.property("id"));
	}
	
}
