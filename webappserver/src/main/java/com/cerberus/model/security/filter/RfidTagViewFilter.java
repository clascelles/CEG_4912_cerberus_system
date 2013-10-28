package com.cerberus.model.security.filter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.cerberus.model.security.bean.RfidTagView;

public class RfidTagViewFilter {

	public static DetachedCriteria getRfidTagsByUserId(Integer userId){
		return DetachedCriteria.forClass(RfidTagView.class).
				add(Restrictions.eq("user", userId));
	}

}
