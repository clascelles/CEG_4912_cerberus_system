package com.cerberus;

import com.cerberus.frameworks.hibernate.HibernateUtil;
import com.cerberus.frameworks.quartz.CerberusServerBootstrap;

public class ServerConnection {

	public static void main (String[] args){

		//Initialize Hibernate
		HibernateUtil.getSessionFactory();

		// Bootstrap the server.
		CerberusServerBootstrap bootstrap = new CerberusServerBootstrap();
		bootstrap.start();
	}
}
