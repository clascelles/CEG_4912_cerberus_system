package com.cerberus.service.system;

import com.cerberus.persistence.DAO.SocketOperationModeDAO;
import com.cerberus.persistence.beans.SocketOperationMode;

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
