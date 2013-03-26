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
@Table(name = "ROOM")
public class Room implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	Integer id;
	RoomType roomType;
	String name;
	
	public Room(){	
		super();
	}
	
	public Room(String name, RoomType roomType) {
		super();
		this.name = name;
		this.roomType = roomType;
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

	@Override
	public String toString() {
		return "Room [id=" + id + ", roomType=" + roomType + ", name=" + name
				+ "]";
	}
	
	
	
}
