package com.cerberus.model.account.bean;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cerberus.model.system.bean.CerberusSystem;


@Entity
@Table(name = "LOGIN")
public class Login implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	private String username;
	private String passwordValue;
	private CerberusSystem system;
	private Date createdDate;
	// private User createdUser;
	private Date lastUpdatedDate;

	// private User lastUpdatedUser;

	public Login(){
		super();
	}
	
	public Login(	String username, 
			String passwordValue,
			CerberusSystem system, 
			Date createdDate, 
			User createdUser, 
			Date lastUpdatedDate, 
			User lastUpdatedUser) {
		super();
		this.username = username;
		this.passwordValue = passwordValue;
		this.createdDate = createdDate;
		// this.createdUser = createdUser;
		this.lastUpdatedDate = lastUpdatedDate;
		// this.lastUpdatedUser = lastUpdatedUser;
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
	
	@Column(name="USERNAME", nullable=false)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="PASSWORD_VAL", nullable=false)
	public String getPasswordValue() {
		return passwordValue;
	}
	public void setPasswordValue(String passwordValue) {
		this.passwordValue = passwordValue;
	}
	
	@ManyToOne()
	@JoinColumn(name="SYSTEM_ID", nullable=false)
	public CerberusSystem getSystem() {
		return system;
	}

	public void setSystem(CerberusSystem system) {
		this.system = system;
	}
	
	@Column(name="CREATED_DATE", nullable=false)
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name="CREATED_USER_ID", nullable=false)
	// public User getCreatedUser() {
	// return createdUser;
	// }
	// public void setCreatedUser(User createdUser) {
	// this.createdUser = createdUser;
	// }
	
	@Column(name="LAST_UPDATED_DATE", nullable=false)
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	@Override
	public String toString() {
		return "Login [id=" + id + ", username=" + username + ", passwordValue=" + passwordValue + ", createdDate="
				+ createdDate + ", lastUpdatedDate=" + lastUpdatedDate + "]";
	}

	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name="LAST_UPDATED_USER_ID", nullable=false)
	// public User getLastUpdatedUser() {
	// return lastUpdatedUser;
	// }
	// public void setLastUpdatedUser(User lastUpdatedUser) {
	// this.lastUpdatedUser = lastUpdatedUser;
	// }
	
	
	
}
