package com.cerberus.module.outlets.backingobjects;

import com.cerberus.model.outlets.bean.SocketOperationMode;
import com.cerberus.module.generic.backingobjects.BackingObject;

public class SocketOperationModeBackingObject extends BackingObject<SocketOperationMode> {

	private Integer id;
	private String name;
	
	public SocketOperationModeBackingObject() {}
	
	public SocketOperationModeBackingObject(Integer id, String name) {
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
