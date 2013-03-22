package com.cerberus.server.service.system;

import java.util.List;

import com.cerberus.server.persistence.DAO.*;
import com.cerberus.server.persistence.beans.*;
import com.cerberus.server.persistence.filter.RoomFilter;

public class SystemService {
	
	RoomDAO roomDAO;
	RoomTypeDAO roomTypeDAO;
	
	public SystemService(){
		roomDAO = new RoomDAO();
		roomTypeDAO = new RoomTypeDAO();
	}
	
	public List<Room> getRoomByRoomTypeId(Integer roomTypeId){
		return roomDAO.getAllByFilter(RoomFilter.getRoomByRoomTypeId(roomTypeId));
	}

}
