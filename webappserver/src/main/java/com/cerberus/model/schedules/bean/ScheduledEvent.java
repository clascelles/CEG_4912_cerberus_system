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
	SocketOperationMode mode;
	Socket socket;
	User user;
	Date time;
	
	public ScheduledEvent() {}
	
	public ScheduledEvent(SocketOperationMode mode, Date time) {
		this(null, mode, null, null, time);
	}
	
	public ScheduledEvent(Integer id, SocketOperationMode mode,
			Socket socket, User user, Date time) {
		super();
		this.id = id;
		this.mode = mode;
		this.socket = socket;
		this.user = user;
		this.time = time;
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
	@JoinColumn(name="SCHEDULE_MODE_ID", nullable=false)
	public SocketOperationMode getMode() {
		return mode;
	}

	public void setMode(SocketOperationMode mode) {
		this.mode = mode;
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
	
	@Column(name="EVENT_TIME", nullable=false)
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "ScheduledEvent [id=" + id 
				+ ", socket=" + socket.getId() 
				+ ", user=" + user.getId() 
				+ ", mode=" + mode.toString()
				+ ", time=" + time.toString() + "]";
	}
	
}
