package com.cerberus.model.usage.filter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import com.cerberus.model.usage.bean.Tip;


public class TipFilter {
	
	public static DetachedCriteria getTipsWithRule() {
		return DetachedCriteria.forClass(Tip.class).
				add(Restrictions.isNotNull("rules"));
		
	}
	
}