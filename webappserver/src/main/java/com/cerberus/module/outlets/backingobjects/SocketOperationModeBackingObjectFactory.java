package com.cerberus.module.outlets.backingobjects;

import com.cerberus.model.account.bean.User;
import com.cerberus.model.outlets.bean.SocketOperationMode;
import com.cerberus.module.generic.backingobjects.BackingObjectFactory;

public class SocketOperationModeBackingObjectFactory 
	extends BackingObjectFactory<SocketOperationMode, SocketOperationModeBackingObject>{

	public static SocketOperationModeBackingObjectFactory INSTANCE = new SocketOperationModeBackingObjectFactory();
	
	@Override
	public SocketOperationModeBackingObject getBackingObject(User user) {		
		return new SocketOperationModeBackingObject();
	}

	@Override
	public SocketOperationModeBackingObject getBackingObject(
			SocketOperationMode object) {
		SocketOperationModeBackingObject backingObject = new SocketOperationModeBackingObject();
		
		backingObject.setId(object.getId());
		backingObject.setName(object.getDescription());
		
		return backingObject;
	}

	@Override
	public SocketOperationMode bind(
			SocketOperationModeBackingObject backingObject, User user) {
		//unused
		return null;
	}

	//shouldn't need to validate these - they don't get updated
	@Override
	public boolean isValid(SocketOperationModeBackingObject backingObject) {
		return false;
	}

}
