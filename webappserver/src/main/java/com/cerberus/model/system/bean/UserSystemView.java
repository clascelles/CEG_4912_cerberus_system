package com.cerberus.model.system.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.jmock.auto.Auto;

@Entity
@Table(name = "USER_SYSTEM_VIEW")
public class UserSystemView {//implements Serializable{

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	
	
	Integer userId;
	Integer systemId;
	
	public UserSystemView() {
		super();
	}
	
	public UserSystemView(Integer userId, Integer systemId) {
		super();
		this.userId = userId;
		this.systemId = systemId;
	}
	
	@Id
	@Column(name="USERS_ID", nullable=false, updatable=false, insertable=false)
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	@Column(name="SYSTEM_ID", nullable=false, updatable=false, insertable=false)
	public Integer getSystemId() {
		return systemId;
	}
	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}

	@Override
	public String toString() {
		return "UserSystemView [userId=" + userId + ", systemId=" + systemId
				+ "]";
	}
	
}
