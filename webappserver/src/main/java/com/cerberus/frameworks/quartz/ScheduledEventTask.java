package com.cerberus.frameworks.quartz;

import java.util.Date;

import org.apache.log4j.Logger;

import com.cerberus.model.outlets.bean.SocketOperationMode;
import com.cerberus.model.schedules.bean.ScheduleRecurrence;
import com.cerberus.model.schedules.bean.ScheduledEvent;

public class ScheduledEventTask {

	private Integer eventId;
	private Integer socketId;
	private SocketOperationMode mode;
	private Date timestamp;
	private ScheduleRecurrence recurrence;
	private final static Logger LOGGER = Logger.getLogger(ScheduledEventTask.class);
	
	public ScheduledEventTask() {
		super();
	}
	
	public void init(ScheduledEvent event) {
		this.eventId = event.getId();
		this.socketId = event.getSocket().getId();
		this.mode = event.getMode();
		this.timestamp = event.getTime();
		this.recurrence = event.getRecurrence();
	}

	public void execute() {
		
		System.out.println("Running scheduled event task....");
		System.out.println("Event id: " + eventId);
		System.out.println("Socket id: " + socketId);
		System.out.println("Socket operation mode id: " + mode.getDescription());
		System.out.println("Timestamp: " + timestamp);
		System.out.println("Recurrence level: " + recurrence);
		
		sendMessage();
		
	}
	
	public static void sendMessage() {
		//TODO
	}
}
