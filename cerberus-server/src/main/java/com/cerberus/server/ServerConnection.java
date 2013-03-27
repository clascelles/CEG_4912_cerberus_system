package com.cerberus.server;

import com.cerberus.server.bootstrap.CerberusServerBootstrap;
import com.cerberus.server.persistence.HibernateUtil;

public class ServerConnection {

	public static void main (String[] args){

		//Initialize Hibernate
		HibernateUtil.getSessionFactory();
		
		// Bootstrap the server.
		CerberusServerBootstrap bootstrap = new CerberusServerBootstrap();
		bootstrap.start();
	}
}
