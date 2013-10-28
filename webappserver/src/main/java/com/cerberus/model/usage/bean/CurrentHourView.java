package com.cerberus.model.usage.bean;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cerberus.model.outlets.bean.Outlet;

@Entity
@Table(name = "CURRENT_HOUR_VIEW_2")
public class CurrentHourView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	Integer id;
	Date timestampHour;
	Integer systemId;
	Integer currentHour;
	Integer hour;
	
	
	public CurrentHourView() {
		super();
	}
	
	public CurrentHourView(Date timestampHour, Integer systemId,
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
	public Date getTimestampHour() {
		return timestampHour;
	}

	public void setTimestampHour(Date timestampHour) {
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
	public Integer getCurrentHour() {
		return currentHour;
	}

	public void setCurrentHour(Integer currentHour) {
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
