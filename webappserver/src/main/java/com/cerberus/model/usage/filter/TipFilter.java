package com.cerberus.model.usage.filter;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.cerberus.model.usage.bean.Tip;


public class TipFilter {
	
	public static DetachedCriteria getTipsWithRule() {
		return DetachedCriteria.forClass(Tip.class).
				add(Restrictions.isNotNull("rules"));
		
	}
	
	public static DetachedCriteria getTip(Integer tipId){
		return DetachedCriteria.forClass(Tip.class)
				.add(Restrictions.eq("id", tipId));
	}
	
}