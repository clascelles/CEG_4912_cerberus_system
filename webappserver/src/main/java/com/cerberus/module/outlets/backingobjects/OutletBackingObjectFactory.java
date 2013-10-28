package com.cerberus.module.outlets.backingobjects;

import java.util.List;

import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.account.bean.User;
import com.cerberus.model.outlets.bean.Outlet;
import com.cerberus.model.outlets.bean.OutletOperationMode;
import com.cerberus.model.system.bean.Room;
import com.cerberus.model.system.bean.RoomType;
import com.cerberus.module.generic.backingobjects.BackingObjectFactory;
import com.cerberus.module.generic.workflows.Workflows;

public class OutletBackingObjectFactory extends BackingObjectFactory<Outlet, OutletBackingObject> {
	
	public static OutletBackingObjectFactory INSTANCE = new OutletBackingObjectFactory();
		
	@Override
	public OutletBackingObject getBackingObject(User user) {
		OutletBackingObject backingObject = new OutletBackingObject();
		return backingObject;
	}

	@Override
	public OutletBackingObject getBackingObject(Outlet outlet) {
		OutletBackingObject backingObject = new OutletBackingObject();
		backingObject.setId(outlet.getId());
		backingObject.setModeId(outlet.getMode().getId());
		backingObject.setModeName(outlet.getMode().getName());
		backingObject.setRoomId(outlet.getRoom().getId());
		backingObject.setRoomName(outlet.getRoom().getName());
		backingObject.setSerialNumber(outlet.getSerialNumber());
		return backingObject;
	}

	@Override
	public Outlet bind(OutletBackingObject backingObject, User user) {
		Workflows workflows = CerberusApplicationContext.getWorkflows();
		
		Outlet outlet;
		
		if(backingObject.getId() != null) {
			outlet = workflows.getOutletWorkflow().getOutletById(backingObject.getId());
			if(outlet == null) {
				outlet = new Outlet();
				outlet.setId(backingObject.getId());			
			}			
		} else {
			outlet = new Outlet();
			outlet.setId(backingObject.getId());
		}
		
		if(backingObject.getModeId() != null) {
			outlet.setMode(workflows.getOutletWorkflow().getOutletOperationModeById(backingObject.getModeId()));			
		} else {
			outlet.setMode(workflows.getOutletWorkflow().getOutletOperationModeById(OutletOperationMode.DISABLED));
		}
		
		if(backingObject.getRoomId() != null) {
			outlet.setRoom(workflows.getSystemWorkflow().getRoomById(backingObject.getRoomId()));			
		} else {
			List<Room> kitchens = workflows.getSystemWorkflow().getRoomsByRoomTypeId(RoomType.KITCHEN);
			if(!kitchens.isEmpty()) {
				outlet.setRoom(kitchens.get(0));
			} else {
				List<Room> foyers = workflows.getSystemWorkflow().getRoomsByRoomTypeId(RoomType.FOYER);
				if(!foyers.isEmpty()) {
					outlet.setRoom(foyers.get(0));
				} else {
					List<Room> bedrooms = workflows.getSystemWorkflow().getRoomsByRoomTypeId(RoomType.BEDROOM);
					if(!bedrooms.isEmpty()) {
						outlet.setRoom(bedrooms.get(0));
					} else {
						List<Room> bathrooms = workflows.getSystemWorkflow().getRoomsByRoomTypeId(RoomType.BATHROOM);
						if(!bathrooms.isEmpty()) {
							outlet.setRoom(bathrooms.get(0));
						}
					}
				}
			}			
		}
		
		if(backingObject.getSerialNumber() != null) {
			outlet.setSerialNumber(backingObject.getSerialNumber());			
		}
		
		return outlet;
	}
	
}
