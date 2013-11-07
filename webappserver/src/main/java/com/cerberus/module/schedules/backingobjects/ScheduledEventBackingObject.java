package com.cerberus.module.schedules.backingobjects;

import java.util.Date;
import java.util.List;

import com.cerberus.frameworks.logging.CerberusLogger;
import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.account.bean.User;
import com.cerberus.model.outlets.bean.Outlet;
import com.cerberus.model.outlets.bean.Socket;
import com.cerberus.model.outlets.bean.SocketOperationMode;
import com.cerberus.model.schedules.bean.ScheduledEvent;
import com.cerberus.module.generic.backingobjects.BackingObject;
import com.cerberus.module.outlets.workflows.OutletWorkflow;

public class ScheduledEventBackingObject extends BackingObject<ScheduledEvent> {

	private Integer id;
	private SocketOperationMode mode;
	private Integer modeId;
	private Integer outletId;
	private Socket socket;
	private Integer socketId;
	private Integer socketPosition;
	private User user;
	private Integer userId;
	private String time;
	
	public ScheduledEventBackingObject() {}
	
	public ScheduledEventBackingObject(Integer id,
			SocketOperationMode mode,
			Integer outletId, Socket socket, 
			Integer socketId, Integer socketPosition,
			User user, Integer userId, 
			String time) {
		super();
		this.id = id;
		this.outletId = outletId;
		this.socket = socket;
		this.socketId = socketId;
		this.socketPosition = socketPosition;
		this.user = user;
		this.userId = userId;
		this.time = time;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public SocketOperationMode getMode() {
		if(mode != null) {
			return mode;
		}
		
		OutletWorkflow outletWorkflow = CerberusApplicationContext.getWorkflows().getOutletWorkflow();
		return outletWorkflow.getSocketModeById(modeId);	
	}

	public void setMode(SocketOperationMode mode) {
		this.mode = mode;
		this.modeId = mode.getId();
	}

	public Integer getModeId() {
		return modeId;
	}

	public void setModeId(Integer modeId) {
		this.modeId = modeId;
	}

	public Integer getOutletId() {
		return outletId;
	}
	
	public void setOutletId(Integer outletId) {
		this.outletId = outletId;
	}

	public Socket getSocket() {
		if(socket != null) {
			return socket;
		}
		
		OutletWorkflow outletWorkflow = CerberusApplicationContext.getWorkflows().getOutletWorkflow();
		Outlet outlet = outletWorkflow.getOutletById(outletId);
		List<Socket> sockets = outletWorkflow.getSocketsByOutlet(outlet);
		return (!sockets.isEmpty()) ? sockets.get(socketId) : null;		
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
	
	public Integer getSocketPosition() {
		return socketPosition;
	}

	public void setSocketPosition(Integer socketPosition) {
		this.socketPosition = socketPosition;
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
	
	public String getTime() {
		return time;
	}

	public void setTime(Date time) {
		setTime(formatDate(time));
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public static Date parseDate(String formatted) {
		Date date = new Date();
		
		try {
			Integer month = Integer.parseInt(formatted.substring(0, 2)) - 1;
			date.setMonth(month);
			Integer day = Integer.parseInt(formatted.substring(3, 5));
			date.setDate(day);
			Integer year = Integer.parseInt(formatted.substring(6, 10));
			date.setYear(year - 1900);

			Integer hours = Integer.parseInt(formatted.substring(11, 13));
			date.setHours(hours);
			Integer minutes = Integer.parseInt(formatted.substring(14, 16));
			date.setMinutes(minutes);
		} catch (NumberFormatException e) {
			CerberusLogger.printErrorMessage("Parsing date failed, number format exception");
		} catch (NullPointerException e) {
			CerberusLogger.printErrorMessage("Parsing date failed, null pointer exception");
		}
		
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

	@Override
	public String toString() {
		return "ScheduledEventBackingObject [id=" + id + ", mode=" + mode
				+ ", modeId=" + modeId + ", outletId=" + outletId + ", socket="
				+ socket + ", socketId=" + socketId + ", socketPosition="
				+ socketPosition + ", user=" + user + ", userId=" + userId
				+ ", time=" + time + "]";
	}	
}
