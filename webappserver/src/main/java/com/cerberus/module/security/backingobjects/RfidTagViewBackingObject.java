package com.cerberus.module.security.backingobjects;

import com.cerberus.model.security.bean.RfidTagView;
import com.cerberus.module.generic.backingobjects.BackingObject;
import com.cerberus.module.security.constants.RfidPermission;

public class RfidTagViewBackingObject extends BackingObject<RfidTagView> {

	private Integer id;
	private String number;
	private String name;
	private String profile;
	private RfidPermission permission;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public RfidPermission getPermission() {
		return permission;
	}

	public void setPermission(RfidPermission permission) {
		this.permission = permission;
	}

}
