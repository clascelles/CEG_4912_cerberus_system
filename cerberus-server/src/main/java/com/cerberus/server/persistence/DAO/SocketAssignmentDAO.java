package com.cerberus.server.persistence.DAO;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.cerberus.server.persistence.beans.SocketAssignment;

public class SocketAssignmentDAO extends GenericDAO<SocketAssignment, Integer> {

	public SocketAssignment getById(Integer socketAssignmentId){
		return getById(SocketAssignment.class, socketAssignmentId);
	}
	
	public List<SocketAssignment> getAll(){
		return getAll(SocketAssignment.class);
	}
	
	public List<SocketAssignment> getAll(DetachedCriteria criterias){
		return getAll(criterias);
	}
	
}
