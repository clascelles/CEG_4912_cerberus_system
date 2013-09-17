package com.cerberus.module.outlets.backingobjects;

import java.util.ArrayList;
import java.util.List;

import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.account.bean.User;
import com.cerberus.model.outlets.bean.Outlet;
import com.cerberus.model.system.bean.CerberusSystem;
import com.cerberus.model.system.bean.Room;
import com.cerberus.module.generic.constants.CerberusConstants;
import com.cerberus.module.generic.workflows.Workflows;

public class OutletBackingObjectFactory {

	public static List<OutletBackingObject> getBackingObjects(List<Outlet> outlets) {
		List<OutletBackingObject> backingObjects = new ArrayList<OutletBackingObject>();
		
		if(outlets != null) {	
			for(Outlet outlet : outlets) {
				backingObjects.add(getBackingObject(outlet));
			}			
		}
		
		return backingObjects;
	}
	
	public static OutletBackingObject getBackingObject(User user) {
		OutletBackingObject backingObject = new OutletBackingObject();
		if(user != null) {
			CerberusSystem system = CerberusApplicationContext.getWorkflows().getSystemWorkflow().getSystemByUserId(user.getId());
			if(system != null) {
				backingObject.setSystemId(system.getId());
			}	
		}
		return backingObject;
	}
	
	public static OutletBackingObject getBackingObject(Outlet outlet) {
		OutletBackingObject backingObject = new OutletBackingObject();
		backingObject.setId(outlet.getId());
		backingObject.setModeId(outlet.getMode().getId());
		backingObject.setModeName(outlet.getMode().getName());
		backingObject.setRoomId(outlet.getRoom().getId());
		backingObject.setRoomName(outlet.getRoom().getName());
		backingObject.setSerialNumber(outlet.getSerialNumber());
		backingObject.setSystemId(outlet.getSystemId());
		return backingObject;
	}
	
	public static Outlet bind(OutletBackingObject backingObject, User user) {
		Workflows workflows = CerberusApplicationContext.getWorkflows();
		Outlet outlet = new Outlet();
		outlet.setId(backingObject.getId());
		
		if(backingObject.getModeId() != null) {
			outlet.setMode(workflows.getOutletWorkflow().getOutletOperationModeById(backingObject.getModeId()));			
		} else {
			outlet.setMode(workflows.getOutletWorkflow().getOutletOperationModeById(CerberusConstants.OUTLET_OPERATION_MODE_DISABLED));
		}
		
		if(backingObject.getRoomId() != null) {
			outlet.setRoom(workflows.getSystemWorkflow().getRoomById(backingObject.getRoomId()));			
		} else {
			List<Room> kitchens = workflows.getSystemWorkflow().getRoomsByRoomTypeId(CerberusConstants.ROOM_TYPE_KITCHEN);
			if(!kitchens.isEmpty()) {
				outlet.setRoom(kitchens.get(0));
			} else {
				List<Room> foyers = workflows.getSystemWorkflow().getRoomsByRoomTypeId(CerberusConstants.ROOM_TYPE_FOYER);
				if(!foyers.isEmpty()) {
					outlet.setRoom(foyers.get(0));
				} else {
					List<Room> bedrooms = workflows.getSystemWorkflow().getRoomsByRoomTypeId(CerberusConstants.ROOM_TYPE_BEDROOM);
					if(!bedrooms.isEmpty()) {
						outlet.setRoom(bedrooms.get(0));
					} else {
						List<Room> bathrooms = workflows.getSystemWorkflow().getRoomsByRoomTypeId(CerberusConstants.ROOM_TYPE_BATHROOM);
						if(!bathrooms.isEmpty()) {
							outlet.setRoom(bathrooms.get(0));
						}
					}
				}
			}			
		}
		
		outlet.setSerialNumber(backingObject.getSerialNumber());
		
		if(backingObject.getSystemId() != null) {
			outlet.setSystem(workflows.getSystemWorkflow().getSystemById(backingObject.getSystemId()));
			outlet.setSystemId(backingObject.getSystemId());			
		} else {
			outlet.setSystem(workflows.getSystemWorkflow().getSystemByUserId(user.getId()));
		}
		
		return outlet;
	}
	
}
