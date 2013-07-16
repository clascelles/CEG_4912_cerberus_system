package com.cerberus.model.system.dao;

import java.util.List;

import com.cerberus.model.generic.dao.GenericDAO;
import com.cerberus.model.system.bean.Room;

public class RoomDAO extends GenericDAO<Room, Integer> {

	/***/
	public Room getById(Integer id){
		return getById(Room.class, id);
	}
	
	/***/
	public List<Room> getAll(){
		return getAll(Room.class);
	}
}
