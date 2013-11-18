package com.cerberus.model.usage.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CURRENT_SYSTEM_VIEW")
public class CurrentSystemView implements Serializable{

	private static final long serialVersionUID = 1L;

	Integer currentId;
	Integer systemId;

	public CurrentSystemView() {
		super();
	}

	public CurrentSystemView(Integer currentId, Integer systemId) {
		this.currentId = currentId;
		this.systemId = systemId;
	}

	@Id
	public Integer getCurrentId() {
		return this.currentId;
	}

	public void setCurrentId(Integer currentId) {
		this.currentId = currentId;
	}

	@Column(name="SYSTEM_ID", nullable=false, updatable=false, insertable=false)
	public Integer getSystemId() {
		return this.systemId;
	}

	public void setSystemId(Integer systemId) {
		this.systemId = systemId;
	}

	@Override
	public String toString() {
		return "CurrentSystemView [currentId=" + currentId
				+ ", systemId=" + systemId + "]";
	}

}
