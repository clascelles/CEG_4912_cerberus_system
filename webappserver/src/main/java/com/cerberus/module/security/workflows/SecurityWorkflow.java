package com.cerberus.module.security.workflows;

import java.util.List;

import com.cerberus.model.security.bean.RfidTag;
import com.cerberus.model.security.bean.RfidTagView;
import com.cerberus.model.system.bean.CerberusSystem;
import com.cerberus.module.generic.workflows.Workflow;
import com.cerberus.service.security.RfidService;
import com.cerberus.service.system.SystemService;

public class SecurityWorkflow extends Workflow {

	public List<RfidTagView> getRfidTagsFromSystem(CerberusSystem system) {
		SystemService systemService = serviceFactory.getSystemService();
		RfidService rfidService = serviceFactory.getRfidService();

		Integer sysOwnerId = systemService.getSysOwnerOfSystem(system.getId());
		List<RfidTagView> rfidTagViews = rfidService.getRfidTagViewsByUser(sysOwnerId);

		this.returnServiceFactory();

		return rfidTagViews;
	}


	public void insertRfidTag(RfidTag rfidTag) {
		serviceFactory.getRfidService().insertRfidTag(rfidTag);
		this.returnServiceFactory();
	}

	public void updateRfidTag(RfidTag rfidTag) {
		serviceFactory.getRfidService().updateRfigTag(rfidTag);
		this.returnServiceFactory();
	}

	public RfidTagView getRfidTagViewById(Integer id) {
		RfidTagView view = serviceFactory.getRfidService().getRfidTagViewById(id);
		this.returnServiceFactory();

		return view;
	}


	public void updateRfidTagView(RfidTagView rfidTag) {
		RfidService rfidService = serviceFactory.getRfidService();
		rfidService.updateRfidTagView(rfidTag);
	}


}
