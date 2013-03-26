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
		
		
		ServerLogger.setup(LOG_FILE);
		LOGGER.info("Server Started.");

		// Bootstrap the server.
		CerberusServerBootstrap bootstrap = new CerberusServerBootstrap();
		bootstrap.start();
	}
}
