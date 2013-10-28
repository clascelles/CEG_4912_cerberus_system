package com.cerberus.model.system.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.system.bean.UserSystemView;
import com.cerberus.model.system.filter.UserSystemViewFilter;

public class UserSystemViewDAO extends GenericDAO<UserSystemView, Integer> {


	/***/
	public List<UserSystemView> getAll(){
		return getAll(UserSystemView.class);
	}

	public List<UserSystemView> getByUserId(Integer userId) {
		return getAllByFilter(UserSystemViewFilter.getByUserId(userId));
	}

	public List<UserSystemView> getBySystemId(Integer systemId) {
		return getAllByFilter(UserSystemViewFilter.getBySystemId(systemId));
	}

}
