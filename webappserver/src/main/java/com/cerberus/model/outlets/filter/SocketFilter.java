package com.cerberus.model.outlets.filter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.cerberus.model.outlets.bean.Socket;

public class SocketFilter {

	public static DetachedCriteria getById(Integer id){
		return DetachedCriteria.forClass(Socket.class).
				add(Restrictions.eq("id", id));
	}

	//TODO: Serial number will be removed from Socket. Will have to get serial number from Outlet instead
	public static DetachedCriteria getBySerialNum(String serialNumber) {
		return DetachedCriteria.forClass(Socket.class).
				add(Restrictions.eq("serialNumber", serialNumber));
	}

	public static DetachedCriteria getByOutletId(Integer outletId){
		return DetachedCriteria.forClass(Socket.class).
				add(Restrictions.eq("outlet.id", outletId));
	}

}
