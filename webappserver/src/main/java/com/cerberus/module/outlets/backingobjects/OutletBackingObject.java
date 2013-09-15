package com.cerberus.module.outlets.backingobjects;

import com.cerberus.model.outlets.bean.OutletOperationMode;
import com.cerberus.model.system.bean.CerberusSystem;
import com.cerberus.model.system.bean.Room;

public class OutletBackingObject {
	
	private Integer id;
	private Room room;
	private OutletOperationMode mode;
	private Integer serialNumber;
	private CerberusSystem system;
	private Integer systemId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public OutletOperationMode getMode() {
		return mode;
	}

	public void setMode(OutletOperationMode mode) {
		this.mode = mode;
	}

	public Integer getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

	public CerberusSystem getSystem() {
		return system;
	}

	public void setSystem(CerberusSystem system) {
		this.system = system;
	}

	public Integer getSystemId() {
		return systemId;
	}

	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}
	
	
	
}
