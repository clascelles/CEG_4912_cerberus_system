package com.cerberus.service.system;

import org.hibernate.criterion.DetachedCriteria;

import com.cerberus.persistence.DAO.ConsumptionProfileDAO;
import com.cerberus.persistence.DAO.GeneralProfileDAO;
import com.cerberus.persistence.DAO.RfidAuthenticationDAO;
import com.cerberus.persistence.DAO.RfidTagDAO;
import com.cerberus.persistence.beans.RfidAuthentication;
import com.cerberus.persistence.beans.RfidTag;
import com.cerberus.persistence.filter.RfidTagFilter;

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

	public RfidTag getRfidTagByNumber(String number) {
		DetachedCriteria criteria = RfidTagFilter.getRfidTagByNumber(number);
		return rfidTagDAO.getByFilter(criteria);
	}


	//***************************************************
	//RFID AUTHENTICATION
	//***************************************************

	public Integer insertRfidAuthentication(RfidAuthentication rfidAuthentication){
		return rfidAuthenticationDAO.save(rfidAuthentication);
	}

	public RfidAuthentication updateRfidAuthentication(RfidAuthentication rfidAuthentication){
		return rfidAuthenticationDAO.merge(rfidAuthentication);
	}

	public void deleteRfidAuthentication(RfidAuthentication rfidAuthentication){
		rfidAuthenticationDAO.delete(rfidAuthentication);
	}



}
