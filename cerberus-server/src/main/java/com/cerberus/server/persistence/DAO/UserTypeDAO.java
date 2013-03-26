package com.cerberus.server.persistence.DAO;

import java.util.List;

import com.cerberus.server.persistence.beans.UserType;

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
