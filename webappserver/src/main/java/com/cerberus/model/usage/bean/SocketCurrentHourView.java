package com.cerberus.model.usage.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SOCKET_CURRENT_VIEW_BY_HOUR")
public class SocketCurrentHourView implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	Integer id;
	Timestamp timestampHour;
	Integer socketId;
	double currentHour;
	Integer hour;


	public SocketCurrentHourView() {
		super();
	}

	public SocketCurrentHourView(Timestamp timestampHour, Integer socketId,
			double currentHour) {
		super();
		this.timestampHour = timestampHour;
		this.socketId = socketId;
		this.currentHour = currentHour;
	}

	@Id
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="TIMESTAMP_HOUR", nullable=false, updatable=false, insertable=false)
	public Timestamp getTimestampHour() {
		return timestampHour;
	}

	public void setTimestampHour(Timestamp timestampHour) {
		this.timestampHour = timestampHour;
	}

	@Column(name="SOCKET_ID", nullable=false, updatable=false, insertable=false)
	public Integer getSocketId() {
		return socketId;
	}

	public void setSocketId(Integer socketId) {
		this.socketId = socketId;
	}

	@Column(name="CURRENT_HOUR_KWH", nullable=false, updatable=false, insertable=false)
	public double getCurrentHour() {
		return currentHour;
	}

	public void setCurrentHour(double currentHour) {
		this.currentHour = currentHour;
	}

	@Column(name="HOUR", nullable=false, updatable=false, insertable=false)
	public Integer getHour() {
		return hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
	}

	@Override
	public String toString() {
		return "CurrentHourView [timestampHour=" + timestampHour
				+ ", socketId=" + socketId + ", currentHour=" + currentHour
				+ "]";
	}

}
