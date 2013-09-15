package com.cerberus.module.outlets.workflows;

import java.util.ArrayList;
import java.util.List;

import com.cerberus.model.account.bean.User;
import com.cerberus.module.generic.workflows.Workflow;
import com.cerberus.module.outlets.backingobjects.OutletBackingObject;
import com.cerberus.service.outlets.OutletService;
import com.cerberus.model.outlets.bean.Outlet;
import com.cerberus.model.system.bean.CerberusSystem;

public class OutletWorkflow extends Workflow {
	
	protected OutletService outletService = serviceFactory.getOutletService();
	
	public List<OutletBackingObject> getOutletFromUser(User user){
		
		CerberusSystem system = systemService.getSystemByUserId(user.getId());
		
		List<Outlet> outlets = outletService.getOutletListBySystemId(system.getId());
		
		List<OutletBackingObject> outletBackingObjects = new ArrayList<OutletBackingObject>();
		
		if(outlets != null){
			for(Outlet outlet : outlets){
				OutletBackingObject outletBO = new OutletBackingObject();
				outletBO.setId(outlet.getId());		
				outletBO.setRoom(outlet.getRoom());
				outletBO.setMode(outlet.getMode());
				outletBO.setSerialNumber(outlet.getSerialNumber());
				outletBackingObjects.add(outletBO);
			}
		}
		
		return outletBackingObjects;
	
	}

}
