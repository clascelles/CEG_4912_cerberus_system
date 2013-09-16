package com.cerberus.model.system.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.system.bean.Room;
import com.cerberus.model.system.filter.RoomFilter;

public class RoomDAO extends GenericDAO<Room, Integer> {

	/***/
	public Room getById(Integer id){
		return getById(Room.class, id);
	}
	
	/***/
	public List<Room> getBySystemId(Integer systemId){
		return getAllByFilter(RoomFilter.getBySystemId(systemId));
	}
	
	/***/
	public List<Room> getAll(){
		return getAll(Room.class);
	}
}
