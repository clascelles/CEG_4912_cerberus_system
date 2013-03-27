package com.cerberus.server.persistence.beans;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CURRENT")
public class Current implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private RfidTag rfidTagId;
	private User user;
	private Socket socket;
	private Timestamp timestamp;
	private Integer current;
	
	public Current() {
		super();
	}

	public Current(RfidTag rfidTagId, User user, Socket socket,
			Timestamp timestamp, Integer current) {
		super();
		this.rfidTagId = rfidTagId;
		this.user = user;
		this.socket = socket;
		this.timestamp = timestamp;
		this.current = current;
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
	@JoinColumn(name="RFID_TAG_ID", nullable=false)
	public RfidTag getRfidTagId() {
		return rfidTagId;
	}

	public void setRfidTagId(RfidTag rfidTagId) {
		this.rfidTagId = rfidTagId;
	}

	@ManyToOne()
	@JoinColumn(name="USERS_ID", nullable=false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne()
	@JoinColumn(name="SOCKET_ID", nullable=false)
	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	@Column(name="TIMESTAMP", nullable=false)
	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Column(name="CURRENT", nullable=false)
	public Integer getCurrent() {
		return current;
	}

	public void setCurrent(Integer current) {
		this.current = current;
	}

	@Override
	public String toString() {
		return "Current [id=" + id + ", rfidTagId=" + rfidTagId + ", user="
				+ user + ", socket=" + socket + ", timestamp=" + timestamp
				+ ", current=" + current + "]";
	}
}
