package com.cerberus.server;

import com.cerberus.server.communication.CommunicationBootstrap;
import com.cerberus.server.service.executor.ExecutorServiceFactory;

public class ServerConnection {

	public static void main (String[] args){
		
		//Creates all the thread pools with default pool count of 10.
		ExecutorServiceFactory executorService = new ExecutorServiceFactory();
		
		CommunicationBootstrap communication = new CommunicationBootstrap();
		System.out.println("[Server]: Starting Communication Thread");
		communication.start();
	}
}
