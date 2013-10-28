package com.cerberus.service.schedules;

import java.util.List;

import com.cerberus.model.schedules.bean.ScheduledEvent;
import com.cerberus.model.schedules.dao.ScheduledEventDAO;
import com.cerberus.model.schedules.filter.ScheduledEventFilter;

public class SchedulingService {
	private ScheduledEventDAO scheduledEventDAO;
	
	public SchedulingService(){
		scheduledEventDAO = new ScheduledEventDAO();
	}
	
	//***************************************************
	//ScheduledEvent
	//***************************************************
	
	public Integer insertScheduledEvent(ScheduledEvent scheduledEvent){
		return scheduledEventDAO.save(scheduledEvent);
	}
	
	public ScheduledEvent updateScheduledEvent(ScheduledEvent scheduledEvent){
		return scheduledEventDAO.merge(scheduledEvent);
	}
	
	public void deleteSocketOperationMode(ScheduledEvent scheduledEvent){
		scheduledEventDAO.delete(scheduledEvent);
	}

	public List<ScheduledEvent> getScheduledEventBySocketId(Integer socketId) {
		return scheduledEventDAO.getAllByFilter(ScheduledEventFilter.getBySocketId(socketId));		
	}
}
