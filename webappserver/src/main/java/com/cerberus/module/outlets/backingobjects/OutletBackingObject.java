package com.cerberus.module.outlets.backingobjects;

import com.cerberus.model.outlets.bean.Outlet;
import com.cerberus.module.generic.backingobjects.BackingObject;

public class OutletBackingObject extends BackingObject<Outlet> {
	
	private Integer id;
	private Integer roomId;
	private String 	roomName;
	private Integer modeId;
	private String 	modeName;
	private String serialNumber;
	private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Integer getModeId() {
		return modeId;
	}

	public void setModeId(Integer modeId) {
		this.modeId = modeId;
	}

	public String getModeName() {
		return modeName;
	}

	public void setModeName(String modeName) {
		this.modeName = modeName;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public void setStatus(Boolean connected) {
		if(connected) {
			status = "Connected";
		} else {
			status = "Disconnected";
		}
	}
	
	public String getStatus() {
		return status;
	}
	
}
