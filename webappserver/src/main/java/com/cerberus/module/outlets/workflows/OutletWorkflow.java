package com.cerberus.module.outlets.workflows;

import java.util.List;

import com.cerberus.model.account.bean.User;
import com.cerberus.module.generic.workflows.Workflow;
import com.cerberus.service.outlets.OutletService;
import com.cerberus.service.system.SystemService;
import com.cerberus.model.outlets.bean.Outlet;
import com.cerberus.model.outlets.bean.OutletOperationMode;
import com.cerberus.model.system.bean.CerberusSystem;

public class OutletWorkflow extends Workflow {
	
	public void insertOutlet(Outlet outlet) {		
		serviceFactory.getOutletService().insertOutlet(outlet);		
	}
	
	public List<Outlet> getOutletFromUser(User user){
		
		SystemService systemService = serviceFactory.getSystemService();		
		OutletService outletService = serviceFactory.getOutletService();		
		CerberusSystem system = systemService.getSystemByUserId(user.getId());
		
		List<Outlet> outlets = outletService.getOutletListBySystemId(system.getId());
		
		this.returnServiceFactory();
		
		return outlets;	
	}
	
	public OutletOperationMode getOutletOperationModeById(Integer id) {
		OutletService outletService = serviceFactory.getOutletService();
		OutletOperationMode outletOperationMode = outletService.getOutletOperationModeById(id);
		
		this.returnServiceFactory();
		
		return outletOperationMode;
	}

}
