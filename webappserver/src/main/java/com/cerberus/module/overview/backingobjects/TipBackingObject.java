package com.cerberus.module.overview.backingobjects;

import com.cerberus.model.usage.bean.Tip;
import com.cerberus.module.generic.backingobjects.BackingObject;

public class TipBackingObject extends BackingObject<Tip> {

	//Level
	// 1 = New
	// 2 = Recent
	// 3 = Old
	private Integer level;
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
