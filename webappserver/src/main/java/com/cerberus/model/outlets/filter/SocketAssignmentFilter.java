package com.cerberus.model.outlets.filter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.cerberus.model.outlets.bean.Socket;
import com.cerberus.model.outlets.bean.SocketAssignment;

public class SocketAssignmentFilter {

	public static DetachedCriteria getBySocket(Socket socket){
		return DetachedCriteria.forClass(SocketAssignment.class).
				add(Restrictions.eq("socket", socket));
	}
	
	public static DetachedCriteria getBySocketId(Integer socketId){
		return DetachedCriteria.forClass(SocketAssignment.class).
				add(Restrictions.eq("socket.id", socketId));
	}
	
}
