package com.cerberus.model.outlets.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private String serialNumber;
	
	public Socket() {
		super();
	}
	
	public Socket(SocketOperationStatus status, SocketOperationMode mode,
			Outlet outlet, String serialNumber) {
		super();
		this.status = status;
		this.mode = mode;
		this.outlet = outlet;
		this.serialNumber = serialNumber;
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
	@JoinColumn(name="SOCKET_OPERATION_STATUS_ID", nullable=false)
	public SocketOperationStatus getStatus() {
		return status;
	}
	public void setStatus(SocketOperationStatus status) {
		this.status = status;
	}
	
	@ManyToOne()
	@JoinColumn(name="SOCKET_OPERATION_MODE_ID", nullable=false)
	public SocketOperationMode getMode() {
		return mode;
	}

	public void setMode(SocketOperationMode mode) {
		this.mode = mode;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="OUTLET_ID", nullable=false)
	public Outlet getOutlet() {
		return outlet;
	}
	public void setOutlet(Outlet outlet) {
		this.outlet = outlet;
	}


	@Column(name="SERIAL_NUM", nullable=false)
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Override
	public String toString() {
		return "Socket [id=" + id + ", status=" + status + ", mode=" + mode
				+ ", outlet=" + outlet + "]";
	}
		
}
