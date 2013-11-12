package com.cerberus.model.usage.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CURRENT_HOUR")
public class CurrentHour implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer userId;
	private Integer socketId;
	private Timestamp timestamp;
	private double currentHour;

	public CurrentHour() {
		super();
	}


	public CurrentHour(Integer userId, Integer socketId,
			Timestamp timestamp, double currentHour) {
		super();
		this.userId = userId;
		this.socketId = socketId;
		this.timestamp = timestamp;
		this.currentHour = currentHour;
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

	@Column(name="USERS_ID", nullable=false)
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name="SOCKET_ID", nullable=false)
	public Integer getSocketId() {
		return socketId;
	}

	public void setSocketId(Integer socketId) {
		this.socketId = socketId;
	}

	@Column(name="TIMESTAMP", nullable=false)
	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Column(name="CURRENT_HOUR", nullable=false)
	public double getCurrentHour() {
		return currentHour;
	}

	public void setCurrentHour(double currentHour) {
		this.currentHour = currentHour;
	}


	@Override
	public String toString() {
		return "CurrentHour [id=" + id + ", userId=" + userId + ", socketId="
				+ socketId + ", timestamp=" + timestamp + ", currentHour="
				+ currentHour + "]";
	}


}
