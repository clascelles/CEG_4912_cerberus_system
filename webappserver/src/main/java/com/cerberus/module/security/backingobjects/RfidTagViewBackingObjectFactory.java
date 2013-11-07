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
	public RfidTagViewBackingObject getBackingObject(User user) {
		return new RfidTagViewBackingObject();
	}

	@Override
	public RfidTagViewBackingObject getBackingObject(RfidTagView tag) {
		RfidTagViewBackingObject backingObject = new RfidTagViewBackingObject();
		backingObject.setId(tag.getId());
		backingObject.setNumber(tag.getNumber());
		backingObject.setName(tag.getName());
		backingObject.setProfile(tag.getProfileName());
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

		if(backingObject.getName() != null) {
			tag.setName(backingObject.getName());
		}

		if(backingObject.getProfile() != null) {
			tag.setProfileName(backingObject.getProfile());
		}

		if(backingObject.getPermission() != null) {
			tag.setPermission(backingObject.getPermission().getIntValue());
		}

		return tag;
	}

	@Override
	public boolean isValid(RfidTagViewBackingObject backingObject) {
		// TODO Auto-generated method stub
		return false;
	}

}
