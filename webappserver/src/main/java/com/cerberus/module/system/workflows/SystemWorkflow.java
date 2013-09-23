package com.cerberus.module.system.workflows;

import java.util.ArrayList;
import java.util.List;

import com.cerberus.model.account.bean.User;
import com.cerberus.model.system.bean.CerberusSystem;
import com.cerberus.model.system.bean.Room;
import com.cerberus.model.system.bean.RoomType;
import com.cerberus.module.account.backingobjects.RoomBackingObject;
import com.cerberus.module.account.backingobjects.RoomBackingObjectFactory;
import com.cerberus.module.generic.workflows.Workflow;
import com.cerberus.service.system.SystemService;

public class SystemWorkflow extends Workflow {
	
	public List<RoomBackingObject> getRoomsForUser(User user) {

		SystemService systemService = serviceFactory.getSystemService();	
		
		CerberusSystem system = user.getLogin().getSystem();
		
		List<Room> rooms = systemService.getRooms(system.getId());
		
		List<RoomBackingObject> backingObjects = new ArrayList<RoomBackingObject>();
		
		if(rooms != null){
			for(Room room : rooms){
				backingObjects.add(RoomBackingObjectFactory.getBackingObject(room));
			}
		}
		
		this.returnServiceFactory();
		
		return backingObjects;
	}
	
	public Room getRoomById(Integer id) {
		SystemService systemService = serviceFactory.getSystemService();
		
		Room room = systemService.getRoomById(id);
		
		this.returnServiceFactory();
		
		return room; 
	}
	
	public List<Room> getRoomsByRoomTypeId(Integer id) {
		SystemService systemService = serviceFactory.getSystemService();
		
		List<Room> rooms = systemService.getRoomByRoomTypeId(id);
		
		this.returnServiceFactory();
		
		return rooms; 
	}
	
	public RoomType getRoomTypeById(Integer id) {
		SystemService systemService = serviceFactory.getSystemService();
		
		RoomType roomType = systemService.getRoomTypeById(id);
		
		this.returnServiceFactory();
		
		return roomType; 
	}
	
	public CerberusSystem getSystemById(Integer id) {
		SystemService systemService = serviceFactory.getSystemService();
		
		CerberusSystem system = systemService.getSystemById(id);
		
		this.returnServiceFactory();
		
		return system; 
	}
}
