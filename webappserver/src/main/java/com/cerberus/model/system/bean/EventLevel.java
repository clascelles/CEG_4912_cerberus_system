package com.cerberus.model.system.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EVENT_LEVEL")
public class EventLevel implements Serializable{

	public Integer INFO = 1;
	public Integer ANNOUNCEMENT = 2;
	public Integer WARNING = 3;
	public Integer ERROR = 4;
	public Integer DEBUG = 5;

	private static final long serialVersionUID = 1L;

	Integer id;
	String level;

	public EventLevel() {
		super();
	}
	public EventLevel(String level) {
		super();
		this.level = level;
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

	@Column(name="EVENT_LEVEL", nullable=false)
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "EventLevel [id=" + id + ", level=" + level + "]";
	}
}
