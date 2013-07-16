package com.cerberus.model.account.dao;

import java.util.List;

import com.cerberus.model.account.bean.Login;
import com.cerberus.model.generic.dao.GenericDAO;

public class LoginDAO extends GenericDAO<Login, Integer> {

	/***/
	public Login getById(Integer id){
		return getById(Login.class, id);
	}
	
	/***/
	public List<Login> getAll(){
		return getAll(Login.class);
	}
	
}
