package com.cerberus.module.schedules.backingobjects;

import com.cerberus.model.schedules.bean.ScheduleRecurrence;
import com.cerberus.module.generic.backingobjects.BackingObject;

public class ScheduleRecurrenceBackingObject extends BackingObject<ScheduleRecurrence> {

	private Integer id;
	private String name;
	
	public ScheduleRecurrenceBackingObject() {}
	
	public ScheduleRecurrenceBackingObject(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
