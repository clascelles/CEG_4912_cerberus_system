package com.cerberus.module.usage.workflows;

import java.util.ArrayList;
import java.util.List;

import com.cerberus.model.account.bean.User;
import com.cerberus.module.generic.workflows.Workflow;
import com.cerberus.module.outlets.backingobjects.OutletBackingObject;
import com.cerberus.service.outlets.OutletService;
import com.cerberus.service.system.SystemService;
import com.cerberus.service.usage.ConsumptionService;
import com.cerberus.model.outlets.bean.Outlet;
import com.cerberus.model.outlets.bean.Socket;
import com.cerberus.model.system.bean.CerberusSystem;
import com.cerberus.model.outlets.bean.Current;

public class UsageWorkflow extends Workflow {
	
	public List<Integer> getCurrentConsumptionForUser(User user){
		
		//Get the System that the user belongs
		SystemService systemService = serviceFactory.getSystemService();
		CerberusSystem system = systemService.getSystemByUserId(user.getId());
		
		//ConsumptionService consumptionService = serviceFactory.getConsumptionService();
		//List<Current> systemCurrentList = consumptionService.getCurrentListBySystemId(system.getId());
		
		
		
		return null;
	
	}

}
