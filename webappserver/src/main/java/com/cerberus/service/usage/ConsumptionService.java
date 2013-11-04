package com.cerberus.service.usage;

import java.util.List;

import com.cerberus.model.outlets.bean.Current;
import com.cerberus.model.outlets.dao.CurrentDAO;
import com.cerberus.model.usage.bean.CurrentHourView;
import com.cerberus.model.usage.dao.CurrentHourViewDAO;
import com.cerberus.model.usage.filter.CurrentHourViewFilter;

public class ConsumptionService {

	private final CurrentDAO currentDAO;
	private final CurrentHourViewDAO currentHourViewDAO;

	public ConsumptionService (){
		currentDAO = new CurrentDAO();
		currentHourViewDAO = new CurrentHourViewDAO();
		//Add all the necessary DAOs here
	}

	//*************************************************
	//CURRENT
	//*************************************************

	public Integer insertCurrent(Current current){
		return currentDAO.save(current);
	}

	public Current updateCurrent(Current current){
		return currentDAO.merge(current);
	}

	public void deleteCurrent(Current current){
		currentDAO.delete(current);
	}

	public Current getCurrentById(Integer id){
		return currentDAO.getById(id);
	}

	//*************************************************
	//CURRENT HOUR
	//*************************************************

	public List<CurrentHourView> getCurrentHourForLast24h(Integer systemId){

		//Should never be more then 24 item in this list.
		return currentHourViewDAO.getAllByFilter(CurrentHourViewFilter.getByLast24Hours(systemId));

	}

}
