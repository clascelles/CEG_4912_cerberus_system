package com.cerberus.module.outlets.backingobjects;

import com.cerberus.model.outlets.bean.Current;
import com.cerberus.module.generic.backingobjects.BackingObject;

public class CurrentBackingObject extends BackingObject<Current> {

	private String time;
	private String value;
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
}
