package com.cerberus.persistence.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GENERAL_PROFILE")
public class GeneralProfile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	Integer id;
	String typeOfDevice;
	Integer range;
	Integer averageHourlyConsumption;
	Integer instantaneousConsumption;
	
	public GeneralProfile(){
		super();
	}
	
	public GeneralProfile(String typeOfDevice, Integer range, Integer averageHourlyConsumption, Integer instantaneousConsumption) {
		super();
		this.typeOfDevice = typeOfDevice;
		this.range = range;
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
	
	@Column(name="TYPE_OF_DEVICE", nullable=false)
	public String getTypeOfDevice() {
		return typeOfDevice;
	}
	public void setTypeOfDevice(String typeOfDevice) {
		this.typeOfDevice = typeOfDevice;
	}	
	
	@Column(name="RANGE", nullable=false)
	public Integer getRange() {
		return range;
	}
	public void setRange(Integer range) {
		this.range = range;
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

	@Override
	public String toString() {
		return "GeneralProfile [id=" + id + ", typeOfDevice=" + typeOfDevice
				+ ", range=" + range + ", averageHourlyConsumption="
				+ averageHourlyConsumption + ", instantaneousConsumption="
				+ instantaneousConsumption + "]";
	}	
	
	
}
