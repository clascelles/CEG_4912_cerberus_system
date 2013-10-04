package com.cerberus.module.outlets.backingobjects;

import com.cerberus.model.outlets.bean.Socket;
import com.cerberus.module.generic.backingobjects.BackingObject;

public class SocketBackingObject extends BackingObject<Socket> {
	
	private Integer id;
	private Integer statusId;
	private String 	statusName;
	private Integer operationModeId;
	private String 	operationModeName;
	private Integer outletId;
	private String  position;
	private String 	serialNumber;	
	
	//these should all be realtime, so should be stored/updated somehow else
	private String  connectedUsername;
	private String  powerUsage;
	private String	timeConnected;
	private String  connectedUtilityName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public Integer getOperationModeId() {
		return operationModeId;
	}

	public void setOperationModeId(Integer operationModeId) {
		this.operationModeId = operationModeId;
	}

	public String getOperationModeName() {
		return operationModeName;
	}

	public void setOperationModeName(String operationModeName) {
		this.operationModeName = operationModeName;
	}

	public Integer getOutletId() {
		return outletId;
	}

	public void setOutletId(Integer outletId) {
		this.outletId = outletId;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = (position == 0) ? "A" : "B";
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getConnectedUsername() {
		return connectedUsername;
	}

	public void setConnectedUsername(String connectedUsername) {
		this.connectedUsername = connectedUsername;
	}

	public String getPowerUsage() {
		return powerUsage;
	}

	public void setPowerUsage(String powerUsage) {
		this.powerUsage = powerUsage;
	}

	public String getTimeConnected() {
		return timeConnected;
	}

	public void setTimeConnected(String timeConnected) {
		this.timeConnected = timeConnected;
	}

	public String getConnectedUtilityName() {
		return connectedUtilityName;
	}

	public void setConnectedUtilityName(String connectedUtilityName) {
		this.connectedUtilityName = connectedUtilityName;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
}
