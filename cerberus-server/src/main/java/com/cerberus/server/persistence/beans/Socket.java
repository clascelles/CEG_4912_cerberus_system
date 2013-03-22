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
	private Room room;
	private OutletOperationMode mode;
	private Integer serialNumber;
	
	public Socket() {}
	
	public Socket(Room room, OutletOperationMode mode, Integer serialNumber) {
		super();
		this.room = room;
		this.mode = mode;
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

	@Column(name="ROOM_ID", nullable=false)
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	@Column(name="OUTLET_OPERATION_MODE", nullable=false)
	public OutletOperationMode getMode() {
		return mode;
	}

	public void setMode(OutletOperationMode mode) {
		this.mode = mode;
	}

	@Column(name="SERIAL_NUM", nullable=false)
	public Integer getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}
	
}
