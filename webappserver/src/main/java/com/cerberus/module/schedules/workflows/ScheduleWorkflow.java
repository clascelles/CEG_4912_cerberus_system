package com.cerberus.module.schedules.workflows;

import java.util.ArrayList;
import java.util.List;

import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.account.bean.User;
import com.cerberus.model.outlets.bean.Outlet;
import com.cerberus.model.outlets.bean.Socket;
import com.cerberus.model.schedules.bean.ScheduledEvent;
import com.cerberus.module.generic.workflows.Workflow;
import com.cerberus.module.outlets.workflows.OutletWorkflow;
import com.cerberus.service.schedules.SchedulingService;

public class ScheduleWorkflow extends Workflow {

	public void insertScheduledEvent(ScheduledEvent event) {
		serviceFactory.getSchedulingService().insertScheduledEvent(event);
		this.returnServiceFactory();
	}

	public void updatedScheduledEvent(ScheduledEvent event) {
		serviceFactory.getSchedulingService().updateScheduledEvent(event);
		this.returnServiceFactory();
	}
	
	public List<ScheduledEvent> getScheduledEventsForUser(User user){

		SchedulingService scheduleService = serviceFactory.getSchedulingService();
		OutletWorkflow outletWorkflow = CerberusApplicationContext.getWorkflows().getOutletWorkflow();
		
		List<ScheduledEvent> events = new ArrayList<ScheduledEvent>();
		List<Outlet> outlets = outletWorkflow.getOutletFromUser(user);		
		List<Socket> sockets = new ArrayList<Socket>(); 
		
		for(Outlet outlet : outlets) {
			sockets.addAll(outletWorkflow.getSocketsByOutlet(outlet));
		}
		
		for(Socket socket : sockets) {
			events.addAll(scheduleService.getScheduledEventBySocketId(socket.getId()));
		}

		this.returnServiceFactory();

		return events;
	}
	
}
