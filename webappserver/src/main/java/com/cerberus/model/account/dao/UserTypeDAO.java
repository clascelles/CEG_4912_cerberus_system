package com.cerberus.model.account.dao;

import java.util.List;

import com.cerberus.model.account.bean.UserType;
import com.cerberus.model.generic.dao.GenericDAO;

public class UserTypeDAO extends GenericDAO<UserType, Integer> {

	
	/***/
	public UserType getById(Integer id){
		return getById(UserType.class, id);
	}
	
	/***/
	public List<UserType> getAll(){
		return getAll(UserType.class);
	}	
	
}
