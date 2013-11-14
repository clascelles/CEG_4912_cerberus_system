package com.cerberus.model.system.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EVENT")
public class Event implements Serializable{

	private static final long serialVersionUID = 1L;

	Integer id;
	Integer eventLevel;
	String name;
	String message;

	public Event() {
		super();
	}
	public Event(String name) {
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

	@Column(name="EVENT_LEVEL_ID", nullable=false)
	public Integer getEventLevel() {
		return eventLevel;
	}
	public void setEventLevel(Integer eventLevel) {
		this.eventLevel = eventLevel;
	}

	@Column(name="EVENT_NAME", nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name="EVENT_MESSAGE", nullable=false)
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", message="
				+ message + "]";
	}
}
