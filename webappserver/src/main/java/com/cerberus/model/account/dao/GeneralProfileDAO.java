package com.cerberus.model.account.dao;

import java.util.List;

import com.cerberus.model.account.bean.GeneralProfile;
import com.cerberus.model.generic.dao.GenericDAO;

public class GeneralProfileDAO extends GenericDAO<GeneralProfile, Integer> {

	/***/
	public GeneralProfile getById(Integer id){
		return getById(GeneralProfile.class, id);
	}
	
	/***/
	public List<GeneralProfile> getAll(){
		return getAll(GeneralProfile.class);
	}
	
}
