package com.cerberus.server.persistence.filter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.cerberus.server.persistence.beans.SocketAssignment;

public class SocketAssignmentFilter {

	public static DetachedCriteria getUserFromSocketId(Integer socketId){
		return DetachedCriteria.forClass(SocketAssignment.class).
				add(Restrictions.eq("socket.id", socketId));
	}
	
}
