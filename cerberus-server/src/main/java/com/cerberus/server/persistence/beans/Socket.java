package com.cerberus.server.persistence.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SOCKET")
public class Socket implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private SocketOperationStatus status;
	private SocketOperationMode mode;
	private Outlet outlet;
	
	public Socket() {}
	
	public Socket(SocketOperationStatus status, SocketOperationMode mode, Outlet outlet) {
		super();
		this.setStatus(status);
		this.mode = mode;
		this.setOutlet(outlet);		
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

	@Column(name="SOCKET_OPERATION_STATUS_ID", nullable=false)
	public SocketOperationStatus getStatus() {
		return status;
	}
	public void setStatus(SocketOperationStatus status) {
		this.status = status;
	}
	
	@Column(name="SOCKET_OPERATION_MODE_ID", nullable=false)
	public SocketOperationMode getMode() {
		return mode;
	}

	public void setMode(SocketOperationMode mode) {
		this.mode = mode;
	}

	@Column(name="OUTLET_ID", nullable=false)
	public Outlet getOutlet() {
		return outlet;
	}
	public void setOutlet(Outlet outlet) {
		this.outlet = outlet;
	}
	
}
