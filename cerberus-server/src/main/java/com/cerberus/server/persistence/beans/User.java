package com.cerberus.server.persistence.beans;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private UserSetting setting;
	private UserType type;
	private Login login;
	private PersonalInformation information;
	private Date createdDate;
	private User createdUser;
	private Date lastUpdatedDate;
	private User lastUpdatedUser;
	
	public User(){
		super();
	}
	
	public User(	UserSetting setting, 
					UserType type, 
					Login login, 
					PersonalInformation information,
					Date createdDate,
					User createdUser,
					Date lastUpdatedDate,
					User lastUpdatedUser) {
		super();
		this.setting = setting;
		this.type = type;
		this.login = login;
		this.information = information;
		this.createdDate = createdDate;
		this.createdUser = createdUser;
		this.lastUpdatedDate = lastUpdatedDate;
		this.lastUpdatedUser = lastUpdatedUser;
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

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="USER_SETTING_ID")
	public UserSetting getSetting() {
		return setting;
	}
	public void setSetting(UserSetting setting) {
		this.setting = setting;
	}

	@OneToOne()
	@JoinColumn(name="USER_TYPE_ID", nullable=false)
	public UserType getType() {
		return type;
	}
	public void setType(UserType type) {
		this.type = type;
	}

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="LOGIN_ID")
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="PERSONAL_INFORMATION_ID")
	public PersonalInformation getInformation() {
		return information;
	}
	public void setInformation(PersonalInformation information) {
		this.information = information;
	}
	
	@Column(name="CREATED_DATE", nullable=false)
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="CREATED_USER_ID", nullable=true)
	public User getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(User createdUser) {
		this.createdUser = createdUser;
	}
	
	@Column(name="LAST_UPDATED_DATE", nullable=false)
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="LAST_UPDATED_USER_ID", nullable=true)
	public User getLastUpdatedUser() {
		return lastUpdatedUser;
	}
	public void setLastUpdatedUser(User lastUpdatedUser) {
		this.lastUpdatedUser = lastUpdatedUser;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", setting=" + setting + ", type=" + type
				+ ", login=" + login + ", information=" + information
				+ ", createdDate=" + createdDate + ", createdUser="
				+ createdUser + ", lastUpdatedDate=" + lastUpdatedDate
				+ ", lastUpdatedUser=" + lastUpdatedUser + "]";
	}	
	
	
	
}
