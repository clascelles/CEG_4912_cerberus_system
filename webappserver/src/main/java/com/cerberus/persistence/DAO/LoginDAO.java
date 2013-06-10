package com.cerberus.persistence.DAO;

import java.util.List;

import com.cerberus.persistence.beans.Login;

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
