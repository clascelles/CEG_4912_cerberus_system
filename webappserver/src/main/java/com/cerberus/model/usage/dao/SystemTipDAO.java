package com.cerberus.model.usage.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.usage.bean.SystemTip;

public class SystemTipDAO extends GenericDAO<SystemTip, Integer> {

	/***/
	public SystemTip getById(Integer id){
		return getById(SystemTip.class, id);
	}
	
	/***/
	public List<SystemTip> getAll(){
		return getAll(SystemTip.class);
	}
}
