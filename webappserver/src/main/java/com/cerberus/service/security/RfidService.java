package com.cerberus.service.security;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.cerberus.model.security.bean.RfidAuthentication;
import com.cerberus.model.security.bean.RfidTag;
import com.cerberus.model.security.bean.RfidTagView;
import com.cerberus.model.security.dao.RfidAuthenticationDAO;
import com.cerberus.model.security.dao.RfidTagDAO;
import com.cerberus.model.security.dao.RfidTagViewDAO;
import com.cerberus.model.security.filter.RfidTagFilter;
import com.cerberus.model.usage.bean.ConsumptionProfile;
import com.cerberus.model.usage.dao.ConsumptionProfileDAO;
import com.cerberus.module.security.constants.RfidPermission;

public class RfidService {

	RfidTagDAO rfidTagDAO;
	RfidTagViewDAO rfidTagViewDAO;
	RfidAuthenticationDAO rfidAuthenticationDAO;
	ConsumptionProfileDAO profileDAO;

	public RfidService(){
		rfidTagDAO = new RfidTagDAO();
		rfidTagViewDAO = new RfidTagViewDAO();
		rfidAuthenticationDAO = new RfidAuthenticationDAO();
		profileDAO = new ConsumptionProfileDAO();
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
	//CONSUMPTION PROFILE
	//***************************************************

	public ConsumptionProfile getProfileById(Integer id) {
		return profileDAO.getById(id);
	}

	public ConsumptionProfile getProfileByName(String name) {
		return profileDAO.getByName(name);
	}

	public List<String> getAllProfileNames() {
		List<String> profileNames = new ArrayList<String>();
		List<ConsumptionProfile> allProfiles = profileDAO.getAll();

		for (ConsumptionProfile profile : allProfiles) {
			profileNames.add(profile.getName());
		}

		return profileNames;
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
		if(rfidTag == null) {
			// Shouldn't be able to update rfid tag that doesn't exists!
			return;
		}
		RfidAuthentication rfidAuth = getRfidAuthenticationByRfidTagId(rfidTag.getId());

		if(rfidTagView.getName() != null) {
			rfidTag.setTagName(rfidTagView.getName());
		}

		if(rfidTagView.getPermission() != null && rfidTagView.getPermission() != RfidPermission.UNSET.getIntValue()) {
			rfidAuth.setPermission(rfidTagView.getPermission());
		}

		if(rfidTagView.getProfileName() != null) {
			rfidTag.setProfile(getProfileByName(rfidTagView.getProfileName()));
		}

		updateRfigTag(rfidTag);
		updateRfidAuthentication(rfidAuth);
	}
}
