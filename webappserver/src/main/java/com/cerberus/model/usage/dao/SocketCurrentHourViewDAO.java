package com.cerberus.model.usage.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.usage.bean.SocketCurrentHourView;

public class SocketCurrentHourViewDAO extends GenericDAO<SocketCurrentHourView, Integer> {

	
	/***/
	public List<SocketCurrentHourView> getAll(){
		return getAll(SocketCurrentHourView.class);
	}
	
}
