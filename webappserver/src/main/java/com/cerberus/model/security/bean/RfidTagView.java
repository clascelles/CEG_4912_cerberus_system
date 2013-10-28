package com.cerberus.model.security.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RFID_TAG_VIEW")
public class RfidTagView implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	Integer id;
	String number;
	String description;
	Integer user;
	Integer permission;


	public RfidTagView(){
		super();
	}

	public RfidTagView(Integer id, String number, String description, Integer user, Integer permission) {
		super();
		this.id = id;
		this.number = number;
		this.description = description;
		this.user = user;
		this.permission = permission;
	}

	@Id
	@Column(name="RFID_ID", nullable=false, updatable=false, insertable=false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="RFID_NUMBER", nullable=false, updatable=false, insertable=false)
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

	@Column(name="RFID_DESC", nullable=false, updatable=false, insertable=false)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="USER_ID", nullable=false, updatable=false, insertable=false)
	public Integer getUser() {
		return user;
	}
	public void setUser(Integer user) {
		this.user = user;
	}

	@Column(name="RFID_PERMISSION", nullable=false, updatable=false, insertable=false)
	public Integer getPermission() {
		return permission;
	}
	public void setPermission(Integer permission) {
		this.permission = permission;
	}

	@Override
	public String toString() {
		return "RfidTagView [id=" + id + ", number=" + number + ", description="
				+ description + ", owner=" + user + ", permission=" + permission + "]";
	}


}
