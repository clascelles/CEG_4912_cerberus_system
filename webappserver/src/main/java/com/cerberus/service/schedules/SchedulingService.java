package com.cerberus.service.schedules;

import java.util.List;

import com.cerberus.model.schedules.bean.Schedule;
import com.cerberus.model.schedules.bean.ScheduleRecurrence;
import com.cerberus.model.schedules.bean.ScheduledEvent;
import com.cerberus.model.schedules.dao.ScheduleDAO;
import com.cerberus.model.schedules.dao.ScheduleRecurrenceDAO;
import com.cerberus.model.schedules.dao.ScheduledEventDAO;
import com.cerberus.model.schedules.filter.ScheduleFilter;
import com.cerberus.model.schedules.filter.ScheduledEventFilter;

public class SchedulingService {
	private ScheduledEventDAO scheduledEventDAO;
	private ScheduleDAO scheduleDAO;
	private ScheduleRecurrenceDAO scheduleRecurrenceDAO;
	
	public SchedulingService(){
		scheduledEventDAO = new ScheduledEventDAO();
		scheduleDAO = new ScheduleDAO();
		scheduleRecurrenceDAO = new ScheduleRecurrenceDAO();
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
	
	public void deleteScheduledEvent(ScheduledEvent scheduledEvent){
		scheduledEventDAO.delete(scheduledEvent);
	}
	
	public List<ScheduledEvent> getScheduledEvents() {
		return scheduledEventDAO.getAll();		
	}
	
	public ScheduledEvent getScheduledEventById(Integer id) {
		return scheduledEventDAO.getById(id);
	}

	public List<ScheduledEvent> getScheduledEventBySocketId(Integer socketId) {
		return scheduledEventDAO.getAllByFilter(ScheduledEventFilter.getBySocketId(socketId));		
	}
	
	//***************************************************
	//ScheduledEvent
	//***************************************************
	
	public Integer insertSchedule(Schedule schedule){
		return scheduleDAO.save(schedule);
	}
	
	public Schedule updateSchedule(Schedule schedule){
		return scheduleDAO.merge(schedule);
	}
	
	public void deleteSchedule(Schedule schedule){
		scheduleDAO.delete(schedule);
	}

	public List<Schedule> getSchedulesBySocketId(Integer socketId) {
		return scheduleDAO.getAllByFilter(ScheduleFilter.getBySocketId(socketId));		
	}
	
	//***************************************************
	//ScheduleRecurrence
	//***************************************************

	public ScheduleRecurrence getScheduleRecurrenceById(Integer id) {
		return scheduleRecurrenceDAO.getById(id);		
	}
	
	public List<ScheduleRecurrence> getScheduleRecurrences() {
		return scheduleRecurrenceDAO.getAll();
	}
}
