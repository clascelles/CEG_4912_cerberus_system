package com.cerberus.model.outlets.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.outlets.bean.RfidAuthentication;

public class RfidAuthenticationDAO extends GenericDAO<RfidAuthentication, Integer> {

	/***/
	public RfidAuthentication getById(Integer id){
		return getById(RfidAuthentication.class, id);
	}
	
	/***/
	public List<RfidAuthentication> getAll(){
		return getAll(RfidAuthentication.class);
	}
	
}
