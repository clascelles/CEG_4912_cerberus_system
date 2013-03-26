package com.cerberus.server.persistence.DAO;

import java.util.List;

import com.cerberus.server.persistence.beans.Room;

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
