package com.cerberus.model.account.dao;

import java.util.List;

import com.cerberus.model.account.bean.PersonalInformation;
import com.cerberus.model.generic.dao.GenericDAO;

public class PersonalInformationDAO extends GenericDAO<PersonalInformation, Integer> {

	/***/
	public PersonalInformation getById(Integer id){
		return getById(PersonalInformation.class, id);
	}
	
	/***/
	public List<PersonalInformation> getAll(){
		return getAll(PersonalInformation.class);
	}
	
}
