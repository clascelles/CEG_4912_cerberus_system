package com.cerberus.model.system.bean;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EVENT_RECORD")
public class EventRecord implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	Integer id;
	Integer outletId;
	Integer eventId;
	Timestamp timestamp;

	public EventRecord() {
		super();
	}

	public EventRecord(Integer outletId, Integer eventId, Timestamp timestamp) {
		super();
		this.outletId = outletId;
		this.eventId = eventId;
		this.timestamp = timestamp;
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

	@Column(name="OUTLET_ID", nullable=false)
	public Integer getOutletId() {
		return outletId;
	}
	public void setOutletId(Integer outletId) {
		this.outletId = outletId;
	}

	@Column(name="EVENT_ID", nullable=false)
	public Integer getEventId() {
		return eventId;
	}
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	@Column(name="TIMESTAMP", nullable=false)
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "EventRecord [id=" + id + ", outlet=" + outletId + ", event="
				+ eventId + ", timestamp=" + timestamp + "]";
	}
}
