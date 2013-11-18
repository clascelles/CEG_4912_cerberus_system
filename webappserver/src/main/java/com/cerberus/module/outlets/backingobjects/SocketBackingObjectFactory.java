package com.cerberus.module.outlets.backingobjects;

import java.util.Date;

import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.account.bean.User;
import com.cerberus.model.outlets.bean.Current;
import com.cerberus.model.outlets.bean.Socket;
import com.cerberus.model.security.bean.RfidTag;
import com.cerberus.model.usage.bean.ConsumptionProfile;
import com.cerberus.module.generic.backingobjects.BackingObjectFactory;
import com.cerberus.module.outlets.workflows.OutletWorkflow;
import com.cerberus.module.usage.workflows.UsageWorkflow;

public class SocketBackingObjectFactory extends BackingObjectFactory<Socket, SocketBackingObject> {

	public static SocketBackingObjectFactory INSTANCE = new SocketBackingObjectFactory();

	public static final String UNASSIGNED = "-unassigned-";

	@Override
	public SocketBackingObject getBackingObject(User user) {
		return new SocketBackingObject();
	}

	@Override
	public SocketBackingObject getBackingObject(Socket socket) {
		String unavailable = "Unavailable";
		SocketBackingObject backingObject = new SocketBackingObject();
		backingObject.setId(socket.getId());
		backingObject.setOperationModeId(socket.getMode().getId());
		backingObject.setOperationModeName(socket.getMode().getDescription());
		backingObject.setOutletId(socket.getOutlet().getId());
		backingObject.setPosition(socket.getPosition());
		
		UsageWorkflow usageWorkflow = CerberusApplicationContext.getWorkflows().getUsageWorkflow();
		backingObject.setPowerUsage(usageWorkflow.getCurrentUsageForSocket(socket));
		
		backingObject.setCurrentLog(usageWorkflow.getSocketCurrentByHourForDay(socket, new Date()));
		
		Current current = usageWorkflow.getCurrentForSocket(socket);
		if(current != null) {
			RfidTag tag = current.getRfidTagId();
			if(tag != null) {
				ConsumptionProfile profile = tag.getProfile();
				if(profile != null && profile.getName() != null) {
					backingObject.setConnectedUtilityName(profile.getName());				
				}
			}			
		}
		
		if(backingObject.getConnectedUtilityName() == null) {
			backingObject.setConnectedUtilityName(unavailable);
		}

		return backingObject;
	}

	@Override
	public Socket bind(SocketBackingObject backingObject, User user) {
		OutletWorkflow outletWorkflow = CerberusApplicationContext.getWorkflows().getOutletWorkflow();
		Socket socket = outletWorkflow.getSocketById(backingObject.getId());

		// update operation mode
		if(!socket.getMode().getId().equals(backingObject.getOperationModeId())) {
			socket.setMode(outletWorkflow.getSocketModeById(backingObject.getOperationModeId()));
		}

		// the other attributes (id, position, outlet, serial number) shouldn't be updated

		return socket;
	}

	@Override
	public boolean isValid(SocketBackingObject backingObject) {
		// TODO Auto-generated method stub
		return false;
	}

}
