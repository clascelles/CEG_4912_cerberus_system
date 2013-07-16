package com.cerberus.model.account.dao;

import java.util.List;

import com.cerberus.model.account.bean.UserSetting;
import com.cerberus.model.generic.dao.GenericDAO;

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
