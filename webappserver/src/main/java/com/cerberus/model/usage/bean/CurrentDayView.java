package com.cerberus.model.usage.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "CURRENT_DAY_VIEW")
public class CurrentDayView implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	Integer id;
	Timestamp timestampDay;
	Integer systemId;
	double currentDay;
	Integer day;


	public CurrentDayView() {
		super();
	}

	public CurrentDayView(Timestamp timestampDay, Integer systemId,
			double currentDay) {
		super();
		this.timestampDay = timestampDay;
		this.systemId = systemId;
		this.currentDay = currentDay;
	}

	@Id
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="TIMESTAMP_DAY", nullable=false, updatable=false, insertable=false)
	public Timestamp getTimestampDay() {
		return timestampDay;
	}

	public void setTimestampDay(Timestamp timestampDay) {
		this.timestampDay = timestampDay;
	}

	@Column(name="SYSTEM_ID", nullable=false, updatable=false, insertable=false)
	public Integer getSystemId() {
		return systemId;
	}

	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}

	@Column(name="CURRENT_DAY_KWH", nullable=false, updatable=false, insertable=false)
	public double getCurrentDay() {
		return currentDay;
	}

	public void setCurrentDay(double currentDay) {
		this.currentDay = currentDay;
	}

	@Column(name="DAY", nullable=false, updatable=false, insertable=false)
	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "CurrentDayView [timestampDay=" + timestampDay
				+ ", systemId=" + systemId + ", currentDay=" + currentDay
				+ "]";
	}

}
