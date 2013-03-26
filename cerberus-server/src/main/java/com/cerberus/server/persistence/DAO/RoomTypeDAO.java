package com.cerberus.server.persistence.DAO;

import java.util.List;

import com.cerberus.server.persistence.beans.RoomType;

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
