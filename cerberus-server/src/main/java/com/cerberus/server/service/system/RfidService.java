package com.cerberus.server.service.system;

import org.hibernate.criterion.DetachedCriteria;

import com.cerberus.server.persistence.DAO.ConsumptionProfileDAO;
import com.cerberus.server.persistence.DAO.GeneralProfileDAO;
import com.cerberus.server.persistence.DAO.RfidAuthenticationDAO;
import com.cerberus.server.persistence.DAO.RfidTagDAO;
import com.cerberus.server.persistence.beans.RfidAuthentication;
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
	
	public RfidTag getRfidTagByNumber(DetachedCriteria criteria){
		return rfidTagDAO.getByFilter(criteria);
	}

	
	//***************************************************
	//RFID AUTHENTICATION
	//***************************************************
	
	public void insertRfidAuthentication(RfidAuthentication rfidAuthentication){
		rfidAuthenticationDAO.save(rfidAuthentication);
	}
	
	public RfidAuthentication updateRfidAuthentication(RfidAuthentication rfidAuthentication){
		return rfidAuthenticationDAO.merge(rfidAuthentication);
	}
	
	public void deleteRfidAuthentication(RfidAuthentication rfidAuthentication){
		rfidAuthenticationDAO.delete(rfidAuthentication);
	}
	
	
	
}
