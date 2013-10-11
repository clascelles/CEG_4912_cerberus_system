package com.cerberus.module.outlets.backingobjects;

import com.cerberus.model.outlets.bean.OutletOperationMode;
import com.cerberus.module.generic.backingobjects.BackingObject;

public class OutletOperationModeBackingObject extends BackingObject<OutletOperationMode> {
	
	private Integer id;
	private String 	name;

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
