package com.cerberus.service.outlets;

import java.util.List;

import com.cerberus.model.outlets.bean.Outlet;
import com.cerberus.model.outlets.bean.OutletOperationMode;
import com.cerberus.model.outlets.bean.Socket;
import com.cerberus.model.outlets.bean.SocketAssignment;
import com.cerberus.model.outlets.bean.SocketOperationStatus;
import com.cerberus.model.outlets.dao.OutletDAO;
import com.cerberus.model.outlets.dao.OutletOperationModeDAO;
import com.cerberus.model.outlets.dao.SocketAssignmentDAO;
import com.cerberus.model.outlets.dao.SocketDAO;
import com.cerberus.model.outlets.dao.SocketOperationStatusDAO;
import com.cerberus.model.outlets.filter.OutletFilter;
import com.cerberus.model.outlets.filter.OutletOperationModeFilter;
import com.cerberus.model.outlets.filter.SocketAssignmentFilter;
import com.cerberus.model.outlets.filter.SocketFilter;
import com.cerberus.model.usage.bean.ConnectionEvent;
import com.cerberus.model.usage.bean.Event;
import com.cerberus.model.usage.dao.ConnectionEventDAO;
import com.cerberus.model.usage.dao.EventDAO;

public class OutletService {

	private final OutletDAO outletDAO;
	private final ConnectionEventDAO connectionEventDAO;
	private final EventDAO eventDAO;
	private final SocketOperationStatusDAO socketOperationStatusDAO;
	private final SocketDAO socketDAO;
	private final OutletOperationModeDAO outletOperationModeDAO;
	private final SocketAssignmentDAO socketAssignmentDAO;
	
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
	
	public Integer insertOutlet(Outlet outlet){
		return outletDAO.save(outlet);
	}
	
	public Outlet updateOutlet(Outlet outlet){
		return outletDAO.merge(outlet);
	}
	
	public void deleteOutlet(Outlet outlet){
		outletDAO.delete(outlet);
	}
	
	public List<Outlet> getOutletListBySystemId(Integer systemId){
		return outletDAO.getAllByFilter(OutletFilter.getBySystemId(systemId));
	}
	
	//***************************************************
	//ConnectionEvent
	//***************************************************
	
	public Integer insertConnectionEvent(ConnectionEvent connectionEvent){
		return connectionEventDAO.save(connectionEvent);
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
	
	public Integer insertEvent(Event event){
		return eventDAO.save(event);
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
	
	public Integer insertSocketOperationStatus(SocketOperationStatus socketOperationStatus){
		return socketOperationStatusDAO.save(socketOperationStatus);
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
	
	public Integer insertSocket(Socket socket){
		return socketDAO.save(socket);
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
	
	public Integer insertOutletOperationMode(OutletOperationMode outletOperationMode){
		return outletOperationModeDAO.save(outletOperationMode);
	}
	
	public OutletOperationMode updateOutletOperationMode(OutletOperationMode outletOperationMode){
		return outletOperationModeDAO.merge(outletOperationMode);
	}
	
	public void deleteOutletOperationMode(OutletOperationMode outletOperationMode){
		outletOperationModeDAO.delete(outletOperationMode);
	}
	
	public OutletOperationMode getOutletOperationModeById(Integer id) {
		return outletOperationModeDAO.getByFilter(OutletOperationModeFilter.getById(id));
	}
	
	//***************************************************
	//SocketAssignment
	//***************************************************
	
	public Integer insertSocketAssignment(SocketAssignment socketAssignment){
		return socketAssignmentDAO.save(socketAssignment);
	}
	
	public SocketAssignment updateSocketAssignment(SocketAssignment socketAssignment){
		return socketAssignmentDAO.merge(socketAssignment);
	}
	
	public void deleteSocketAssignment(SocketAssignment socketAssignment){
		socketAssignmentDAO.delete(socketAssignment);
	}
	
	public Socket getSocketBySocketId(Integer socketId){
		return socketDAO.getByFilter(SocketFilter.getById(socketId));
	}
	
	public Socket getSocketBySerialNumber(Long serialNumber) {
		return socketDAO.getByFilter(SocketFilter.getBySerialNum(serialNumber));
	}
	
	public SocketAssignment getSocketAssignmentBySocketId(Integer socketId){
		return socketAssignmentDAO.getByFilter(SocketAssignmentFilter.getBySocketId(socketId));
	}

}
