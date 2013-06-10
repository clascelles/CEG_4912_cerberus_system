package com.cerberus.persistence.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_SETTING")
public class UserSetting implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Integer id;
	Integer defaultOperation;
	Integer defaultAssignment;
	
	public UserSetting(){
		super();
	}
	
	public UserSetting(Integer defaultOperation, Integer defaultAssignment) {
		super();
		this.defaultOperation = defaultOperation;
		this.defaultAssignment = defaultAssignment;
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
	
	@Column(name="DEFAULT_OPERATION", nullable=false)
	public Integer getDefaultOperation() {
		return defaultOperation;
	}
	public void setDefaultOperation(Integer defaultOperation) {
		this.defaultOperation = defaultOperation;
	}
	
	@Column(name="DEFAULT_ASSIGNMENT", nullable=false)
	public Integer getDefaultAssignment() {
		return defaultAssignment;
	}
	public void setDefaultAssignment(Integer defaultAssignment) {
		this.defaultAssignment = defaultAssignment;
	}

	@Override
	public String toString() {
		return "UserSetting [id=" + id + ", defaultOperation="
				+ defaultOperation + ", defaultAssignment=" + defaultAssignment
				+ "]";
	}
	
	
}
