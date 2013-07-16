package com.cerberus.model.account.dao;

import java.util.List;

import com.cerberus.model.account.bean.User;
import com.cerberus.model.generic.dao.GenericDAO;

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
