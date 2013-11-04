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
	

	/*
	 * Manual_off 	00000001 or 1
	 * manual_on 	00000010 or 2
	 * normal 		00000100 or 4
	 * restricted  	00001000 or 8
	 * child safety	00010000 or 16
	 * monitoring	00100000 or 32
	*/
	
	public static final Integer MANUAL_OFF = 1;
	public static final Integer MANUAL_ON = 2;
	public static final Integer NORMAL = 3;
	
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
