package com.cerberus.module.overview.backingobjects;

import com.cerberus.model.system.bean.EventRecord;
import com.cerberus.module.generic.backingobjects.BackingObject;

public class EventBackingObject extends BackingObject<EventRecord> {

	private int level;
	private String timestamp;
	private String message;

	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}

	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}



}
