package com.cerberus.model.system.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cerberus.model.outlets.bean.OutletOperationMode;

@Entity
@Table(name = "SYSTEM")
public class CerberusSystem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Integer id;
	String name;
	boolean systemActive;
	OutletOperationMode defaultOperationMode;
	boolean spikeProtection;
	String encryptionKey;	
	
	public CerberusSystem(){
		super();
	}
	
	public CerberusSystem(String name) {
		super();
		this.name = name;
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
	
	/*@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="USERS_ID", nullable=false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Column(name="USERS_ID", nullable=false, insertable=false, updatable=false)
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}*/
	
	@Column(name="NAME", nullable=true)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name="SYSTEM_ACTIVE", nullable=false)
	public boolean isSystemActive() {
		return systemActive;
	}

	public void setSystemActive(boolean systemActive) {
		this.systemActive = systemActive;
	}

	@ManyToOne()
	@JoinColumn(name="OUTLET_OPERATION_MODE_ID", nullable=false)
	public OutletOperationMode getDefaultOperationMode() {
		return defaultOperationMode;
	}

	public void setDefaultOperationMode(OutletOperationMode defaultOperationMode) {
		this.defaultOperationMode = defaultOperationMode;
	}

	@Column(name="SPIKE_PROTECTION", nullable=false)
	public boolean isSpikeProtection() {
		return spikeProtection;
	}

	public void setSpikeProtection(boolean spikeProtection) {
		this.spikeProtection = spikeProtection;
	}

	@Column(name="ENCRYPTION_KEY", nullable=false)
	public String getEncryptionKey() {
		return encryptionKey;
	}

	public void setEncryptionKey(String encryptionKey) {
		this.encryptionKey = encryptionKey;
	}

	@Override
	public String toString() {
		return "System [id=" + id 
				+ ", name=" + name 
				+ ", active=" + systemActive 
				+ ", defaultOperationMode=" + defaultOperationMode 
				+ ", spikeProtection=" + spikeProtection 
				+ ", encryptionKey=" + encryptionKey + "]";
	}
	
	
	
}
