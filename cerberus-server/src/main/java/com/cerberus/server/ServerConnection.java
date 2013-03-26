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
import com.cerberus.server.persistence.beans.Login;
import com.cerberus.server.persistence.beans.PersonalInformation;
import com.cerberus.server.persistence.beans.Room;
import com.cerberus.server.persistence.beans.User;
import com.cerberus.server.persistence.beans.UserSetting;
import com.cerberus.server.persistence.beans.UserType;
import com.cerberus.server.service.system.SystemService;
import com.cerberus.server.workflow.CurrentWorkflow;
import com.cerberus.server.workflow.UserWorkflow;

import com.cerberus.server.persistence.beans.ConnectionEvent;
import com.cerberus.server.persistence.beans.Event;
import com.cerberus.server.persistence.beans.Outlet;
import com.cerberus.server.persistence.beans.OutletOperationMode;
import com.cerberus.server.persistence.beans.RoomType;
import com.cerberus.server.persistence.beans.Socket;
import com.cerberus.server.persistence.beans.SocketAssignment;
import com.cerberus.server.persistence.beans.SocketOperationStatus;
import com.cerberus.server.workflow.OutletWorkflow;

public class ServerConnection {

	private final static String LOG_FILE = "Log.txt";

	//Get Logger
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public static void main (String[] args){

//		Date currentDate = new Date(new java.util.Date().getTime());
//		Login login = new Login("test", "pass", currentDate, (User) null, currentDate, (User) null);
//		UserSetting userSetting = new UserSetting(0,0);
//		PersonalInformation personalInformation = new PersonalInformation("David", "Vezina", "613-123-4567", "6257 Ravine Way");
//
//		UserWorkflow userWorkflow = new UserWorkflow();
//		UserType userType = userWorkflow.getUserTypeById(1);
//		User user = new User(userSetting, userType, login, personalInformation, currentDate, null, currentDate, null);
//
//		userWorkflow.insertUser(user);
		
		RoomType roomType = new RoomType("Kitchen");
		Room myKitchen = new Room("My Kitchen");
		
		OutletOperationMode enabledMode = new OutletOperationMode("Enabled");
		Outlet outlet = new Outlet(myKitchen, enabledMode, 12345);
		Event connectedEvent = new Event("Connected");
		SocketOperationStatus activeStatus = new SocketOperationStatus("Active");
		
		java.util.Date date= new java.util.Date();
		Timestamp ts = new Timestamp(date.getTime());
		ConnectionEvent conEvent = new ConnectionEvent(outlet, connectedEvent, ts);
		//Socket socket = new Socket(activeStatus, enabledMode, );
		//SocketAssignment assignment = new SocketAssignment();
		
		OutletWorkflow outletWorkflow = new OutletWorkflow();
		outletWorkflow.insertOutletOperationMode(enabledMode);
		outletWorkflow.insertEvent(connectedEvent);
		outletWorkflow.insertConnectionEvent(conEvent);
		outletWorkflow.insertSocketOperationStatus(activeStatus);
		//outletWorkflow.insertSocket(socket);
		//outletWorkflow.insertSocketAssignment(assignment);
		
		ServerLogger.setup(LOG_FILE);
		LOGGER.info("Server Started.");

		// Bootstrap the server.
		CerberusServerBootstrap bootstrap = new CerberusServerBootstrap();
		bootstrap.start();
	}
}
