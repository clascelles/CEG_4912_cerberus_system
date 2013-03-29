package com.cerberus.client;


import java.io.IOException;
import java.net.UnknownHostException;

public class ClientConnection {

	public static final Integer CLIENTS = 100;

	public static void main(String[] args) throws UnknownHostException, IOException{

		for(int i=0; i<CLIENTS; i++){
			Client client = new Client(i);
			client.start();
		}

	}

}
