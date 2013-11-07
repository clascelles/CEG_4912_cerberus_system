package com.cerberus.model.usage.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CURRENT_HOUR_VIEW")
public class CurrentHourView implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	Integer id;
	Timestamp timestampHour;
	Integer systemId;
	double currentHour;
	Integer hour;


	public CurrentHourView() {
		super();
	}

	public CurrentHourView(Timestamp timestampHour, Integer systemId,
			Integer currentHour) {
		super();
		this.timestampHour = timestampHour;
		this.systemId = systemId;
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

	@Column(name="SYSTEM_ID", nullable=false, updatable=false, insertable=false)
	public Integer getSystemId() {
		return systemId;
	}

	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
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
				+ ", systemId=" + systemId + ", currentHour=" + currentHour
				+ "]";
	}

}
