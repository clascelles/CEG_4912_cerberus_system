package com.cerberus.server;

import java.sql.Date;
import java.sql.Timestamp;
//import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.SessionFactory;

import com.cerberus.server.bootstrap.CerberusServerBootstrap;
import com.cerberus.server.logging.ServerLogger;
import com.cerberus.server.persistence.HibernateUtil;
import com.cerberus.server.persistence.beans.System;
import com.cerberus.server.persistence.beans.Login;
import com.cerberus.server.persistence.beans.PersonalInformation;
import com.cerberus.server.persistence.beans.Room;
import com.cerberus.server.persistence.beans.User;
import com.cerberus.server.persistence.beans.UserSetting;
import com.cerberus.server.persistence.beans.UserType;
import com.cerberus.server.service.system.SystemService;
import com.cerberus.server.workflow.CurrentWorkflow;
import com.cerberus.server.workflow.RfidWorkflow;
import com.cerberus.server.workflow.SystemWorkflow;
import com.cerberus.server.workflow.UserWorkflow;

import com.cerberus.server.persistence.beans.ConnectionEvent;
import com.cerberus.server.persistence.beans.Event;
import com.cerberus.server.persistence.beans.Outlet;
import com.cerberus.server.persistence.beans.OutletOperationMode;
import com.cerberus.server.persistence.beans.RoomType;
import com.cerberus.server.persistence.beans.Socket;
import com.cerberus.server.persistence.beans.SocketAssignment;
import com.cerberus.server.persistence.beans.SocketOperationMode;
import com.cerberus.server.persistence.beans.SocketOperationStatus;
import com.cerberus.server.workflow.OutletWorkflow;

public class ServerConnection {

	private final static String LOG_FILE = "Log.txt";

	//Get Logger
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public static void main (String[] args){

		Date currentDate = new Date(new java.util.Date().getTime());
		Login login = new Login("test", "pass", currentDate, (User) null, currentDate, (User) null);
		UserSetting userSetting = new UserSetting(0,0);
		PersonalInformation personalInformation = new PersonalInformation("David", "Vezina", "613-123-4567", "6257 Ravine Way");

		UserWorkflow userWorkflow = new UserWorkflow();
		UserType userType = new UserType("Consumer");
		//UserType userType = userWorkflow.getUserTypeById(1);
		User user = new User(userSetting, userType, login, personalInformation, currentDate, null, currentDate, null);

		userWorkflow.insertUser(user);
		

		System system = new System(user, "my system");
		
		SystemWorkflow systemWorkflow = new SystemWorkflow();
		systemWorkflow.insertSystem(system);
		
		RoomType kitchen = new RoomType("Kitchen");
		Room myKitchen = new Room("My Kitchen", kitchen);
		
		OutletOperationMode enabledMode = new OutletOperationMode("Enabled");
		Outlet outlet = new Outlet(myKitchen, enabledMode, 12345, system);
		Event connectedEvent = new Event("Connected");
		SocketOperationStatus activeStatus = new SocketOperationStatus("Active");
		SocketOperationMode socketOpMode = new SocketOperationMode(enabledMode);
		
		java.util.Date date= new java.util.Date();
		Timestamp ts = new Timestamp(date.getTime());
		ConnectionEvent conEvent = new ConnectionEvent(outlet, connectedEvent, ts);

//		SystemWorkflow systemWorkflow = new SystemWorkflow();
		OutletWorkflow outletWorkflow = new OutletWorkflow();
		outletWorkflow.insertOutletOperationMode(enabledMode);
		outletWorkflow.insertEvent(connectedEvent);
		systemWorkflow.insertRoomType(kitchen);
		systemWorkflow.insertRoom(myKitchen);

		Socket socket = new Socket(activeStatus, socketOpMode, outlet);
		outletWorkflow.insertOutlet(outlet);
		outletWorkflow.insertConnectionEvent(conEvent);
		outletWorkflow.insertSocketOperationStatus(activeStatus);
		
		
		
		
		outletWorkflow.insertSocket(socket);

		SocketAssignment assignment = new SocketAssignment(socket, user);
		outletWorkflow.insertSocketAssignment(assignment);
		
		User fetchedUser = outletWorkflow.getUserBySocketId(socket.getId());
		
		
		ServerLogger.setup(LOG_FILE);
		LOGGER.info("Server Started.");		

		LOGGER.info("User ids for socket id" + socket.getId() + " : " + fetchedUser.getId());

//		RfidWorkflow rfidWorkflow = new RfidWorkflow();
//		rfidWorkflow.getRfidTagByNumber(new Long(123456789));
//		
//		System.out.println(rfidWorkflow.getRfidTagByNumber(new Long(123456789)));
		
		// Bootstrap the server.
		CerberusServerBootstrap bootstrap = new CerberusServerBootstrap();
		bootstrap.start();
	}
}
