package com.cerberus.model.usage.filter;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.cerberus.model.usage.bean.Tip;


public class TipFilter {
	
	public static DetachedCriteria getTipsWithRule() {
		return DetachedCriteria.forClass(Tip.class)
				.add(Restrictions.isNotEmpty("rules"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
	}
	
	public static DetachedCriteria getTipsWithoutRule() {
		return DetachedCriteria.forClass(Tip.class)
				.add(Restrictions.isEmpty("rules"))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
	}
	
	public static DetachedCriteria getTip(Integer tipId){
		return DetachedCriteria.forClass(Tip.class)
				.add(Restrictions.eq("id", tipId));
	}
	
}