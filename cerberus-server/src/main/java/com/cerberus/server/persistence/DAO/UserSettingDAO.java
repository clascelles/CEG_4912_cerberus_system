package com.cerberus.server.persistence.DAO;

import java.util.List;

import com.cerberus.server.persistence.beans.UserSetting;

public class UserSettingDAO extends GenericDAO<UserSetting, Integer> {

	/***/
	public UserSetting getById(Integer id){
		return getById(UserSetting.class, id);
	}
	
	/***/
	public List<UserSetting> getAll(){
		return getAll(UserSetting.class);
	}
	
}
