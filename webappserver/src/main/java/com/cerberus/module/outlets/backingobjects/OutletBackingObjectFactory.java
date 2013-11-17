package com.cerberus.module.outlets.backingobjects;

import java.util.List;

import com.cerberus.frameworks.netty.ChannelOutletBinding;
import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.account.bean.User;
import com.cerberus.model.outlets.bean.Outlet;
import com.cerberus.model.outlets.bean.OutletOperationMode;
import com.cerberus.model.system.bean.Room;
import com.cerberus.model.system.bean.RoomType;
import com.cerberus.module.generic.backingobjects.BackingObjectFactory;
import com.cerberus.module.generic.workflows.Workflows;
import com.cerberus.module.outlets.workflows.OutletWorkflow;
import com.cerberus.module.system.workflows.SystemWorkflow;

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
		backingObject.setStatus(ChannelOutletBinding.isChannelBinded(outlet.getSerialNumber()));
		
		return backingObject;
	}

	@Override
	public Outlet bind(OutletBackingObject backingObject, User user) {
		Workflows workflows = CerberusApplicationContext.getWorkflows();
		OutletWorkflow outletWorkflow = workflows.getOutletWorkflow();
		SystemWorkflow systemWorkflow = workflows.getSystemWorkflow();

		Outlet outlet = new Outlet();

		if(backingObject.getId() != null) {
			outlet = outletWorkflow.getOutletById(backingObject.getId());
		}

		if(backingObject.getModeId() != null) {
			outlet.setMode(outletWorkflow.getOutletOperationModeById(backingObject.getModeId()));
		} else {
			outlet.setMode(outletWorkflow.getOutletOperationModeById(OutletOperationMode.MONITORING));
		}

		if(backingObject.getRoomId() != null) {
			outlet.setRoom(systemWorkflow.getRoomById(backingObject.getRoomId()));
		} else {
			List<Room> kitchens = systemWorkflow.getRoomsByRoomTypeId(RoomType.KITCHEN);
			if(!kitchens.isEmpty()) {
				outlet.setRoom(kitchens.get(0));
			} else {
				List<Room> foyers = systemWorkflow.getRoomsByRoomTypeId(RoomType.FOYER);
				if(!foyers.isEmpty()) {
					outlet.setRoom(foyers.get(0));
				} else {
					List<Room> bedrooms = systemWorkflow.getRoomsByRoomTypeId(RoomType.BEDROOM);
					if(!bedrooms.isEmpty()) {
						outlet.setRoom(bedrooms.get(0));
					} else {
						List<Room> bathrooms = systemWorkflow.getRoomsByRoomTypeId(RoomType.BATHROOM);
						if(!bathrooms.isEmpty()) {
							outlet.setRoom(bathrooms.get(0));
						}
					}
				}
			}
		}

		if(backingObject.getSerialNumber() != null) {
			outlet.setSerialNumber(backingObject.getSerialNumber());
		} else {
			// Cannot create outlet without a serial number!
			return null;
		}

		return outlet;
	}

	@Override
	public boolean isValid(OutletBackingObject backingObject) {
		// TODO Auto-generated method stub
		return false;
	}

}
