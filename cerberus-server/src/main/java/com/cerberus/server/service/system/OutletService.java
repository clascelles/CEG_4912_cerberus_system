package com.cerberus.server.service.system;

import com.cerberus.server.persistence.DAO.ConnectionEventDAO;
import com.cerberus.server.persistence.DAO.EventDAO;
import com.cerberus.server.persistence.DAO.OutletDAO;
import com.cerberus.server.persistence.DAO.OutletOperationModeDAO;
import com.cerberus.server.persistence.DAO.SocketAssignmentDAO;
import com.cerberus.server.persistence.DAO.SocketDAO;
import com.cerberus.server.persistence.DAO.SocketOperationStatusDAO;
import com.cerberus.server.persistence.beans.ConnectionEvent;
import com.cerberus.server.persistence.beans.Event;
import com.cerberus.server.persistence.beans.Outlet;
import com.cerberus.server.persistence.beans.OutletOperationMode;
import com.cerberus.server.persistence.beans.Socket;
import com.cerberus.server.persistence.beans.SocketAssignment;
import com.cerberus.server.persistence.beans.SocketOperationStatus;

public class OutletService {

	private OutletDAO outletDAO;
	private ConnectionEventDAO connectionEventDAO;
	private EventDAO eventDAO;
	private SocketOperationStatusDAO socketOperationStatusDAO;
	private SocketDAO socketDAO;
	private OutletOperationModeDAO outletOperationModeDAO;
	private SocketAssignmentDAO socketAssignmentDAO;
	
	public OutletService(){
		outletDAO = new OutletDAO();
		connectionEventDAO = new ConnectionEventDAO();
		eventDAO = new EventDAO();
		socketOperationStatusDAO = new SocketOperationStatusDAO();
		socketDAO = new SocketDAO();
		outletOperationModeDAO = new OutletOperationModeDAO();
		socketAssignmentDAO = new SocketAssignmentDAO();
	}
	
	//***************************************************
	//Outlet
	//***************************************************
	
	public void insertOutlet(Outlet outlet){
		outletDAO.save(outlet);
	}
	
	public Outlet updateOutlet(Outlet outlet){
		return outletDAO.merge(outlet);
	}
	
	public void deleteOutlet(Outlet outlet){
		outletDAO.delete(outlet);
	}
	
	//***************************************************
	//ConnectionEvent
	//***************************************************
	
	public void insertConnectionEvent(ConnectionEvent connectionEvent){
		connectionEventDAO.save(connectionEvent);
	}
	
	public ConnectionEvent updateConnectionEvent(ConnectionEvent connectionEvent){
		return connectionEventDAO.merge(connectionEvent);
	}
	
	public void deleteConnectionEvent(ConnectionEvent connectionEvent){
		connectionEventDAO.delete(connectionEvent);
	}
	
	//***************************************************
	//Event
	//***************************************************
	
	public void insertEvent(Event event){
		eventDAO.save(event);
	}
	
	public Event updateEvent(Event event){
		return eventDAO.merge(event);
	}
	
	public void deleteEvent(Event event){
		eventDAO.delete(event);
	}
	
	//***************************************************
	//SocketOperationStatus
	//***************************************************
	
	public void insertSocketOperationStatus(SocketOperationStatus socketOperationStatus){
		socketOperationStatusDAO.save(socketOperationStatus);
	}
	
	public SocketOperationStatus updateSocketOperationStatus(SocketOperationStatus socketOperationStatus){
		return socketOperationStatusDAO.merge(socketOperationStatus);
	}
	
	public void deleteSocketOperationStatus(SocketOperationStatus socketOperationStatus){
		socketOperationStatusDAO.delete(socketOperationStatus);
	}
	
	//***************************************************
	//Socket
	//***************************************************
	
	public void insertSocket(Socket socket){
		socketDAO.save(socket);
	}
	
	public Socket updateSocket(Socket socket){
		return socketDAO.merge(socket);
	}
	
	public void deleteSocket(Socket socket){
		socketDAO.delete(socket);
	}
	
	//***************************************************
	//OutletOperationMode
	//***************************************************
	
	public void insertOutletOperationMode(OutletOperationMode outletOperationMode){
		outletOperationModeDAO.save(outletOperationMode);
	}
	
	public OutletOperationMode updateOutletOperationMode(OutletOperationMode outletOperationMode){
		return outletOperationModeDAO.merge(outletOperationMode);
	}
	
	public void deleteOutletOperationMode(OutletOperationMode outletOperationMode){
		outletOperationModeDAO.delete(outletOperationMode);
	}
	
	//***************************************************
	//SocketAssignment
	//***************************************************
	
	public void insertSocketAssignment(SocketAssignment socketAssignment){
		socketAssignmentDAO.save(socketAssignment);
	}
	
	public SocketAssignment updateSocketAssignment(SocketAssignment socketAssignment){
		return socketAssignmentDAO.merge(socketAssignment);
	}
	
	public void deleteSocketAssignment(SocketAssignment socketAssignment){
		socketAssignmentDAO.delete(socketAssignment);
	}
	
//	public List<ConnectionEvent> getConnectionEventsByOutletId(Integer outletId){
//		return
//	}
}
