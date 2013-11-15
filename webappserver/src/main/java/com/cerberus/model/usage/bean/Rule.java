package com.cerberus.model.usage.bean;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RULE")
public class Rule implements Serializable{

	public final static Integer DATE = 1;
	public final static Integer TIME = 2;
	public final static Integer CONSUMPTION = 3;
	public final static Integer APPLIANCE = 4;
	
	
	private static final long serialVersionUID = 1L;
	
	Integer id;
	String operator;
	Integer ruleType;
	Date date;
	Time time;
	Double consumption;
	Integer appliance;
	
	public Rule(){
		super();
	}
	
	public Rule(Integer id, String operator, Integer ruleType, Date date,
			Time time, Double consumption, Integer appliance) {
		super();
		this.id = id;
		this.operator = operator;
		this.ruleType = ruleType;
		this.date = date;
		this.time = time;
		this.consumption = consumption;
		this.appliance = appliance;
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
	
	@Column(name="OPERATOR", nullable=false)
	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Column(name="RULE_TYPE", nullable=false)
	public Integer getRuleType() {
		return ruleType;
	}

	public void setRuleType(Integer ruleType) {
		this.ruleType = ruleType;
	}

	@Column(name="DATE", nullable=false)
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Column(name="TIME", nullable=false)
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	@Column(name="CONSUMPTION", nullable=false)
	public Double getConsumption() {
		return consumption;
	}

	public void setConsumption(Double consumption) {
		this.consumption = consumption;
	}

	@Column(name="APPLIANCE", nullable=false)
	public Integer getAppliance() {
		return appliance;
	}

	public void setAppliance(Integer appliance) {
		this.appliance = appliance;
	}

	@Override
	public String toString() {
		return "Rule [id=" + id + ", operator=" + operator + ", ruleType="
				+ ruleType + ", date=" + date + ", time=" + time
				+ ", consumption=" + consumption + ", appliance=" + appliance
				+ "]";
	}
	
}
