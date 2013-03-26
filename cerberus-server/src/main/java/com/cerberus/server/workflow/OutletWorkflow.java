package com.cerberus.server.workflow;

import java.util.List;
import java.util.logging.Logger;

import com.cerberus.server.persistence.beans.ConnectionEvent;
import com.cerberus.server.persistence.beans.Event;
import com.cerberus.server.persistence.beans.Outlet;
import com.cerberus.server.persistence.beans.OutletOperationMode;
import com.cerberus.server.persistence.beans.Room;
import com.cerberus.server.persistence.beans.Socket;
import com.cerberus.server.persistence.beans.SocketAssignment;
import com.cerberus.server.persistence.beans.SocketOperationStatus;
import com.cerberus.server.persistence.beans.User;
import com.cerberus.server.service.pool.ServiceFactory;
import com.cerberus.server.service.pool.ServiceFactoryPool;

public class OutletWorkflow extends Workflow {
	
	//Get Logger
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); 
		
	ServiceFactory serviceFactory;
	
	public OutletWorkflow(){
		serviceFactory = borrowServiceFactory();
		LOGGER.info("[OutletWorkflow]: Initializing. Borrowing Service Factory from ObjectPool");
	}
	
	public void insertOutletOperationMode(OutletOperationMode outletOperationMode){
		serviceFactory.getOutletService().insertOutletOperationMode(outletOperationMode);
	}
	
	public void insertEvent(Event event){
		serviceFactory.getOutletService().insertEvent(event);
	}
	
	public void insertConnectionEvent(ConnectionEvent connectionEvent){
		serviceFactory.getOutletService().insertConnectionEvent(connectionEvent);
	}
	
	public void insertSocketOperationStatus(SocketOperationStatus socketOperationStatus){
		serviceFactory.getOutletService().insertSocketOperationStatus(socketOperationStatus);
	}
	
	public void insertOutlet(Outlet outlet){
		serviceFactory.getOutletService().insertOutlet(outlet);
	}	
	
	public void insertSocket(Socket socket){
		serviceFactory.getOutletService().insertSocket(socket);
	}
	
	public void insertSocketAssignment(SocketAssignment socketAssignment){
		serviceFactory.getOutletService().insertSocketAssignment(socketAssignment);
	}
	
	public List<Room> getRooms(Integer roomTypeId) {
		return serviceFactory.getSystemService().getRoomByRoomTypeId(roomTypeId);
	}
	
	public Socket getSocketById(Integer id) {
		return serviceFactory.getOutletService().getSocketBySocketId(id);
	}
	
	public Socket getSocketBySerialNumber(Integer serialNumber) {
		return serviceFactory.getOutletService().getSocketBySerialNumber(serialNumber);
	}
	
	public User getUserBySocketId(Integer socketId) {
		return serviceFactory.getOutletService().getSocketAssignmentBySocketId(socketId).getUser();
	}
	
	public void returnServiceFactory (){
		try {
			ServiceFactoryPool.returnServiceFactory(serviceFactory);
		} catch (Throwable e) {
			LOGGER.severe("ERROR Returning Service Factory");
			e.printStackTrace();
		}
	}

}
