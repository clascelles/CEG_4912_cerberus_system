package com.cerberus.model.outlets.filter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.cerberus.model.outlets.bean.Outlet;

public class OutletFilter {

	public static DetachedCriteria getByRoomId(Integer roomId){
		return DetachedCriteria.forClass(Outlet.class).
				add(Restrictions.eq("room.id", roomId));
	}

	public static DetachedCriteria getBySerialNumber(String serialNum){
		return DetachedCriteria.forClass(Outlet.class).
				add(Restrictions.eq("serialNumber", serialNum));
	}

}
