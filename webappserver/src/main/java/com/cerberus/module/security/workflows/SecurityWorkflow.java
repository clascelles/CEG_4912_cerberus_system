package com.cerberus.module.security.workflows;

import java.util.ArrayList;
import java.util.List;

import com.cerberus.daemon.constants.SocketOperatingMode;
import com.cerberus.daemon.workflow.SwitchOperationModeWorkflow;
import com.cerberus.frameworks.spring.CerberusApplicationContext;
import com.cerberus.model.account.bean.Login;
import com.cerberus.model.account.bean.User;
import com.cerberus.model.outlets.bean.Outlet;
import com.cerberus.model.outlets.bean.OutletOperationMode;
import com.cerberus.model.outlets.bean.Socket;
import com.cerberus.model.outlets.bean.SocketAssignment;
import com.cerberus.model.outlets.bean.SocketOperationMode;
import com.cerberus.model.outlets.bean.SocketOperationStatus;
import com.cerberus.model.security.bean.RfidTag;
import com.cerberus.model.system.bean.CerberusSystem;
import com.cerberus.model.system.bean.Room;
import com.cerberus.module.generic.workflows.Workflow;
import com.cerberus.module.outlets.backingobjects.OutletBackingObject;
import com.cerberus.service.account.UserService;
import com.cerberus.service.outlets.OutletService;
import com.cerberus.service.system.SystemService;

public class SecurityWorkflow extends Workflow {

	public List<RfidTag> getRfidTagsFromSystem(CerberusSystem system) {
		SystemService systemService = serviceFactory.getSystemService();
		UserService userService = serviceFactory.getUserService();

		List<Login> logins = userService.getLoginsBySystemId(system.getId());

		//TODO: BAD! Why do we need to go through logins to get all users to finally get all rfid tags in the system!?
		//TODO: Investigate if we should create a database view instead...
		for(Login login : logins) {
			User loginUser = userService.getUserByLoginId(login.getId());
			//Get all rfidTags from all the RfidAuthentications associated with the user!
			// List<RfidAuthentication> rfidAuthentications =

		}

		return null;

	}


	public void insertOutlet(Outlet outlet) {
		serviceFactory.getOutletService().insertOutlet(outlet);
		this.returnServiceFactory();
	}

	public void updateOutlet(Outlet outlet) {
		serviceFactory.getOutletService().updateOutlet(outlet);
		this.returnServiceFactory();
	}

	public void updateOutletOperationMode(OutletBackingObject newOutlet) {
		Outlet outlet = getOutletById(newOutlet.getId());

		if(outlet != null) {
			if(outlet.getMode().getId() != newOutlet.getModeId()) {
				outlet.setMode(getOutletOperationModeById(newOutlet.getModeId()));
				updateOutlet(outlet);

				// Get message workflow
				SwitchOperationModeWorkflow messageWorkflow = CerberusApplicationContext.getWorkflows().getSwitchOperationModeWorkflow();

				// TODO: Remove hard-coded values!
				// Send two messages, one for each socket
				messageWorkflow.sendMessage(outlet.getSerialNumber(), 0, "F458C7AAE4",
						SocketOperatingMode.fromIntValue(newOutlet.getModeId()), 1);
				messageWorkflow.sendMessage(outlet.getSerialNumber(), 1, "F458C7AAE4",
						SocketOperatingMode.fromIntValue(newOutlet.getModeId()), 1);
			}
		}

	}

	public List<Outlet> getOutletFromUser(User user){

		OutletService outletService = serviceFactory.getOutletService();
		SystemService systemService = serviceFactory.getSystemService();
		CerberusSystem system = user.getLogin().getSystem();

		List<Outlet> outlets = new ArrayList<Outlet>();
		List<Room> rooms = systemService.getRooms(system.getId());

		for(Room room : rooms) {
			outlets.addAll(outletService.getOutletsByRoomId(room.getId()));
		}

		this.returnServiceFactory();

		return outlets;
	}

	public Outlet getOutletById(Integer id) {
		OutletService outletService = serviceFactory.getOutletService();
		Outlet outlet = outletService.getOutletById(id);

		this.returnServiceFactory();

		return outlet;
	}

	public List<Outlet> getOutletsByRoomId(Integer roomId) {
		OutletService outletService = serviceFactory.getOutletService();

		List<Outlet> outlets = outletService.getOutletsByRoomId(roomId);

		this.returnServiceFactory();

		return outlets;
	}

	public List<OutletOperationMode> getOutletOperationModes() {
		OutletService outletService = serviceFactory.getOutletService();
		List<OutletOperationMode> outletOperationModes = outletService.getOutletOperationModes();

		this.returnServiceFactory();

		return outletOperationModes;
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
		SocketOperationMode mode = outletService.getSocketOperationModeById(id);

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
