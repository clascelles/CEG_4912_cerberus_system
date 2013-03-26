package com.cerberus.server.persistence.filter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.cerberus.server.persistence.beans.Socket;
import com.cerberus.server.persistence.beans.SocketAssignment;

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
