package com.cerberus.model.outlets.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OUTLET_OPERATION_MODE")
public class OutletOperationMode implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final Integer ENABLED = 1;
	public static final Integer DISABLED = 2;
	public static final Integer MONITORING = 3;
	public static final Integer CHILD_SAFETY = 4;
	public static final Integer AUTHENTICATION = 5;	
	
	Integer id;
	String name;
		
	public OutletOperationMode() {
		super();
	}
	public OutletOperationMode(String name) {
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
	
	@Column(name="NAME", nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "OutletOperationMode [id=" + id + ", name=" + name + "]";
	}	
}
