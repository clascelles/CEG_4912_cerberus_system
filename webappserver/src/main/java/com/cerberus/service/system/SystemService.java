package com.cerberus.service.system;

import java.util.List;

import com.cerberus.model.system.bean.Room;
import com.cerberus.model.system.bean.RoomType;
import com.cerberus.model.system.bean.CerberusSystem;
import com.cerberus.model.system.dao.RoomDAO;
import com.cerberus.model.system.dao.RoomTypeDAO;
import com.cerberus.model.system.dao.SystemDAO;
import com.cerberus.model.system.filter.RoomFilter;
import com.cerberus.model.system.filter.SystemFilter;

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
	
	public List<Room> getAllRooms() {
		return roomDAO.getAll();
	}
	
	public List<Room> getRooms(Integer systemId) {
		return roomDAO.getBySystemId(systemId);
	}
	
	public List<Room> getRoomByRoomTypeId(Integer roomTypeId){
		return roomDAO.getAllByFilter(RoomFilter.getRoomByRoomTypeId(roomTypeId));
	}
	
	//***************************************************
	//System
	//***************************************************
	
	public Integer insertSystem(CerberusSystem system){
		return systemDAO.save(system);
	}
	
	public CerberusSystem updateSystem(CerberusSystem system){
		return systemDAO.merge(system);
	}
	
	public void deleteSystem(CerberusSystem system){
		systemDAO.delete(system);
	}
	
	public CerberusSystem getSystemByUserId(Integer userId){
		return systemDAO.getByFilter(SystemFilter.getSystemByUserId(userId));
	}

}
