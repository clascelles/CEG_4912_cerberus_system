package com.cerberus.service.security;

import org.hibernate.criterion.DetachedCriteria;

import com.cerberus.model.account.dao.GeneralProfileDAO;
import com.cerberus.model.security.bean.RfidAuthentication;
import com.cerberus.model.security.bean.RfidTag;
import com.cerberus.model.security.dao.RfidAuthenticationDAO;
import com.cerberus.model.security.dao.RfidTagDAO;
import com.cerberus.model.security.filter.RfidTagFilter;
import com.cerberus.model.usage.dao.ConsumptionProfileDAO;

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

	public RfidAuthentication getRfidAuthenticationById(Integer id) {
		return rfidAuthenticationDAO.getById(id);
	}

}
