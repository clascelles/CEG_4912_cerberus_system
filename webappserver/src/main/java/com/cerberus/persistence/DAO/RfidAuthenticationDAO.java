package com.cerberus.persistence.DAO;

import java.util.List;

import com.cerberus.persistence.beans.RfidAuthentication;

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
