package com.cerberus.module.generic.workflows;

import com.cerberus.daemon.workflow.InitializationWorkflow;
import com.cerberus.daemon.workflow.SwitchOperationModeWorkflow;
import com.cerberus.module.account.workflows.AccountWorkflow;
import com.cerberus.module.outlets.workflows.OutletWorkflow;
import com.cerberus.module.overview.workflows.OverviewWorkflow;
import com.cerberus.module.schedules.workflows.ScheduleWorkflow;
import com.cerberus.module.security.workflows.SecurityWorkflow;
import com.cerberus.module.system.workflows.EventWorkflow;
import com.cerberus.module.system.workflows.SystemWorkflow;
import com.cerberus.module.usage.workflows.UsageWorkflow;

public class Workflows {

	private AccountWorkflow accountWorkflow;
	private EventWorkflow eventWorkflow;
	private OutletWorkflow outletWorkflow;
	private OverviewWorkflow overviewWorkflow;
	private ScheduleWorkflow scheduleWorkflow;
	private SecurityWorkflow securityWorkflow;
	private SystemWorkflow systemWorkflow;
	private UsageWorkflow usageWorkflow;

	private SwitchOperationModeWorkflow switchOperationModeWorkflow;
	private InitializationWorkflow initializationWorkflow;

	public AccountWorkflow getAccountWorkflow() {
		return accountWorkflow;
	}
	public void setAccountWorkflow(AccountWorkflow accountWorkflow) {
		this.accountWorkflow = accountWorkflow;
	}

	public EventWorkflow getEventWorkflow() {
		return eventWorkflow;
	}
	public void setEventWorkflow(EventWorkflow eventWorkflow) {
		this.eventWorkflow = eventWorkflow;
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

	public SecurityWorkflow getSecurityWorkflow() {
		return securityWorkflow;
	}
	public void setSecurityWorkflow(SecurityWorkflow securityWorkflow) {
		this.securityWorkflow = securityWorkflow;
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

	public SwitchOperationModeWorkflow getSwitchOperationModeWorkflow() {
		return switchOperationModeWorkflow;
	}
	public void setSwitchOperationModeWorkflow(
			SwitchOperationModeWorkflow switchOperationModeWorkflow) {
		this.switchOperationModeWorkflow = switchOperationModeWorkflow;
	}
	
	public InitializationWorkflow getInitializationWorkflow() {
		return initializationWorkflow;
	}
	public void setInitializationWorkflow(
			InitializationWorkflow initializationWorkflow) {
		this.initializationWorkflow = initializationWorkflow;
	}
	
	




}
