package com.cerberus.server.persistence.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_TYPE")
public class UserType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Integer id;
	String name;
	
	
	public UserType(){}
	
	public UserType(String name) {
		super();
		this.name = name;
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
	
	@Column(name="TYPE_NAME", nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UserType [id=" + id + ", name=" + name + "]";
	}
	
	
}
