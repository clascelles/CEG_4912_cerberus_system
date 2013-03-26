package com.cerberus.server.persistence.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SOCKET_ASSIGNMENT")
public class SocketAssignment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Integer id;
	Socket socket;
	User user;
	
	public SocketAssignment() {
		super();
	}
	
	public SocketAssignment(Socket socket, User user) {
		super();
		this.socket = socket;
		this.user = user;
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

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="SOCKET_ID", nullable=false)
	public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="USER_ID", nullable=false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "SocketAssignment [id=" + id + ", socket=" + socket + ", user="
				+ user + "]";
	}	
	
}
