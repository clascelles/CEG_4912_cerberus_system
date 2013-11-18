package com.cerberus.model.usage.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.usage.bean.CurrentSystemView;

public class CurrentSystemViewDAO extends GenericDAO<CurrentSystemView, Integer> {

	public CurrentSystemView getByCurrentId(Integer currentId) {
		return getById(CurrentSystemView.class, currentId);
	}

	public List<CurrentSystemView> getAll() {
		return getAll(CurrentSystemView.class);
	}

}
