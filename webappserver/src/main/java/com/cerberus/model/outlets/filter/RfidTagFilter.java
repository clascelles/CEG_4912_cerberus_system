package com.cerberus.model.outlets.filter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.cerberus.model.outlets.bean.RfidTag;

public class RfidTagFilter {

	public static DetachedCriteria getRfidTagByNumber(String number){
		return DetachedCriteria.forClass(RfidTag.class).
				add(Restrictions.like("number", number));
	}
	
}
