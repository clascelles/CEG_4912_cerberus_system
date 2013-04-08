package com.cerberus.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import org.apache.log4j.Logger;
import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;

public class Client implements Runnable {

	private static final Logger LOGGER = Logger.getLogger(Client.class);

	private final int clientNumber;
	private final ClientDataGenerator dataGenerator;
	private final ClientThreadConfigurator configurator;

	public Client(int clientNumber, ClientThreadConfigurator configurator) {
		this.clientNumber = clientNumber;
		this.dataGenerator = new ClientDataGenerator();
		this.configurator = configurator;
	}

	@SuppressWarnings("resource")
	@Override
	public void run(){

		Socket clientSocket;
		DataOutputStream outToServer;
		BufferedReader inFromServer;
		String messageToSend;
		String messageReceived;

		StopWatch stopwatch;

		try {
			clientSocket = new Socket(configurator.getServerHost(), configurator.getServerPort());
			outToServer = new DataOutputStream(clientSocket.getOutputStream());
			inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		} catch (IOException e) {
			LOGGER.warn("[Client #" + clientNumber
					+ "] Couldn't establish a connection to the server. Closing...");
			return;
		}

		LOGGER.info("[Client #" + clientNumber + "] connected.");
		long timeLimit = configurator.getSimulationTime() + System.currentTimeMillis();
		while (System.currentTimeMillis() < timeLimit) {

			if (configurator.isFullBlastActivated()) {
				// Waits from 25 to 35 seconds before sending the next message
				try {
					Thread.sleep((int) (25000 + (Math.random() * 10000)));
				} catch (InterruptedException e1) {
					System.out.println("[Client #" + clientNumber + "] Client interrupted. Closing...");
					break;
				}
			}

			try {
				messageToSend = dataGenerator.createCurrentConsumptionJsonMessage();
				stopwatch = new Log4JStopWatch("Client.interval");

				outToServer.writeBytes(messageToSend);
				messageReceived = inFromServer.readLine();

				stopwatch.stop();
				LOGGER.debug("[Client #" + clientNumber + "] Received message: " + messageReceived);
			} catch (IOException e) {
				LOGGER.warn("[Client #" + clientNumber
						+ "] IOException while sending or receiving a message. Closing...");
				break;
			}

		}

        //Close Connection
        try {
			LOGGER.info("[Client #" + clientNumber + "] closing...");
			outToServer.close();
			LOGGER.info("[Client #" + clientNumber + "] closed.");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return;
	}

}
