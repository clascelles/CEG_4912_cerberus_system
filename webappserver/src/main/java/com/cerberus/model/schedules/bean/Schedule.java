package com.cerberus.model.schedules.bean;

import java.io.Serializable;

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

@Entity
@Table(name = "SCHEDULE")
public class Schedule implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Integer id;
	ScheduledEvent startEvent;
	ScheduledEvent endEvent;
	Socket socket;
	User user;
	ScheduleRecurrence recurrence;
	
	public Schedule() {}
	
	public Schedule(Integer id, ScheduledEvent startEvent,
			ScheduledEvent endEvent, Socket socket, User user,
			ScheduleRecurrence recurrence) {
		super();
		this.id = id;
		this.startEvent = startEvent;
		this.endEvent = endEvent;
		this.socket = socket;
		this.user = user;
		this.recurrence = recurrence;
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
	@JoinColumn(name="START_EVENT_ID", nullable=false)
	public ScheduledEvent getStartEvent() {
		return startEvent;
	}

	public void setStartEvent(ScheduledEvent startEvent) {
		this.startEvent = startEvent;
	}
	
	@ManyToOne()
	@JoinColumn(name="END_EVENT_ID", nullable=false)
	public ScheduledEvent getEndEvent() {
		return endEvent;
	}

	public void setEndEvent(ScheduledEvent endEvent) {
		this.endEvent = endEvent;
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
	@JoinColumn(name="USER_ID", nullable=false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToOne()
	@JoinColumn(name="RECURRENCE_ID", nullable=false)
	public ScheduleRecurrence getRecurrence() {
		return recurrence;
	}

	public void setRecurrence(ScheduleRecurrence recurrence) {
		this.recurrence = recurrence;
	}
	

	@Override
	public String toString() {
		return "Schedule [id=" + id 
				+ ", startEvent=" + startEvent.toString() 
				+ ", endEvent=" + endEvent.toString() 
				+ ", socket=" + socket.toString() 
				+ ", user=" + user.toString() 
				+ ", recurrence=" + recurrence.toString() + "]";
	}
}
