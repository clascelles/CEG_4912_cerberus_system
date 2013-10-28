package com.cerberus.module.schedules.backingobjects;

import java.util.Date;
import java.util.List;

import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.account.bean.User;
import com.cerberus.model.outlets.bean.Outlet;
import com.cerberus.model.outlets.bean.Socket;
import com.cerberus.model.outlets.bean.SocketOperationMode;
import com.cerberus.model.schedules.bean.ScheduledEvent;
import com.cerberus.module.generic.backingobjects.BackingObjectFactory;
import com.cerberus.module.outlets.workflows.OutletWorkflow;

public class ScheduledEventBackingObjectFactory 
	extends BackingObjectFactory<ScheduledEvent, ScheduledEventBackingObject> {
	
	public static ScheduledEventBackingObjectFactory INSTANCE = new ScheduledEventBackingObjectFactory();

	@Override
	public ScheduledEventBackingObject getBackingObject(User user) {
		ScheduledEventBackingObject backingObject = new ScheduledEventBackingObject();
		
		backingObject.setStartModeId(SocketOperationMode.DISABLED);
		backingObject.setEndModeId(SocketOperationMode.MONITORING);
		backingObject.setUser(user);
		
		OutletWorkflow outletWorkflow = CerberusApplicationContext.getWorkflows().getOutletWorkflow();
		List<Outlet> outlets = outletWorkflow.getOutletFromUser(user);
		if(!outlets.isEmpty()) {
			List<Socket> sockets = outletWorkflow.getSocketsByOutlet(outlets.get(0));
			if(!sockets.isEmpty()) {
				backingObject.setSocketId(sockets.get(0).getId());				
			}
		}		
		
		Date start = new Date();
		Date end = new Date(start.getTime() + 60*60*1000);
		backingObject.setEventDuration(start, end);
		
		return backingObject;
	}
	
	@Override
	public ScheduledEventBackingObject getBackingObject(ScheduledEvent object) {
		ScheduledEventBackingObject backingObject = new ScheduledEventBackingObject();
		
		backingObject.setStartMode(object.getStartMode());
		backingObject.setEndMode(object.getEndMode());
		backingObject.setSocket(object.getSocket());
		backingObject.setUser(object.getUser());
		backingObject.setEventDuration(object.getStartTime(), object.getEndTime());
		
		return backingObject;
	}

	@Override
	public ScheduledEvent bind(ScheduledEventBackingObject backingObject,
			User user) {
		OutletWorkflow outletWorkflow = CerberusApplicationContext.getWorkflows().getOutletWorkflow();

		ScheduledEvent event = new ScheduledEvent();
		
		event.setStartMode(outletWorkflow.getSocketModeById(backingObject.getStartModeId()));
		event.setEndMode(outletWorkflow.getSocketModeById(backingObject.getEndModeId()));
		event.setSocket(outletWorkflow.getSocketById(backingObject.getSocketId()));
		event.setUser(user);		
		event.setStartTime(backingObject.getStartTime());
		event.setEndTime(backingObject.getEndTime());

		return event;
	}
}
