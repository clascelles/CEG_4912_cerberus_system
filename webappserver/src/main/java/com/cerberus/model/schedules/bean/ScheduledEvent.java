package com.cerberus.model.schedules.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cerberus.model.account.bean.User;
import com.cerberus.model.outlets.bean.Socket;
import com.cerberus.model.outlets.bean.SocketOperationMode;

@Entity
@Table(name = "SCHEDULED_EVENT")
public class ScheduledEvent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Integer id;
	SocketOperationMode startMode;
	SocketOperationMode endMode;
	Socket socket;
	User user;
	Date startTime;
	Date endTime;
	
	public ScheduledEvent() {}
	
	public ScheduledEvent(Integer id, SocketOperationMode startMode,
			SocketOperationMode endMode, Socket socket, User user,
			Date startTime, Date endTime) {
		super();
		this.id = id;
		this.startMode = startMode;
		this.endMode = endMode;
		this.socket = socket;
		this.user = user;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID", nullable=false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne()
	@JoinColumn(name="SCHEDULE_START_MODE_ID", nullable=false)
	public SocketOperationMode getStartMode() {
		return startMode;
	}

	public void setStartMode(SocketOperationMode startMode) {
		this.startMode = startMode;
	}
	
	@ManyToOne()
	@JoinColumn(name="SCHEDULE_END_MODE_ID", nullable=false)
	public SocketOperationMode getEndMode() {
		return endMode;
	}

	public void setEndMode(SocketOperationMode endMode) {
		this.endMode = endMode;
	}

	@ManyToOne()
	@JoinColumn(name="SOCKET_ID", nullable=false)
	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	@ManyToOne()
	@JoinColumn(name="USERS_ID", nullable=false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Column(name="START_TIME", nullable=false)
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	@Column(name="END_TIME", nullable=false)
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "ScheduleStartMode [id=" + id 
				+ ", socket=" + socket.getId() 
				+ ", user=" + user.getId() 
				+ ", startTime=" + startTime.toString() 
				+ ", endTime=" + endTime.toString() 
				+ ", startMode=" + startMode.getMode().getName() 
				+ ", endMode=" + endMode.getMode().getName() + "]";
	}
	
}
