package com.cerberus.persistence.beans;

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
@Table(name = "OUTLET")
public class Outlet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Room room;
	private OutletOperationMode mode;
	private Integer serialNumber;
	private System system;
	
	public Outlet() {
		super();
	}
	
	public Outlet(Room room, OutletOperationMode mode, Integer serialNumber, System system) {
		super();
		this.room = room;
		this.mode = mode;
		this.serialNumber = serialNumber;	
		this.system = system;
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
	@JoinColumn(name="ROOM_ID", nullable=false)
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	@ManyToOne()
	@JoinColumn(name="OUTLET_OPERATION_MODE_ID", nullable=false)
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

	@ManyToOne()
	@JoinColumn(name="SYSTEM_ID", nullable=false)
	public System getSystem() {
		return system;
	}

	public void setSystem(System system) {
		this.system = system;
	}

	@Override
	public String toString() {
		return "Outlet [id=" + id + ", room=" + room + ", mode=" + mode
				+ ", serialNumber=" + serialNumber + ", system=" + system + "]";
	}
	
}
