package com.cerberus.server;

import java.util.logging.Logger;

import org.hibernate.SessionFactory;

import com.cerberus.server.bootstrap.CerberusServerBootstrap;
import com.cerberus.server.logging.ServerLogger;
import com.cerberus.server.persistence.HibernateUtil;

public class ServerConnection {

	//Get Logger
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public static void main (String[] args){

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		//Setup the logging functions and formatting
		ServerLogger.setup("Log.txt");
		LOGGER.info("Server Started.");

		// Bootstrap the server.
		CerberusServerBootstrap bootstrap = new CerberusServerBootstrap();
		bootstrap.start();
	}
}
