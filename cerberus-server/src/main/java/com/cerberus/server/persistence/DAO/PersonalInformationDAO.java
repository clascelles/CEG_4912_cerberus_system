package com.cerberus.server.persistence.DAO;

import java.util.List;

import com.cerberus.server.persistence.beans.PersonalInformation;

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
