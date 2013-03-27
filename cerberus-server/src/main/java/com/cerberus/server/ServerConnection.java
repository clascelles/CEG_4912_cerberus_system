package com.cerberus.server;

import com.cerberus.server.bootstrap.CerberusServerBootstrap;

public class ServerConnection {

	public static void main (String[] args){

		// Bootstrap the server.
		CerberusServerBootstrap bootstrap = new CerberusServerBootstrap();
		bootstrap.start();
	}
}
