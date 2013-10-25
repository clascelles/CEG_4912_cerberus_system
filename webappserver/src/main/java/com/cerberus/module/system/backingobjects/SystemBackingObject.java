package com.cerberus.module.system.backingobjects;

import com.cerberus.model.outlets.bean.OutletOperationMode;
import com.cerberus.model.system.bean.CerberusSystem;
import com.cerberus.module.generic.backingobjects.BackingObject;

public class SystemBackingObject extends BackingObject<CerberusSystem> {

	private Integer id;
	private String name;
	private OutletOperationMode defaultOutletOperationMode;
	private Integer defaultOutletOperationModeId;
	private boolean spikeProtection;
	private boolean isSystemActive;
	private String encryptionKey;
	
	public SystemBackingObject() {}
	
	public SystemBackingObject(Integer id, String name, 
			OutletOperationMode defaultOutletOperationMode,
			Integer defaultOutletOperationModeId, boolean spikeProtection,
			boolean isSystemActive, String encryptionKey) {
		super();
		this.id = id;
		this.name = name;
		this.defaultOutletOperationMode = defaultOutletOperationMode;
		this.defaultOutletOperationModeId = defaultOutletOperationModeId;
		this.spikeProtection = spikeProtection;
		this.isSystemActive = isSystemActive;
		this.encryptionKey = encryptionKey;
	}
		
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public OutletOperationMode getDefaultOutletOperationMode() {
		return defaultOutletOperationMode;
	}
	public void setDefaultOutletOperationMode(
			OutletOperationMode defaultOutletOperationMode) {
		this.defaultOutletOperationMode = defaultOutletOperationMode;
		setDefaultOutletOperationModeId(defaultOutletOperationMode.getId());
	}
	public Integer getDefaultOutletOperationModeId() {
		return defaultOutletOperationModeId;
	}
	public void setDefaultOutletOperationModeId(Integer defaultOutletOperationModeId) {
		this.defaultOutletOperationModeId = defaultOutletOperationModeId;
	}
	public boolean isSpikeProtection() {
		return spikeProtection;
	}
	public void setSpikeProtection(boolean spikeProtection) {
		this.spikeProtection = spikeProtection;
	}
	public boolean isSystemActive() {
		return isSystemActive;
	}
	public void setSystemActive(boolean isSystemActive) {
		this.isSystemActive = isSystemActive;
	}
	public String getEncryptionKey() {
		return encryptionKey;
	}
	public void setEncryptionKey(String encryptionKey) {
		this.encryptionKey = encryptionKey;
	}
	
}
