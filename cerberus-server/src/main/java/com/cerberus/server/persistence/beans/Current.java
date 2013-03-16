package com.cerberus.server.persistence.beans;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CURRENT")
public class Current {

	private int id;
	private int rfidTagId;
	private int userId;
	private int socketId;
	private Timestamp timestamp;
	private int current;
	
	public Current(){}
	
	public Current(int rfidTagId, int userId, int socketId,
			Timestamp timestamp, int current) {
		super();
		this.rfidTagId = rfidTagId;
		this.userId = userId;
		this.socketId = socketId;
		this.timestamp = timestamp;
		this.current = current;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID", nullable=false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="RFID_TAG_ID", nullable=true)
	public int getRfidTagId() {
		return rfidTagId;
	}
	public void setRfidTagId(int rfidTagId) {
		this.rfidTagId = rfidTagId;
	}
	
	@Column(name="USERS_ID", nullable=false)
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Column(name="SOCKET_ID", nullable=false)
	public int getSocketId() {
		return socketId;
	}
	public void setSocketId(int socketId) {
		this.socketId = socketId;
	}
	
	@Column(name="TIMESTAMP", nullable=false)
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	@Column(name="CURRENT", nullable=false)
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}
	
}
