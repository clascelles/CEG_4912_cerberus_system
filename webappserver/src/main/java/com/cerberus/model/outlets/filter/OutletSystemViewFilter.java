package com.cerberus.model.outlets.filter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.cerberus.model.outlets.bean.OutletSystemView;

public class OutletSystemViewFilter {

	public static DetachedCriteria getBySystemId(Integer systemId) {
		return DetachedCriteria.forClass(OutletSystemView.class)
				.add(Restrictions.eq("systemId", systemId));
	}

}
