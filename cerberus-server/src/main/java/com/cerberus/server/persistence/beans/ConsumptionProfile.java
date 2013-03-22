package com.cerberus.server.persistence.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONSUMPTION_PROFILE")
public class ConsumptionProfile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	Integer id;
	RfidTag rfidTag;
	Integer averageHourlyConsumption;
	Integer instantaneousConsumption;
	
	public ConsumptionProfile(RfidTag rfidTag, Integer averageHourlyConsumption, Integer instantaneousConsumption) {
		super();
		this.rfidTag = rfidTag;
		this.averageHourlyConsumption = averageHourlyConsumption;
		this.instantaneousConsumption = instantaneousConsumption;
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
	
	@Column(name="RFID_TAG_ID", nullable=false)
	public RfidTag getRfidTag() {
		return rfidTag;
	}
	public void setRfidTag(RfidTag rfidTag) {
		this.rfidTag = rfidTag;
	}
	
	@Column(name="AVERAGE_HOURLY_CONSUMPTION", nullable=false)
	public Integer getAverageHourlyConsumption() {
		return averageHourlyConsumption;
	}
	public void setAverageHourlyConsumption(Integer averageHourlyConsumption) {
		this.averageHourlyConsumption = averageHourlyConsumption;
	}	
	
	@Column(name="INSTANTANEOUS_CONSUMPTION", nullable=false)
	public Integer getInstantaneousConsumption() {
		return instantaneousConsumption;
	}
	public void setInstantaneousConsumption(Integer instantaneousConsumption) {
		this.instantaneousConsumption = instantaneousConsumption;
	}	
}
