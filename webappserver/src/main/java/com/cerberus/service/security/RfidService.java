package com.cerberus.service.security;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.cerberus.model.security.bean.RfidAuthentication;
import com.cerberus.model.security.bean.RfidTag;
import com.cerberus.model.security.bean.RfidTagView;
import com.cerberus.model.security.dao.RfidAuthenticationDAO;
import com.cerberus.model.security.dao.RfidTagDAO;
import com.cerberus.model.security.dao.RfidTagViewDAO;
import com.cerberus.model.security.filter.RfidTagFilter;
import com.cerberus.model.system.dao.UserSystemViewDAO;
import com.cerberus.module.security.constants.RfidPermission;

public class RfidService {

	RfidTagDAO rfidTagDAO;
	RfidTagViewDAO rfidTagViewDAO;
	RfidAuthenticationDAO rfidAuthenticationDAO;
	UserSystemViewDAO userSystemViewDAO;

	public RfidService(){
		rfidTagDAO = new RfidTagDAO();
		rfidTagViewDAO = new RfidTagViewDAO();
		rfidAuthenticationDAO = new RfidAuthenticationDAO();
		userSystemViewDAO = new UserSystemViewDAO();
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

	public RfidAuthentication getRfidAuthenticationByRfidTagId(Integer rfidTagId) {
		return rfidAuthenticationDAO.getByRfidTagId(rfidTagId);
	}

	//***************************************************
	//RFID TAG VIEW
	//***************************************************

	public RfidTagView getRfidTagViewById(Integer id) {
		return rfidTagViewDAO.getById(id);
	}

	public List<RfidTagView> getRfidTagViewsByUser(Integer userId) {
		return rfidTagViewDAO.getByUserId(userId);
	}

	public void updateRfidTagView(RfidTagView rfidTagView) {
		RfidTag rfidTag = getRfidTagById(rfidTagView.getId());
		RfidAuthentication rfidAuth = getRfidAuthenticationByRfidTagId(rfidTag.getId());

		if(rfidTagView.getDescription() != null) {
			rfidTag.setDescription(rfidTagView.getDescription());
		}

		if(rfidTagView.getPermission() != null && rfidTagView.getPermission() != RfidPermission.UNSET.getIntValue()) {
			rfidAuth.setPermission(rfidTagView.getPermission());
		}

		updateRfigTag(rfidTag);
		updateRfidAuthentication(rfidAuth);
	}
}
