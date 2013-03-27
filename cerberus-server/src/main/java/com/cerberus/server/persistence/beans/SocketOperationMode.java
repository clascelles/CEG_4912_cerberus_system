package com.cerberus.server.persistence.beans;

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
