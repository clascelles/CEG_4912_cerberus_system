package com.cerberus.model.usage.bean;

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
	String name;
	Integer averageHourlyConsumption;

	public ConsumptionProfile(){
		super();
	}

	public ConsumptionProfile(String name, Integer averageHourlyConsumption) {
		super();
		this.name = name;
		this.averageHourlyConsumption = averageHourlyConsumption;
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

	@Column(name="PROFILE_NAME", nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name="AVERAGE_HOURLY_CONSUMPTION", nullable=false)
	public Integer getAverageHourlyConsumption() {
		return averageHourlyConsumption;
	}
	public void setAverageHourlyConsumption(Integer averageHourlyConsumption) {
		this.averageHourlyConsumption = averageHourlyConsumption;
	}

	@Override
	public String toString() {
		return "ConsumptionProfile [id=" + id + ", name=" + name
				+ ", averageHourlyConsumption=" + averageHourlyConsumption
				+ "]";
	}


}
