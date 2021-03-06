package com.cerberus.service.usage;

import com.cerberus.model.outlets.bean.Current;
import com.cerberus.model.outlets.dao.CurrentDAO;

public class ConsumptionService {

	private CurrentDAO currentDAO;
	
	public ConsumptionService (){
		currentDAO = new CurrentDAO();
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
	
    //TODO Add the Current Hour
    
}
