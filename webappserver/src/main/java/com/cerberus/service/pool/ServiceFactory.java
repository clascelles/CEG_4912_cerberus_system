package com.cerberus.service.pool;

import com.cerberus.service.account.AccountService;
import com.cerberus.service.account.UserService;
import com.cerberus.service.outlets.OutletService;
import com.cerberus.service.outlets.RfidService;
import com.cerberus.service.schedules.SchedulingService;
import com.cerberus.service.system.SystemService;
import com.cerberus.service.usage.ConsumptionService;
import com.cerberus.service.usage.StatisticService;

public class ServiceFactory {
	
	private AccountService accountService;
	private ConsumptionService consumptionService;
	private OutletService outletService;
	private RfidService rfidService;
	private SchedulingService schedulingService;
	private StatisticService statisticService;
	private SystemService systemService;
	private UserService userService;
	
	public ServiceFactory(){
		accountService = new AccountService();
		consumptionService = new ConsumptionService();
		outletService = new OutletService();
		rfidService = new RfidService();
		schedulingService = new SchedulingService();
		statisticService = new StatisticService();
		systemService = new SystemService();
		userService = new UserService();
	}
	
	public ServiceFactory(AccountService accountService, ConsumptionService consumptionService, OutletService outletService, 
			RfidService rfidService, SchedulingService schedulingService, StatisticService statisticService, SystemService systemService,
			UserService userService){
		this.accountService = accountService;
		this.consumptionService = consumptionService;
		this.outletService = outletService;
		this.rfidService = rfidService;
		this.schedulingService = schedulingService;
		this.statisticService = statisticService;
		this.systemService = systemService;
		this.userService = userService;
	}

	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public ConsumptionService getConsumptionService() {
		return consumptionService;
	}

	public void setConsumptionService(ConsumptionService consumptionService) {
		this.consumptionService = consumptionService;
	}

	public OutletService getOutletService() {
		return outletService;
	}

	public void setOutletService(OutletService outletService) {
		this.outletService = outletService;
	}

	public RfidService getRfidService() {
		return rfidService;
	}

	public void setRfidService(RfidService rfidService) {
		this.rfidService = rfidService;
	}

	public SchedulingService getSchedulingService() {
		return schedulingService;
	}

	public void setSchedulingService(SchedulingService schedulingService) {
		this.schedulingService = schedulingService;
	}

	public StatisticService getStatisticService() {
		return statisticService;
	}

	public void setStatisticService(StatisticService statisticService) {
		this.statisticService = statisticService;
	}

	public SystemService getSystemService() {
		return systemService;
	}

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
