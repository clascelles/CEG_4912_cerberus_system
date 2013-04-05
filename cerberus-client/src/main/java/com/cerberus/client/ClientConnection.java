package com.cerberus.client;


import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ClientConnection {

	private static final Logger LOGGER = Logger.getLogger(ClientConnection.class);

	public static void main(String[] args) throws UnknownHostException, IOException{

		ExecutorService clientPool = Executors.newFixedThreadPool(ClientStaticConfiguration.CLIENTS);

		PropertyConfigurator.configure(ClientStaticConfiguration.LOG4J_PROPERTIES);
		LOGGER.info("Starting client simulation server.");

		Socket clientSocket;
		while(true) {
			try {
				clientSocket = new Socket(ClientStaticConfiguration.SERVER_HOST,
						ClientStaticConfiguration.SERVER_PORT);
				if (clientSocket.isConnected()) {
					clientSocket.close();
					break;
				}
			} catch (IOException e) {
				LOGGER.warn("Couldn't establish a connection to the server. Retrying in "
						+ ClientStaticConfiguration.RETRY_CONNECTING + " ms...");
				try {
					Thread.sleep(ClientStaticConfiguration.RETRY_CONNECTING);
				} catch (InterruptedException e1) {
				}
			}
		}

		if (ClientStaticConfiguration.WAIT_BEFORE_SENDING_NEXT_MESSAGE) {
			LOGGER.info("Clients will wait between 25 and 35 seconds randomly before sending messages.");
		} else {
			LOGGER.info("Clients will send as much messages as they can. FULL BLAST ON!!");
		}

		LOGGER.info("Starting all " + ClientStaticConfiguration.CLIENTS + " clients...");
		for (int i = 0; i < ClientStaticConfiguration.CLIENTS; i++) {
			clientPool.execute(new Client(i));
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
			}
		}
	}

}
