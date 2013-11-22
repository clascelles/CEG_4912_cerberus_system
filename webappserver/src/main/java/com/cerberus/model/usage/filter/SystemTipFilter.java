package com.cerberus.model.usage.filter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.cerberus.model.usage.bean.SystemTip;


public class SystemTipFilter {
	
	public static DetachedCriteria getTipsIdsForSystem(Integer systemId) {
		return DetachedCriteria.forClass(SystemTip.class)
				.add(Restrictions.eq("systemId", systemId))
				.addOrder(Property.forName("timestamp").desc())
				.setProjection(Projections.property("tipId"));

	}
	
	public static DetachedCriteria getTipsForSystem(Integer systemId) {
		return DetachedCriteria.forClass(SystemTip.class)
				.add(Restrictions.eq("systemId", systemId))
				.addOrder(Property.forName("timestamp").desc());

	}
	
}