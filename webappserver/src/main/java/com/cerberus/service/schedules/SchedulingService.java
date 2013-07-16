package com.cerberus.service.schedules;

import com.cerberus.model.outlets.bean.SocketOperationMode;
import com.cerberus.model.outlets.dao.SocketOperationModeDAO;

public class SchedulingService {
	private SocketOperationModeDAO socketOperationModeDAO;
	
	public SchedulingService(){
		socketOperationModeDAO = new SocketOperationModeDAO();
	}
	
	//***************************************************
	//Outlet
	//***************************************************
	
	public Integer insertSocketOperationMode(SocketOperationMode socketOperationMode){
		return socketOperationModeDAO.save(socketOperationMode);
	}
	
	public SocketOperationMode updateSocketOperationMode(SocketOperationMode socketOperationMode){
		return socketOperationModeDAO.merge(socketOperationMode);
	}
	
	public void deleteSocketOperationMode(SocketOperationMode socketOperationMode){
		socketOperationModeDAO.delete(socketOperationMode);
	}
}
