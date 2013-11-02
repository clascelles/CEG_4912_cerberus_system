package com.cerberus.model.security.bean;

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

import com.cerberus.model.account.bean.User;

@Entity
@Table(name = "RFID_AUTHENTICATION")
public class RfidAuthentication implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	Integer id;
	Integer rfidTagId;
	User owner;
	Integer permission;

	public RfidAuthentication(){
		super();
	}

	public RfidAuthentication(Integer rfidTagId, User owner, Integer permission) {
		super();
		this.rfidTagId = rfidTagId;
		this.owner = owner;
		this.permission = permission;
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

	@Column(name="RFID_TAG_ID", nullable=false)
	public Integer getRfidTagId() {
		return rfidTagId;
	}
	public void setRfidTagId(Integer rfidTagId) {
		this.rfidTagId = rfidTagId;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USERS_ID", nullable=false)
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}

	@Column(name="PERMISSION", nullable=false)
	public Integer getPermission() {
		return permission;
	}
	public void setPermission(Integer permission) {
		this.permission = permission;
	}

	@Override
	public String toString() {
		return "RfidAuthentication [id=" + id + ", rfidTagId=" + rfidTagId
				+ ", owner=" + owner + ", permission=" + permission + "]";
	}


}
