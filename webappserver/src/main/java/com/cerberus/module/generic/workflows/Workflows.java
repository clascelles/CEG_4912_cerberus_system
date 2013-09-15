package com.cerberus.module.generic.workflows;

import com.cerberus.module.account.workflows.AccountWorkflow;
import com.cerberus.module.outlets.workflows.OutletWorkflow;
import com.cerberus.module.overview.workflows.OverviewWorkflow;
import com.cerberus.module.schedules.workflows.ScheduleWorkflow;
import com.cerberus.module.system.workflows.SystemWorkflow;
import com.cerberus.module.usage.workflows.UsageWorkflow;

public class Workflows {

	private AccountWorkflow accountWorkflow;
	private OutletWorkflow outletWorkflow;
	private OverviewWorkflow overviewWorkflow;
	private ScheduleWorkflow scheduleWorkflow;
	private SystemWorkflow systemWorkflow;
	private UsageWorkflow usageWorkflow;
	
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
	
	public OverviewWorkflow getOverviewWorkflow() {
		return overviewWorkflow;
	}
	public void setOverviewWorkflow(OverviewWorkflow overviewWorkflow) {
		this.overviewWorkflow = overviewWorkflow;
	}
	
	public ScheduleWorkflow getScheduleWorkflow() {
		return scheduleWorkflow;
	}
	public void setScheduleWorkflow(ScheduleWorkflow scheduleWorkflow) {
		this.scheduleWorkflow = scheduleWorkflow;
	}
	
	public SystemWorkflow getSystemWorkflow() {
		return systemWorkflow;
	}
	public void setSystemWorkflow(SystemWorkflow systemWorkflow) {
		this.systemWorkflow = systemWorkflow;
	}
	
	public UsageWorkflow getUsageWorkflow() {
		return usageWorkflow;
	}
	public void setUsageWorkflow(UsageWorkflow usageWorkflow) {
		this.usageWorkflow = usageWorkflow;
	}
	

	
		
}
