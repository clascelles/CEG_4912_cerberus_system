package com.cerberus.model.outlets.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.module.outlets.workflows.OutletWorkflow;

@Entity
@Table(name = "SOCKET")
public class Socket implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final Integer TOP = 0;
	public static final Integer BOTTOM = 1;
	
	private Integer id;
	private SocketOperationStatus status;
	private SocketOperationMode mode;
	private Outlet outlet;
	private Integer position;
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

	@Column(name="SOCKET_POSITION", nullable=false)
	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
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
	
	//helper
	@Transient
	public static Socket create(Outlet outlet, Integer position, String serialNumber) {
		Socket socket = new Socket();

		OutletWorkflow outletWorkflow = CerberusApplicationContext.getWorkflows().getOutletWorkflow();
		
		socket.setMode(outletWorkflow.getSocketModeById(SocketOperationMode.DISABLED));
		socket.setOutlet(outlet);
		socket.setPosition(position);
		socket.setStatus(outletWorkflow.getSocketStatusById(SocketOperationStatus.DISABLED));
		socket.setSerialNumber(serialNumber);
		
		return socket;
	}
	
	@Transient
	public static String getNewSerial() {		
		OutletWorkflow outletWorkflow = CerberusApplicationContext.getWorkflows().getOutletWorkflow();
		String serial = "4500006700";
		List<String> existingSerials = new ArrayList<String>();
		for(Socket socket : outletWorkflow.getAllSockets()) {
			existingSerials.add(socket.getSerialNumber());
		}
		
		while(existingSerials.contains(serial)) {
			Long serialValue = Long.parseLong(serial);
			serialValue++;
			serial = serialValue.toString();
		}
		
		return serial;
	}
		
}
