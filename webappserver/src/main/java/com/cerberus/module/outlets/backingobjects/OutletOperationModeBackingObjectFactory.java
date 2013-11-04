package com.cerberus.module.outlets.backingobjects;

import com.cerberus.model.account.bean.User;
import com.cerberus.model.outlets.bean.OutletOperationMode;
import com.cerberus.module.generic.backingobjects.BackingObjectFactory;

public class OutletOperationModeBackingObjectFactory extends BackingObjectFactory<OutletOperationMode, OutletOperationModeBackingObject> {
	
	public static OutletOperationModeBackingObjectFactory INSTANCE = new OutletOperationModeBackingObjectFactory();

	@Override
	public OutletOperationModeBackingObject getBackingObject(User user) {
		return new OutletOperationModeBackingObject();
	}
	
	@Override
	public OutletOperationModeBackingObject getBackingObject(OutletOperationMode mode) {
		OutletOperationModeBackingObject backingObject = new OutletOperationModeBackingObject();
		backingObject.setId(mode.getId());
		backingObject.setName(mode.getName());
		return backingObject;
	}

	@Override
	public OutletOperationMode bind(OutletOperationModeBackingObject backingObject, User user) {
		//unused
		
		return null;
	}

	@Override
	public boolean isValid(OutletOperationModeBackingObject backingObject) {
		// TODO Auto-generated method stub
		return false;
	}
}
