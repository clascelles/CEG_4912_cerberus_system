package com.cerberus.module.outlets.workflows;

import java.util.List;

import com.cerberus.model.account.bean.User;
import com.cerberus.module.generic.workflows.Workflow;
import com.cerberus.service.outlets.OutletService;
import com.cerberus.service.system.SystemService;
import com.cerberus.model.outlets.bean.Outlet;
import com.cerberus.model.outlets.bean.OutletOperationMode;
import com.cerberus.model.outlets.bean.Socket;
import com.cerberus.model.outlets.bean.SocketAssignment;
import com.cerberus.model.outlets.bean.SocketOperationMode;
import com.cerberus.model.outlets.bean.SocketOperationStatus;
import com.cerberus.model.system.bean.CerberusSystem;

public class OutletWorkflow extends Workflow {
	
	public void insertOutlet(Outlet outlet) {		
		serviceFactory.getOutletService().insertOutlet(outlet);		
	}
	
	public List<Outlet> getOutletFromUser(User user){
		
		SystemService systemService = serviceFactory.getSystemService();		
		OutletService outletService = serviceFactory.getOutletService();		
		CerberusSystem system = systemService.getSystemByUserId(user.getId());
		
		List<Outlet> outlets = outletService.getOutletListBySystemId(system.getId());
		
		this.returnServiceFactory();
		
		return outlets;	
	}
	
	public Outlet getOutletById(Integer id) {
		OutletService outletService = serviceFactory.getOutletService();
		Outlet outlet = outletService.getOutletById(id);
		
		this.returnServiceFactory();
		
		return outlet;
	}
	
	public OutletOperationMode getOutletOperationModeById(Integer id) {
		OutletService outletService = serviceFactory.getOutletService();
		OutletOperationMode outletOperationMode = outletService.getOutletOperationModeById(id);
		
		this.returnServiceFactory();
		
		return outletOperationMode;
	}
	
	public void insertSocket(Socket socket) {
		serviceFactory.getOutletService().insertSocket(socket);			
	}
	
	public List<Socket> getSocketsByOutlet(Outlet outlet) {
		OutletService outletService = serviceFactory.getOutletService();
		List<Socket> sockets = outletService.getSocketsByOutlet(outlet.getId());
		
		this.returnServiceFactory();
		
		return sockets;
	}
	
	public List<Socket> getAllSockets() {
		OutletService outletService = serviceFactory.getOutletService();
		List<Socket> sockets = outletService.getAllSockets();
		
		this.returnServiceFactory();
		
		return sockets;
	}
	
	public Socket getSocketById(Integer id) {
		OutletService outletService = serviceFactory.getOutletService();
		Socket socket = outletService.getSocketBySocketId(id);
		
		this.returnServiceFactory();
		
		return socket;
	}
	
	public SocketOperationMode getSocketModeById(Integer id) {
		OutletService outletService = serviceFactory.getOutletService();
		SocketOperationMode mode = outletService.getModeById(id);
		
		this.returnServiceFactory();
		
		return mode;
	}
	
	public SocketOperationStatus getSocketStatusById(Integer id) {
		OutletService outletService = serviceFactory.getOutletService();
		SocketOperationStatus status = outletService.getStatusById(id);
		
		this.returnServiceFactory();
		
		return status;
	}
	
	public SocketAssignment getSocketAssignmentBySocketId(Integer id) {
		OutletService outletService = serviceFactory.getOutletService();
		SocketAssignment assignment = outletService.getSocketAssignmentBySocketId(id);
		
		this.returnServiceFactory();
		
		return assignment;
	}
}
