package com.cerberus.model.usage.filter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.cerberus.model.usage.bean.ConsumptionProfile;

public class ConsumptionProfileFilter {

	public static DetachedCriteria getProfileByName(String name){
		return DetachedCriteria.forClass(ConsumptionProfile.class).
				add(Restrictions.eq("name", name));
	}

}
