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
		
		backingObject.setModeId(SocketOperationMode.MANUAL_OFF_ID);
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
		/*Date end = new Date(start.getTime() + 60*60*1000);*/
		backingObject.setTime(start);
		
		return backingObject;
	}
	
	@Override
	public ScheduledEventBackingObject getBackingObject(ScheduledEvent object) {
		ScheduledEventBackingObject backingObject = new ScheduledEventBackingObject();
		
		backingObject.setId(object.getId());
		backingObject.setMode(object.getMode());
		backingObject.setSocket(object.getSocket());
		backingObject.setUser(object.getUser());
		backingObject.setTime(object.getTime());
		
		return backingObject;
	}

	@Override
	public ScheduledEvent bind(ScheduledEventBackingObject backingObject,
			User user) {

		ScheduledEvent event = new ScheduledEvent();
		
		OutletWorkflow outletWorkflow = CerberusApplicationContext.getWorkflows().getOutletWorkflow();
		
		
		event.setMode(outletWorkflow.getSocketModeById(backingObject.getModeId()));
		Outlet outlet = outletWorkflow.getOutletById(backingObject.getOutletId());
		List<Socket> sockets = outletWorkflow.getSocketsByOutlet(outlet);
		event.setSocket(sockets.get(backingObject.getSocketId()));
		event.setUser(user);		
		event.setTime(ScheduledEventBackingObject.parseDate(backingObject.getTime()));

		return event;
	}

	@Override
	public boolean isValid(ScheduledEventBackingObject backingObject) {
		boolean dateValid = true;
		try {
			ScheduledEventBackingObject.parseDate(backingObject.getTime());
		} catch (NumberFormatException e) {
			dateValid = false;
		}
		
		return (dateValid 
				&& backingObject.getOutletId() != null
				&& backingObject.getSocketId() != null
				&& backingObject.getUserId() != null);
	}
}
