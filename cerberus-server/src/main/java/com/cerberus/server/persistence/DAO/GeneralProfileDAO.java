package com.cerberus.server.persistence.DAO;

import java.util.List;

import com.cerberus.server.persistence.beans.GeneralProfile;

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
