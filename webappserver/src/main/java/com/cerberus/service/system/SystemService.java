package com.cerberus.service.system;

import java.util.List;

import com.cerberus.model.account.bean.UserType;
import com.cerberus.model.system.bean.CerberusSystem;
import com.cerberus.model.system.bean.Room;
import com.cerberus.model.system.bean.RoomType;
import com.cerberus.model.system.bean.UserSystemView;
import com.cerberus.model.system.dao.RoomDAO;
import com.cerberus.model.system.dao.RoomTypeDAO;
import com.cerberus.model.system.dao.SystemDAO;
import com.cerberus.model.system.dao.UserSystemViewDAO;
import com.cerberus.model.system.filter.RoomFilter;
import com.cerberus.model.system.filter.RoomTypeFilter;

public class SystemService {

	RoomDAO roomDAO;
	RoomTypeDAO roomTypeDAO;
	SystemDAO systemDAO;
	UserSystemViewDAO userSystemViewDAO;

	public SystemService(){
		roomDAO = new RoomDAO();
		roomTypeDAO = new RoomTypeDAO();
		systemDAO = new SystemDAO();
		userSystemViewDAO = new UserSystemViewDAO();
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

	public List<RoomType> getAllRoomTypes() {
		return roomTypeDAO.getAll();
	}

	public RoomType getRoomTypeById(Integer id) {
		return roomTypeDAO.getByFilter(RoomTypeFilter.getById(id));
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

	public Room getRoomById(Integer id) {
		return roomDAO.getById(id);
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

	public CerberusSystem getSystemById(Integer id) {
		return systemDAO.getById(id);
	}

	//***************************************************
	//User/System View
	//***************************************************

	public Integer getSystemIdByUserId(Integer userId){
		return userSystemViewDAO.getByUserId(userId).get(0).getSystemId();
	}

	public Integer getUserIdBySystemId(Integer systemId){
		return userSystemViewDAO.getBySystemId(systemId).get(0).getUserId();
	}

	public Integer getSysOwnerOfSystem(Integer systemId) {
		List<UserSystemView> users = userSystemViewDAO.getBySystemId(systemId);

		for(UserSystemView userView : users) {
			if(userView.getUserTypeId() == UserType.SYSTEM_OWNER_ID) {
				return userView.getUserId();
			}
		}

		return null;
	}


}
