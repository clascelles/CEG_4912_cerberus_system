package com.cerberus.model.security.filter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.cerberus.model.security.bean.RfidTag;

public class RfidTagFilter {

	public static DetachedCriteria getRfidTagByNumber(String number){
		return DetachedCriteria.forClass(RfidTag.class).
				add(Restrictions.like("number", number));
	}

}
