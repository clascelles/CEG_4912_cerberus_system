package com.cerberus.model.usage.filter;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


import com.cerberus.model.usage.bean.CurrentSystemView;


public class CurrentSystemViewFilter {
	
	public static DetachedCriteria getSystemFromCurrentList(List<Integer> currentList) {
		
		return DetachedCriteria.forClass(CurrentSystemView.class).
				add(Restrictions.in("currentId", currentList.toArray()))
				.setProjection(Projections.projectionList()
				.add(Projections.groupProperty("systemId")));
		
	}
	
}