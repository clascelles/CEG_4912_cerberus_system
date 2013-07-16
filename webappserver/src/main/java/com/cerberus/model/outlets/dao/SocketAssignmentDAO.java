package com.cerberus.model.outlets.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.outlets.bean.SocketAssignment;

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
