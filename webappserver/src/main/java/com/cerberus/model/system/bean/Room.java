package com.cerberus.model.system.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ROOM")
public class Room implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	Integer id;
	RoomType roomType;
	String name;
	CerberusSystem system;
	
	public Room(){	
		super();
	}
	
	public Room(String name, RoomType roomType, CerberusSystem system) {
		super();
		this.name = name;
		this.roomType = roomType;
		this.system = system;
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
	
	@ManyToOne()
	@JoinColumn(name="ROOM_TYPE_ID")
	public RoomType getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	
	@Column(name="NAME", nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToOne()
	@JoinColumn(name="SYSTEM_ID", nullable=false)
	public CerberusSystem getSystem() {
		return system;
	}

	public void setSystem(CerberusSystem system) {
		this.system = system;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", roomType=" + roomType + ", name=" + name
				+ ", system = " + system.getId() + "]";
	}
	
	
	
}
