package com.cerberus.persistence.filter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.cerberus.persistence.beans.RfidTag;

public class RfidTagFilter {

	public static DetachedCriteria getRfidTagByNumber(String number){
		return DetachedCriteria.forClass(RfidTag.class).
				add(Restrictions.like("number", number));
	}
	
}
