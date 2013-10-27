package com.cerberus.model.security.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RFID_TAG")
public class RfidTag implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	Integer id;
	String number;
	String description;

	public RfidTag(){
		super();
	}

	public RfidTag(String number, String description) {
		super();
		this.number = number;
		this.description = description;
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

	@Column(name="NUMBER", nullable=false)
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Column(name="DESCRIPTION", nullable=false)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "RfidTag [id=" + id + ", number=" + number + ", description="
				+ description + "]";
	}


}
