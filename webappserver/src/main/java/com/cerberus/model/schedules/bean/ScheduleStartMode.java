package com.cerberus.model.schedules.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cerberus.model.outlets.bean.SocketOperationMode;

@Entity
@Table(name = "SCHEDULE_START_MODE")
public class ScheduleStartMode implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Integer id;
	SocketOperationMode mode;
	
	public ScheduleStartMode(){
		super();
	}
	
	public ScheduleStartMode(SocketOperationMode mode) {
		super();
		this.mode = mode;
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
	
	@OneToOne()
	@JoinColumn(name="SOCKET_OPERATION_MODE_ID", nullable=false)
	public SocketOperationMode getSocketOperationMode() {
		return mode;
	}
	public void setSocketOperationMode(SocketOperationMode mode) {
		this.mode = mode;
	}

	@Override
	public String toString() {
		return "ScheduleStartMode [id=" + id + ", mode=" + mode + "]";
	}
	
	
	
}
