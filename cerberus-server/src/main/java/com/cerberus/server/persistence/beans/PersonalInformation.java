package com.cerberus.server.persistence.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONAL_INFORMATION")
public class PersonalInformation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Integer id;
	String firstName;
	String lastName;
	String phoneNumber;
	String address;

	public PersonalInformation(){
		super();
	}
	
	public PersonalInformation(String firstName, String lastName, String phoneNumber, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
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
	
	@Column(name="FIRST_NAME", nullable=false)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name="LAST_NAME", nullable=false)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name="PHONE_NUMBER", nullable=true)
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Column(name="ADDRESS", nullable=true)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "PersonalInformation [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + "]";
	}
	
	
}
