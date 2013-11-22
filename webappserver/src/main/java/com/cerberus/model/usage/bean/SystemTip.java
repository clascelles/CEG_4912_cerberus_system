package com.cerberus.model.usage.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SYSTEM_TIP")
public class SystemTip implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	Integer id;
	Integer systemId;
	Integer tipId;
	Timestamp timestamp;
	
	
	public SystemTip(){
		super();
	}
	
	public SystemTip(Integer systemId, Integer tipId) {
		super();
		this.systemId = systemId;
		this.tipId = tipId;
		this.timestamp = new Timestamp(new Date().getTime());
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

	@Column(name="SYSTEM_ID", nullable=false)
	public Integer getSystemId() {
		return systemId;
	}

	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}

	@Column(name="TIP_ID", nullable=false)
	public Integer getTipId() {
		return tipId;
	}

	public void setTipId(Integer tipId) {
		this.tipId = tipId;
	}

	@Column(name="TIMESTAMP", nullable=false)
	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
	
	
}
