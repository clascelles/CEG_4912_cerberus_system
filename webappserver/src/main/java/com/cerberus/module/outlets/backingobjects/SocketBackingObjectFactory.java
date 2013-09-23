package com.cerberus.module.outlets.backingobjects;

import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.account.bean.User;
import com.cerberus.model.outlets.bean.Socket;
import com.cerberus.model.outlets.bean.SocketAssignment;
import com.cerberus.module.generic.backingobjects.BackingObjectFactory;
import com.cerberus.module.outlets.workflows.OutletWorkflow;

public class SocketBackingObjectFactory extends BackingObjectFactory<Socket, SocketBackingObject> {
	
	public static SocketBackingObjectFactory INSTANCE = new SocketBackingObjectFactory();
	
	public static final String UNASSIGNED = "-unassigned-";
	
	@Override
	public SocketBackingObject getBackingObject(Socket socket) {
		SocketBackingObject backingObject = new SocketBackingObject();
		backingObject.setId(socket.getId());
		backingObject.setOperationModeId(socket.getMode().getId());
		backingObject.setOperationModeName(socket.getMode().getDescription());
		backingObject.setOutletId(socket.getOutlet().getId());
		backingObject.setPosition(socket.getPosition());
		backingObject.setSerialNumber(socket.getSerialNumber());
		backingObject.setStatusId(socket.getStatus().getId());
		backingObject.setStatusName(socket.getStatus().getStatus());
		
		OutletWorkflow outletWorkflow = CerberusApplicationContext.getWorkflows().getOutletWorkflow();
		
		SocketAssignment assignment = outletWorkflow.getSocketAssignmentBySocketId(socket.getId());
		backingObject.setConnectedUsername((assignment != null) ? assignment.getUser().getFullName() : UNASSIGNED);
		
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
		
		// update operation status
		if(!socket.getStatus().getId().equals(backingObject.getStatusId())) {
			socket.setStatus(outletWorkflow.getSocketStatusById(backingObject.getStatusId()));
		}	
		
		// the other attributes (id, position, outlet, serial number) shouldn't be updated
		
		return socket;
	}
	
}
