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

import com.cerberus.model.usage.bean.ConsumptionProfile;

@Entity
@Table(name = "RFID_TAG")
public class RfidTag implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	Integer id;
	ConsumptionProfile profile;
	String number;
	String tagName;

	public RfidTag(){
		super();
	}

	public RfidTag(String number, String tagName, ConsumptionProfile profile) {
		super();
		this.number = number;
		this.tagName = tagName;
		this.profile = profile;
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

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PROFILE_ID", nullable=false)
	public ConsumptionProfile getProfile() {
		return profile;
	}
	public void setProfile(ConsumptionProfile profile) {
		this.profile = profile;
	}

	@Column(name="NUMBER", nullable=false)
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

	@Column(name="TAG_NAME", nullable=false)
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	@Override
	public String toString() {
		return "RfidTag [id=" + id + ", number=" + number + ", description="
				+ tagName + "]";
	}


}
