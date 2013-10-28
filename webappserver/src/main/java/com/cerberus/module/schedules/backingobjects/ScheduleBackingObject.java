package com.cerberus.module.schedules.backingobjects;

import java.util.Date;

import com.cerberus.model.account.bean.User;
import com.cerberus.model.outlets.bean.Socket;
import com.cerberus.model.schedules.bean.Schedule;
import com.cerberus.module.generic.backingobjects.BackingObject;

public class ScheduleBackingObject extends BackingObject<Schedule> {

	private static final String rangeDelimiter = " - ";
	
	private ScheduledEventBackingObject startEvent;
	private ScheduledEventBackingObject endEvent;
	private Integer outletId;
	private Socket socket;
	private Integer socketId;
	private User user;
	private Integer userId;
	private String eventDuration;
	
	public ScheduleBackingObject() {}
	
	public ScheduleBackingObject(ScheduledEventBackingObject startEvent,
			ScheduledEventBackingObject endEvent, Integer outletId,
			Socket socket, Integer socketId, User user, Integer userId,
			String eventDuration) {
		super();
		this.startEvent = startEvent;
		this.endEvent = endEvent;
		this.outletId = outletId;
		this.socket = socket;
		this.socketId = socketId;
		this.user = user;
		this.userId = userId;
		this.eventDuration = eventDuration;
	}

	public ScheduledEventBackingObject getStartEvent() {
		return startEvent;
	}

	public void setStartEvent(ScheduledEventBackingObject startEvent) {
		this.startEvent = startEvent;
		if(endEvent != null) {
			setEventDuration(startEvent.getTime(), endEvent.getTime());			
		}
	}

	public ScheduledEventBackingObject getEndEvent() {
		return endEvent;
	}

	public void setEndEvent(ScheduledEventBackingObject endEvent) {
		this.endEvent = endEvent;
		if(startEvent != null) {
			setEventDuration(startEvent.getTime(), endEvent.getTime());			
		}
	}

	public Integer getOutletId() {
		return outletId;
	}

	public void setOutletId(Integer outletId) {
		this.outletId = outletId;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket() {
		if(startEvent != null && endEvent != null 
				&& startEvent.getSocketId() == endEvent.getSocketId()) {
			setSocketId(startEvent.getSocketId());
		}
	}
	
	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public Integer getSocketId() {
		return socketId;
	}

	public void setSocketId(Integer socketId) {
		this.socketId = socketId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEventDuration() {
		return eventDuration;
	}
	
	public void setEventDuration() {
		if(startEvent != null && endEvent != null) {
			setEventDuration(datesToRange(startEvent.getTime(), endEvent.getTime()));
		}
	}
	
	public void setEventDuration(String eventDuration) {
		this.eventDuration = eventDuration;
	}

	public void setEventDuration(String start, String end) {
		eventDuration = start + rangeDelimiter + end;
	}
	
	/*public void setStartTime(Date date) {
		String formatted = formatDate(date);
		eventDuration = formatted + rangeDelimiter + eventDuration.substring(19, 35);
	}*/

	/*public void setEndTime(String date) {
		eventDuration = eventDuration.substring(0, 16) + rangeDelimiter + date;
	}*/
	
	/*public void setEndTime(Date date) {
		String formatted = formatDate(date);
		eventDuration = eventDuration.substring(0, 16) + rangeDelimiter + formatted;
	}*/
	
	public Date getStartTime() {
		return rangeToDates(eventDuration)[0];
	}
	
	public Date getEndTime() {
		return rangeToDates(eventDuration)[1];
	}

	public static String datesToRange(Date startTime, Date endTime) {
		return datesToRange(formatDate(startTime), formatDate(endTime));
	}
	
	public static String datesToRange(String startTime, String endTime) {
		String range = "";
		
		range += startTime + rangeDelimiter + endTime;
		
		return range;
	}
	
	public static Date[] rangeToDates(String range) {
		Date[] dates = new Date[2];
		
		dates[0] = parseDate(range.substring(0, 16));
		dates[1] = parseDate(range.substring(19, 35));
		
		return dates;
	}
	
	public static Date parseDate(String formatted) {
		Date date = new Date();
		
		date.setMonth(Integer.parseInt(formatted.substring(0, 2)));
		date.setDate(Integer.parseInt(formatted.substring(3, 5)));
		date.setYear(Integer.parseInt(formatted.substring(6, 10)));

		date.setHours(Integer.parseInt(formatted.substring(11, 13)));
		date.setMinutes(Integer.parseInt(formatted.substring(14, 16)));
		
		return date;
	}
	
	public static String formatDate(Date date) {
		String formatted = "";
		formatted += padNumeral(date.getMonth()+1);
		formatted += "/";
		formatted += padNumeral(date.getDate());
		formatted += "/";
		formatted += date.getYear() + 1900;
		formatted += " ";
		formatted += padNumeral(date.getHours());
		formatted += ":";
		formatted += padNumeral(date.getMinutes());
		
		return formatted;
	}
	
	public static String padNumeral(int number) {
		return (number < 10) ? "0" + number : "" + number;
	}
}
