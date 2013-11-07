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
import com.cerberus.module.schedules.workflows.ScheduleWorkflow;

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
				backingObject.setSocketPosition(sockets.get(0).getPosition());
			}
		}		
		
		Date start = new Date();
		start.setTime(start.getTime() + 60*60*1000); // an hour from now
		backingObject.setTime(start);
		
		return backingObject;
	}
	
	@Override
	public ScheduledEventBackingObject getBackingObject(ScheduledEvent object) {
		ScheduledEventBackingObject backingObject = new ScheduledEventBackingObject();
		
		backingObject.setId(object.getId());
		backingObject.setMode(object.getMode());
		backingObject.setOutletId(object.getSocket().getOutlet().getId());
		backingObject.setSocket(object.getSocket());
		backingObject.setSocketPosition(object.getSocket().getPosition());
		backingObject.setUser(object.getUser());
		backingObject.setTime(object.getTime());
		
		return backingObject;
	}

	@Override
	public ScheduledEvent bind(ScheduledEventBackingObject backingObject,
			User user) {

		ScheduledEvent event = new ScheduledEvent();
		
		ScheduleWorkflow scheduleWorkflow = CerberusApplicationContext.getWorkflows().getScheduleWorkflow();
		
		if(backingObject.getId() != null) {
			ScheduledEvent fetch = scheduleWorkflow.getScheduledEventById(backingObject.getId());
			if(fetch != null) {
				event = fetch;
			}
		}		

		OutletWorkflow outletWorkflow = CerberusApplicationContext.getWorkflows().getOutletWorkflow();
		
		if(backingObject.getModeId() != null 
				|| (event.getMode() != null 
						&& backingObject.getModeId() != event.getMode().getId())) {
			event.setMode(outletWorkflow.getSocketModeById(backingObject.getModeId()));			
		}
		
		if(event.getSocket() == null
				||(event.getSocket() != null 
						&& backingObject.getOutletId() != event.getSocket().getOutlet().getId())
				|| (event.getSocket() != null 
						&& backingObject.getSocketPosition() != event.getSocket().getPosition())) {

			Outlet outlet = outletWorkflow.getOutletById(backingObject.getOutletId());
			List<Socket> sockets = outletWorkflow.getSocketsByOutlet(outlet);
			if(sockets.size() == 2) {
				Socket socket = sockets.get(backingObject.getSocketPosition());
				event.setSocket(socket);
			} else if(sockets.size() == 1) {
				if(sockets.get(0).getPosition().equals(backingObject.getSocketPosition())) {
					event.setSocket(sockets.get(0));
				}				
			}
		}
		
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
				&& backingObject.getSocketPosition() != null
				&& backingObject.getUserId() != null);
	}
}
