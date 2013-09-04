package com.cerberus.module.generic.workflows;

import com.cerberus.module.account.workflows.AccountWorkflow;
import com.cerberus.module.outlets.workflows.OutletWorkflow;

public class Workflows {

	private AccountWorkflow accountWorkflow;
	private OutletWorkflow outletWorkflow;

	public AccountWorkflow getAccountWorkflow() {
		return accountWorkflow;
	}

	public void setAccountWorkflow(AccountWorkflow accountWorkflow) {
		this.accountWorkflow = accountWorkflow;
	}

	public OutletWorkflow getOutletWorkflow() {
		return outletWorkflow;
	}

	public void setOutletWorkflow(OutletWorkflow outletWorkflow) {
		this.outletWorkflow = outletWorkflow;
	}
	
	

	
	
}
