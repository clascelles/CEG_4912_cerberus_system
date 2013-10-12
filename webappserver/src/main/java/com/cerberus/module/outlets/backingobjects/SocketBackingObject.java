package com.cerberus.module.outlets.backingobjects;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	private Integer connectedUserId;
	private String  connectedUsername;
	private String  powerUsage = getRandomInRangeString(0,5, false) + " amps";
	private String	timeConnected = getRandomInRangeString(0,12, false) + ":" + getRandomInRangeString(0,60, true) + ":" + getRandomInRangeString(0,60, true);
	private String  connectedUtilityName = getRandomUtility();
	
	//For the current graphs
	//private 
	//private double[] 
	private List<CurrentBackingObject> currentLog = new ArrayList<CurrentBackingObject>();
	
	
	{
		Date newDate = new Date();
		int hours = newDate.getHours();
		int mins = newDate.getMinutes();
		
		for(int i = 0; i < 20; i++) {
			int secs = ((i % 2) == 0) ? 0 : 30;
			int minsOffset = i/2;
			currentLog.add(CurrentBackingObjectFactory.generateRandomCurrent(hours + ":" + (mins + minsOffset) + ":" + secs));
		}
		
	}

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

	public Integer getConnectedUserId() {
		return connectedUserId;
	}

	public void setConnectedUserId(Integer connectedUserId) {
		this.connectedUserId = connectedUserId;
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
	
	//Temporary helper methods until we have real data to retrieve from the db
	public static int getRandomInRange(int max, int min) {
		return min + (int)(Math.random() * ((max - min + 1)));
	}
	
	public static String getRandomInRangeString(int max, int min, boolean pad) {
		int value = getRandomInRange(min, max);
		return (value < 10 && pad) ? "0" + String.valueOf(value) : String.valueOf(value);
	}
	
	public static String getRandomUtility() {
		int utilVal = getRandomInRange(0,6);
		
		if (utilVal == 0) {
			return "Toaster";
		} else if (utilVal == 1) {
			return "Computer";
		} else if (utilVal == 2) {
			return "Phone charger";
		} else if (utilVal == 3) {
			return "Microwave";
		} else if (utilVal == 4) {
			return "Hair dryer";
		} else if (utilVal == 5) {
			return "Television";
		} else {
			return "Clock radio";
		}
	}	
}
