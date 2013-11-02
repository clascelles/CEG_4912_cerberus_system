package com.cerberus.model.security.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.security.bean.RfidAuthentication;
import com.cerberus.model.security.filter.RfidAuthenticationFilter;

public class RfidAuthenticationDAO extends GenericDAO<RfidAuthentication, Integer> {

	/***/
	public RfidAuthentication getById(Integer id){
		return getById(RfidAuthentication.class, id);
	}

	/***/
	public List<RfidAuthentication> getAll(){
		return getAll(RfidAuthentication.class);
	}

	public RfidAuthentication getByRfidTagId(Integer rfidTagId) {
		return getByFilter(RfidAuthenticationFilter.getRfidAuthenticationByRfidTagId(rfidTagId));
	}

}
