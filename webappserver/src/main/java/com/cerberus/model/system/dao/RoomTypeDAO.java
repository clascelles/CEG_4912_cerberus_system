package com.cerberus.model.system.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.system.bean.RoomType;

public class RoomTypeDAO extends GenericDAO<RoomType, Integer> {

	/***/
	public RoomType getById(Integer id){
		return getById(RoomType.class, id);
	}
	
	/***/
	public List<RoomType> getAll(){
		return getAll(RoomType.class);
	}
}
