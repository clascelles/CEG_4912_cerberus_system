package com.cerberus.server.persistence.filter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.cerberus.server.persistence.beans.Socket;

public class SocketFilter {

	public static DetachedCriteria getById(Integer id){
		return DetachedCriteria.forClass(Socket.class).
				add(Restrictions.eq("id", id));
	}
	
	public static DetachedCriteria getBySerialNum(Integer serialNumber){
		return DetachedCriteria.forClass(Socket.class).
				add(Restrictions.eq("serialNumber", serialNumber.toString()));
	}
	
}
