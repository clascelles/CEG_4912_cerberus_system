package com.cerberus.module.account.backingobjects;

import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.system.bean.Room;
import com.cerberus.module.system.workflows.SystemWorkflow;

public class RoomBackingObjectFactory {
	
	public static RoomBackingObject getBackingObject(Room room) {
		RoomBackingObject backingObject = new RoomBackingObject();
		backingObject.setId(room.getId());
		backingObject.setName(room.getName());
		backingObject.setTypeId(room.getRoomType().getId());
		backingObject.setSystemId(room.getSystem().getId());
		return backingObject;		
	}
	
	public static Room bind(RoomBackingObject backingObject) {
		SystemWorkflow systemWorkflow = CerberusApplicationContext.getWorkflows().getSystemWorkflow();
		Room room = new Room();
		room.setId(backingObject.getId());
		room.setName(backingObject.getName());			
		room.setRoomType(systemWorkflow.getRoomTypeById(backingObject.getTypeId()));
		room.setSystem(systemWorkflow.getSystemById(backingObject.getSystemId()));		
		return room;
	}
	
}
