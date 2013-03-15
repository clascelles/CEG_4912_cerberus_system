package com.cerberus.server;

import com.cerberus.server.communication.CommunicationBootstrap;

public class ServerConnection {

	public static void main (String[] args){
		
		CommunicationBootstrap communication = new CommunicationBootstrap();
		System.out.println("[Server]: Starting Communication Thread");
		communication.start();
	}
}
