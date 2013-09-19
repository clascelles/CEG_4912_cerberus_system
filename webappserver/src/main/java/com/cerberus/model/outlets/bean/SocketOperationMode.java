package com.cerberus.model.outlets.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SOCKET_OPERATION_MODE")
public class SocketOperationMode implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final Integer DISABLED = 1;
	public static final Integer MONITORING = 2;
	public static final Integer AUTHENTICATION = 3;
	public static final Integer CHILD_SAFETY = 4;
	
	Integer id;
	OutletOperationMode mode;
	String description;
	
	public SocketOperationMode(){
		super();
	}
	
	public SocketOperationMode(OutletOperationMode mode) {
		super();
		this.mode = mode;
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
	
	@ManyToOne()
	@JoinColumn(name="OUTLET_OPERATION_MODE", nullable=false)
	public OutletOperationMode getMode() {
		return mode;
	}
	public void setMode(OutletOperationMode mode) {
		this.mode = mode;
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
		return "SocketOperationMode [id=" + id + ", mode=" + mode + "]";
	}	
	
	
	
}
