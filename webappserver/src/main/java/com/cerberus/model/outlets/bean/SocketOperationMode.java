package com.cerberus.model.outlets.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SOCKET_OPERATION_MODE")
public class SocketOperationMode implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final Integer MANUAL_ON_ID = 1;
	public static final Integer MANUAL_OFF_ID = 2;
	public static final Integer DEFAULT_ID = 3;
	
	Integer id;
	String description;
	
	public SocketOperationMode(){
		super();
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
	
	@Column(name="DESCRIPTION", nullable=false)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	

	@Override
	public String toString() {
		return "SocketOperationMode [id=" + id + ", description=" + description + "]";
	}	
	
	
	
}
