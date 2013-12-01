package com.cerberus.model.system.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROOM_TYPE")
public class RoomType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final Integer FOYER = 1;
	public static final Integer FRONT_HALL = 2;
	public static final Integer LIVING_ROOM = 3;
	public static final Integer DINING_ROOM = 4;
	public static final Integer LAUNDRY_ROOM = 5;
	public static final Integer SITTING_ROOM = 6;
	public static final Integer KITCHEN = 7;
	public static final Integer STAIRWELL = 8;
	public static final Integer HALLWAY = 9;
	public static final Integer BATHROOM = 10;
	public static final Integer HALF_BATH = 11;
	public static final Integer ENSUITE_BATH = 12;
	public static final Integer MASTER_BEDROOM = 13;
	public static final Integer BEDROOM = 14;
	public static final Integer GUEST_BEDROOM = 15;
	public static final Integer BALCONY = 16;	
	public static final Integer OFFICE = 17;	
	public static final Integer BASEMENT = 18;	
	
	Integer id;
	String name;
	
	public RoomType(){
		super();
	}
	
	public RoomType(String name) {
		super();
		this.name = name;
	}
	
	public RoomType(Integer id) {
		super();
		this.id = id;
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
		return "RoomType [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
