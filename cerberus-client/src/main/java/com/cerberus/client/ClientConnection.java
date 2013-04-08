package com.cerberus.client;


import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class ClientConnection {

	private static final Logger LOGGER = Logger.getLogger(ClientConnection.class);

	public static void main(String[] args) throws UnknownHostException, IOException{

		// Configure client simulation using command line arguments if given
		ClientThreadConfigurator configurator = new ClientThreadConfigurator(args);

		ExecutorService clientPool = Executors.newFixedThreadPool(configurator.getNumberOfThreads());

		DOMConfigurator.configure(configurator.getLog4JXMLFilePath());
		LOGGER.info("Starting client simulation server. " + configurator.getNumberOfThreads()
				+ " client threads will run for " + configurator.getSimulationTime() / 1000 + " s.");

		Socket clientSocket;
		while(true) {
			try {
				LOGGER.info("Tyring to connect to the server " + configurator.getServerHost() + ":"
						+ configurator.getServerPort() + "...");
				clientSocket = new Socket(configurator.getServerHost(), configurator.getServerPort());
				if (clientSocket.isConnected()) {
					LOGGER.info("Successfully connected to the server!");
					clientSocket.close();
					break;
				}
			} catch (IOException e) {
				LOGGER.warn("Couldn't establish a connection to the server. Retrying in "
						+ configurator.getRetryTimeout() / 1000 + " s...");
				try {
					Thread.sleep(configurator.getRetryTimeout());
				} catch (InterruptedException e1) {
				}
			}
		}

		if (configurator.isFullBlastActivated()) {
			LOGGER.info("Clients will wait between 25 and 35 seconds randomly before sending messages.");
		} else {
			LOGGER.info("Clients will send as much messages as they can. FULL BLAST ON!!");
		}

		LOGGER.info("Starting all " + configurator.getNumberOfThreads() + " clients...");
		for (int i = 0; i < configurator.getNumberOfThreads(); i++) {
			clientPool.execute(new Client(i, configurator));
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
			}
		}
		LOGGER.info("All clients are running!");

		// Client threads will stop after they are finished with their current
		// client.
		clientPool.shutdown();
		try {
			boolean terminatedProperly = clientPool.awaitTermination(
					configurator.getSimulationTime() + configurator.getRetryTimeout(),
					TimeUnit.MILLISECONDS);
			if (terminatedProperly) {
				LOGGER.info("All client threads are done. Stopping the simulation now. See you next time! :)");
			} else {
				LOGGER.warn("The client threads have not closed properly. Something is sketchy here...");
			}
			Runtime.getRuntime().exit(0);
		} catch (InterruptedException e) {
			Runtime.getRuntime().exit(0);
		}
	}

}
