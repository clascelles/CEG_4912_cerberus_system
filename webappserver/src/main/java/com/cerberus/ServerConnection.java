package com.cerberus;

import com.cerberus.bootstrap.CerberusServerBootstrap;
import com.cerberus.persistence.HibernateUtil;

public class ServerConnection {

	public static void main (String[] args){

		//Initialize Hibernate
		HibernateUtil.getSessionFactory();

		// Bootstrap the server.
		CerberusServerBootstrap bootstrap = new CerberusServerBootstrap();
		bootstrap.start();
	}
}
