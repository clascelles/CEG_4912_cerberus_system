package com.cerberus.module.account.backingobjects;

import com.cerberus.model.system.bean.Room;
import com.cerberus.module.generic.workflows.Workflows;

public class RoomBackingObjectFactory {
	
	public static RoomBackingObject getBackingObject(Room room) {
		RoomBackingObject backingObject = new RoomBackingObject();
		backingObject.setId(room.getId());
		backingObject.setName(room.getName());
		backingObject.setTypeId(room.getRoomType().getId());
		backingObject.setSystemId(room.getSystemId());
		return backingObject;		
	}
	
	public static Room bind(RoomBackingObject backingObject) {
		Room room = new Room();
		room.setId(backingObject.getId());
		room.setName(backingObject.getName());			
		room.setRoomType(new Workflows().getSystemWorkflow().getRoomTypeById(backingObject.getTypeId()));
		room.setSystemId(backingObject.getSystemId());		
		return room;
	}
	
}
