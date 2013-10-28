package com.cerberus.module.schedules.backingobjects;

import java.util.Date;

import com.cerberus.model.account.bean.User;
import com.cerberus.model.outlets.bean.Socket;
import com.cerberus.model.outlets.bean.SocketOperationMode;
import com.cerberus.model.schedules.bean.ScheduledEvent;
import com.cerberus.module.generic.backingobjects.BackingObject;

public class ScheduledEventBackingObject extends BackingObject<ScheduledEvent> {

	private SocketOperationMode startMode;
	private Integer startModeId;
	private SocketOperationMode endMode;
	private Integer endModeId;
	private Integer outletId;
	private Socket socket;
	private Integer socketId;
	private User user;
	private Integer userId;
	private String eventDuration;
	
	public ScheduledEventBackingObject() {}
	
	public ScheduledEventBackingObject(SocketOperationMode startMode,
			Integer startModeId, SocketOperationMode endMode,
			Integer endModeId, Integer outletId, Socket socket, 
			Integer socketId, User user, Integer userId, 
			Date startTime, Date endTime) {
		super();
		this.startMode = startMode;
		this.startModeId = startModeId;
		this.endMode = endMode;
		this.endModeId = endModeId;
		this.outletId = outletId;
		this.socket = socket;
		this.socketId = socketId;
		this.user = user;
		this.userId = userId;
		setEventDuration(startTime, endTime);
	}

	public SocketOperationMode getStartMode() {
		return startMode;
	}

	public void setStartMode(SocketOperationMode startMode) {
		this.startMode = startMode;
		this.startModeId = startMode.getId();
	}

	public Integer getStartModeId() {
		return startModeId;
	}
	
	public void setStartModeId(Integer startModeId) {
		this.startModeId = startModeId;
	}

	public SocketOperationMode getEndMode() {
		return endMode;
	}

	public void setEndMode(SocketOperationMode endMode) {
		this.endMode = endMode;
		this.endModeId = endMode.getId();
	}

	public Integer getEndModeId() {
		return endModeId;
	}
	
	public void setEndModeId(Integer endModeId) {
		this.endModeId = endModeId;
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

	public void setSocket(Socket socket) {
		this.socket = socket;
		this.socketId = socket.getId();
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
		this.userId = user.getId();
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
	
	public void setEventDuration(Date startTime, Date endTime) {
		this.eventDuration = datesToRange(startTime, endTime);
	}

	public void setEventDuration(String eventDuration) {
		this.eventDuration = eventDuration;
	}
	
	public Date getStartTime() {
		return rangeToDates(eventDuration)[0];
	}
	
	public Date getEndTime() {
		return rangeToDates(eventDuration)[1];
	}

	public static String datesToRange(Date startTime, Date endTime) {
		String range = "";
		
		range += formatDate(startTime) + " - " + formatDate(endTime);
		
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
