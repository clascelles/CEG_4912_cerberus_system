package com.cerberus.model.usage.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.usage.bean.ConsumptionProfile;

public class ConsumptionProfileDAO extends GenericDAO<ConsumptionProfile, Integer> {

	/***/
	public ConsumptionProfile getById(Integer id){
		return getById(ConsumptionProfile.class, id);
	}
	
	/***/
	public List<ConsumptionProfile> getAll(){
		return getAll(ConsumptionProfile.class);
	}
	
}
