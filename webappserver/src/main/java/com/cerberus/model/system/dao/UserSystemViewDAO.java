package com.cerberus.model.system.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.system.bean.UserSystemView;

public class UserSystemViewDAO extends GenericDAO<UserSystemView, Integer> {

	
	/***/
	public List<UserSystemView> getAll(){
		return getAll(UserSystemView.class);
	}
	
}
