package com.cerberus.frameworks.quartz;

import java.util.Date;

import org.apache.log4j.Logger;

import com.cerberus.daemon.constants.OperationModeUtil;
import com.cerberus.frameworks.netty.ChannelOutletBinding;
import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.outlets.bean.Socket;
import com.cerberus.model.outlets.bean.SocketOperationMode;
import com.cerberus.model.schedules.bean.ScheduleRecurrence;
import com.cerberus.model.schedules.bean.ScheduledEvent;

public class ScheduledEventTask {

	private Integer eventId;
	private Socket socket;
	private SocketOperationMode mode;
	private Date timestamp;
	private ScheduleRecurrence recurrence;
	private final static Logger LOGGER = Logger.getLogger(ScheduledEventTask.class);
	
	public ScheduledEventTask() {
		super();
	}
	
	public void init(ScheduledEvent event) {
		this.eventId = event.getId();
		this.socket = event.getSocket();
		this.mode = event.getMode();
		this.timestamp = event.getTime();
		this.recurrence = event.getRecurrence();
	}

	public void execute() {
		
		System.out.println("Running scheduled event task....");
		System.out.println("Event id: " + eventId);
		System.out.println("Socket id: " + socket.getId());
		System.out.println("Socket operation mode id: " + mode.getDescription());
		System.out.println("Timestamp: " + timestamp);
		System.out.println("Recurrence level: " + recurrence);
		
		if(ChannelOutletBinding.isChannelBinded(socket.getOutlet().getSerialNumber())) {
			sendMessage();
		}
		
	}
	
	public void sendMessage() {
		int position = socket.getPosition();
		CerberusApplicationContext.getWorkflows().getSwitchOperationModeWorkflow().
				sendMessage(socket.getOutlet().getSerialNumber(), 
						position, 
						"0000000000",
						OperationModeUtil.getSocketOperatingMode(socket.getOutlet().getMode(), socket.getMode()), 
						0);
	}
}
