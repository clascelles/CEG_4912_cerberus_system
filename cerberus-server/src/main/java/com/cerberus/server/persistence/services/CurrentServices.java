package com.cerberus.server.persistence.services;

import com.cerberus.server.persistence.DAO.GenericDAO;
import com.cerberus.server.persistence.beans.Current;

public class CurrentServices {

	private GenericDAO dao = new GenericDAO();
	
	public void insertCurrent(Current current){
		dao.save(current);	
	}
	
}
