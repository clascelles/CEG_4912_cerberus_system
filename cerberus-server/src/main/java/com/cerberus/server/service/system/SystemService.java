package com.cerberus.server.service.system;

import java.util.List;

import com.cerberus.server.persistence.DAO.*;
import com.cerberus.server.persistence.beans.*;
import com.cerberus.server.persistence.beans.System;
import com.cerberus.server.persistence.filter.RoomFilter;

public class SystemService {
	
	RoomDAO roomDAO;
	RoomTypeDAO roomTypeDAO;
	SystemDAO systemDAO;
	
	public SystemService(){
		roomDAO = new RoomDAO();
		roomTypeDAO = new RoomTypeDAO();
		systemDAO = new SystemDAO();
	}
	
	//***************************************************
	//RoomType
	//***************************************************
	
	public Integer insertRoomType(RoomType roomType){
		return roomTypeDAO.save(roomType);
	}
	
	public RoomType updateRoomType(RoomType roomType){
		return roomTypeDAO.merge(roomType);
	}
	
	public void deleteRoomType(RoomType roomType){
		roomTypeDAO.delete(roomType);
	}
	
	//***************************************************
	//Room
	//***************************************************
	
	public Integer insertRoom(Room room){
		return roomDAO.save(room);
	}
	
	public Room updateRoom(Room room){
		return roomDAO.merge(room);
	}
	
	public void deleteRoom(Room room){
		roomDAO.delete(room);
	}
	
	public List<Room> getRoomByRoomTypeId(Integer roomTypeId){
		return roomDAO.getAllByFilter(RoomFilter.getRoomByRoomTypeId(roomTypeId));
	}
	
	//***************************************************
	//System
	//***************************************************
	
	public Integer insertSystem(System system){
		return systemDAO.save(system);
	}
	
	public System updateSystem(System system){
		return systemDAO.merge(system);
	}
	
	public void deleteSystem(System system){
		systemDAO.delete(system);
	}

}
