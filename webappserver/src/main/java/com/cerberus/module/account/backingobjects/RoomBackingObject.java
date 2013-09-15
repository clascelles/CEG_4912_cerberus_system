package com.cerberus.module.account.backingobjects;

import com.cerberus.model.system.bean.RoomType;

public class RoomBackingObject {
	
	private String name;
	private RoomType type;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public RoomType getType() {
		return type;
	}
	
	public void setType(RoomType type) {
		this.type = type;
	}	
	
}
