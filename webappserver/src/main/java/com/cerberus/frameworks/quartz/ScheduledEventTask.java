package com.cerberus.frameworks.quartz;

import java.util.Date;

import org.apache.log4j.Logger;

import com.cerberus.daemon.constants.OperationMode;
import com.cerberus.frameworks.netty.ChannelOutletBinding;
import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.outlets.bean.Socket;
import com.cerberus.model.outlets.bean.SocketOperationMode;
import com.cerberus.model.schedules.bean.ScheduleRecurrence;
import com.cerberus.model.schedules.bean.ScheduledEvent;
import com.cerberus.module.system.constants.EventType;

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

		LOGGER.debug("Running scheduled event task:");
		LOGGER.debug("Event id: " + eventId + "Socket id: " + socket.getId() + "Socket operation mode id: "
					  + mode.getDescription() + "Timestamp: " + timestamp + "Recurrence level: " + recurrence);

		if(socket != null) {
			String outletSerialNumber = socket.getOutlet().getSerialNumber();
			if(ChannelOutletBinding.isChannelBinded(outletSerialNumber)) {
				sendMessage();

				//Log event
				CerberusApplicationContext.getWorkflows().getEventWorkflow().logEvent(EventType.SCHEDULED_EVENT_TRIGGERED, outletSerialNumber);
			}
		}

	}

	public void sendMessage() {
		Integer position = socket.getPosition();
		OperationMode opMode = new OperationMode(socket.getOutlet().getMode().getId(), socket.getMode().getId());
		CerberusApplicationContext.getWorkflows().getSwitchOperationModeWorkflow().
				sendMessage(socket.getOutlet().getSerialNumber(),
						position,
						"0000000000",
						opMode,
						0);
	}
}
