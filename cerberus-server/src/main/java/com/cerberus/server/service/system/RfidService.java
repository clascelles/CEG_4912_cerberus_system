package com.cerberus.server.service.system;

import com.cerberus.server.persistence.DAO.ConsumptionProfileDAO;
import com.cerberus.server.persistence.DAO.GeneralProfileDAO;
import com.cerberus.server.persistence.DAO.RfidAuthenticationDAO;
import com.cerberus.server.persistence.DAO.RfidTagDAO;
import com.cerberus.server.persistence.beans.RfidTag;

public class RfidService {

	RfidTagDAO rfidTagDAO;
	ConsumptionProfileDAO consumptionProfileDAO;
	GeneralProfileDAO generalProfileDAO;
	RfidAuthenticationDAO rfidAuthenticationDAO;
	
	public RfidService(){
		rfidTagDAO = new RfidTagDAO();
		consumptionProfileDAO = new ConsumptionProfileDAO();
		generalProfileDAO = new GeneralProfileDAO();
		rfidAuthenticationDAO = new RfidAuthenticationDAO();
	}
	
	//***************************************************
	//RFID TAG
	//***************************************************
	
	public void insertRfidTag(RfidTag tag){
		rfidTagDAO.save(tag);
	}
	
	public RfidTag updateRfigTag(RfidTag tag){
		return rfidTagDAO.merge(tag);
	}
	
	public void deleteRfidTag(RfidTag tag){
		rfidTagDAO.delete(tag);
	}
	
	public RfidTag getRfidTagById(Integer id){
		return rfidTagDAO.getById(id);
	}
	
	//public RfidTag getRfidTagByNumber()
	
	
	
	
	
}
