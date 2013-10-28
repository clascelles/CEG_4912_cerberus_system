package com.cerberus.model.schedules.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ScheduleRecurrence implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final Integer ONCE_ID = 1;
	public static final Integer HOURLY_ID = 2;
	public static final Integer DAILY_ID = 3;
	public static final Integer WEEKLY_ID = 4;
	public static final Integer BI_WEEKLY_ID = 5;
	public static final Integer MONTHLY_ID = 6;
	public static final Integer YEARLY_ID = 7;	
	
	Integer id;
	String name;	
	
	public ScheduleRecurrence() {}
	
	public ScheduleRecurrence(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	@Column(name="NAME", nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ScheduleRecurrence [id=" + id 
				+ ", name=" + name + "]";
	}	
}
