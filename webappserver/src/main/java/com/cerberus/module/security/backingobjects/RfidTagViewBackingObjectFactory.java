package com.cerberus.module.security.backingobjects;

import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.account.bean.User;
import com.cerberus.model.security.bean.RfidTagView;
import com.cerberus.module.generic.backingobjects.BackingObjectFactory;
import com.cerberus.module.security.constants.RfidPermission;
import com.cerberus.module.security.workflows.SecurityWorkflow;

public class RfidTagViewBackingObjectFactory extends BackingObjectFactory<RfidTagView, RfidTagViewBackingObject> {

	public static RfidTagViewBackingObjectFactory INSTANCE = new RfidTagViewBackingObjectFactory();

	@Override
	public RfidTagViewBackingObject getBackingObject(RfidTagView tag) {
		RfidTagViewBackingObject backingObject = new RfidTagViewBackingObject();
		backingObject.setId(tag.getId());
		backingObject.setNumber(tag.getNumber());
		backingObject.setDescription(tag.getDescription());
		backingObject.setPermission(RfidPermission.fromIntValue(tag.getPermission()));

		return backingObject;
	}

	@Override
	public RfidTagView bind(RfidTagViewBackingObject backingObject, User user) {
		SecurityWorkflow securityWorkflow = CerberusApplicationContext.getWorkflows().getSecurityWorkflow();

		if(backingObject == null) {
			return null;
		}

		RfidTagView tag = new RfidTagView();

		if(backingObject.getId() != null) {
			tag = securityWorkflow.getRfidTagViewById(backingObject.getId());
		}

		if(backingObject.getNumber() != null) {
			tag.setNumber(backingObject.getNumber());
		}

		if(backingObject.getDescription() != null) {
			tag.setDescription(backingObject.getDescription());
		}

		if(backingObject.getPermission() != null) {
			tag.setPermission(backingObject.getPermission().getIntValue());
		}

		return tag;
	}

	@Override
	public RfidTagViewBackingObject getBackingObject(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
