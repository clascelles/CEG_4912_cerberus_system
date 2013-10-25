package com.cerberus.module.system.backingobjects;

import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.account.bean.User;
import com.cerberus.model.outlets.bean.OutletOperationMode;
import com.cerberus.model.system.bean.CerberusSystem;
import com.cerberus.module.generic.backingobjects.BackingObjectFactory;
import com.cerberus.module.generic.workflows.Workflows;

public class SystemBackingObjectFactory extends BackingObjectFactory<CerberusSystem, SystemBackingObject> {
	
	public static SystemBackingObjectFactory INSTANCE = new SystemBackingObjectFactory();
		
	public SystemBackingObject getBackingObject(User user) {
		return getBackingObject(user.getLogin().getSystem());
	}

	@Override
	public SystemBackingObject getBackingObject(CerberusSystem system) {
		SystemBackingObject backingObject = new SystemBackingObject();
		backingObject.setId(system.getId());
		backingObject.setName(system.getName());
		backingObject.setDefaultOutletOperationMode(system.getDefaultOperationMode());
		backingObject.setSystemActive(system.isSystemActive());
		backingObject.setSpikeProtection(system.isSpikeProtection());
		backingObject.setEncryptionKey(system.getEncryptionKey());
		return backingObject;
	}

	@Override
	public CerberusSystem bind(SystemBackingObject backingObject, User user) {
		Workflows workflows = CerberusApplicationContext.getWorkflows();
		
		CerberusSystem system = user.getLogin().getSystem();
		
		//can't modify the system id
		//can't modify the name at the moment
		
		//bind the active attribute
		system.setSystemActive(backingObject.isSystemActive());
		
		//bind the default operation mode
		if (backingObject.getDefaultOutletOperationModeId() != null) {
			OutletOperationMode mode = workflows.getOutletWorkflow().getOutletOperationModeById(backingObject.getDefaultOutletOperationModeId());
			system.setDefaultOperationMode(mode);
		}
		
		//bind the spike protection attribute
		system.setSpikeProtection(backingObject.isSpikeProtection());
		
		//bind the encryption key
		if(backingObject.getEncryptionKey() != null && !backingObject.getEncryptionKey().isEmpty()) {
			system.setEncryptionKey(backingObject.getEncryptionKey());
		}
		
		return system;
	}
	
}
