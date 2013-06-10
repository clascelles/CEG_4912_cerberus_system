package com.cerberus.persistence.DAO;

import java.util.List;

import com.cerberus.persistence.beans.User;

public class UserDAO extends GenericDAO<User, Integer> {

	/***/
	public User getById(Integer id){
		return getById(User.class, id);
	}
	
	/***/
	public List<User> getAll(){
		return getAll(User.class);
	}
	
}
