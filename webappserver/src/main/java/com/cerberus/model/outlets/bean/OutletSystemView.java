package com.cerberus.model.outlets.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OUTLET_SYSTEM_VIEW")
public class OutletSystemView implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer systemId;

	public OutletSystemView() {
		super();
	}

	public OutletSystemView(Integer id, Integer systemId) {
		super();
		this.id = id;
		this.systemId = systemId;
	}

	@Id
	@Column(name="OUTLET_ID", nullable=false, updatable=false, insertable=false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="SYSTEM_ID", nullable=false, updatable=false, insertable=false)
	public Integer getSystemId() {
		return systemId;
	}
	public void setSystemId(Integer id) {
		this.systemId = id;
	}

}
