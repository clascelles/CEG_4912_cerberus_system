package com.cerberus.server.persistence.filter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.cerberus.server.persistence.beans.RfidTag;

public class RfidTagFilter {

	public static DetachedCriteria getRfidTagByNumber(String number){
		return DetachedCriteria.forClass(RfidTag.class).
				add(Restrictions.like("number", number));
	}
	
}
