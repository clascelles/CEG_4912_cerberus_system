package com.cerberus.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client extends Thread {

	private final int clientNumber;

	public Client(int clientNumber) {
		this.clientNumber = clientNumber;
	}

	@Override
	public void run(){

		Socket clientSocket;
		DataOutputStream outToServer;
		BufferedReader inFromServer;
		String messageToSend;
		String messageReceived;

		long startDate, stopDate;


		try {
			clientSocket = new Socket("localhost", 8080);
			outToServer = new DataOutputStream(clientSocket.getOutputStream());
			inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		} catch (IOException e) {
			System.out.println("[Client #" + clientNumber
					+ "] Couldn't establish a connection to the server. Closing...");
			e.printStackTrace();
			return;
		}

		while(true){

			try {
				// Waits from 5 to 30 seconds before sending the next message
				Thread.sleep((int) (5000 + (Math.random() * 25000)));
			} catch (InterruptedException e1) {
				System.out.println("[Client #" + clientNumber + "] Client interrupted. Closing...");
				e1.printStackTrace();
				break;
			}

			try {
				messageToSend = createCurrentConsumptionJsonMessage();
				startDate = System.currentTimeMillis();

				outToServer.writeBytes(messageToSend);
				messageReceived = inFromServer.readLine();

				stopDate = System.currentTimeMillis();
				int interval = (int) (stopDate - startDate);
				System.out.println("[Client #" + clientNumber + "] [Interval:" + interval + "] Received message: "
						+ messageReceived);
			} catch (IOException e) {
				System.out.println("[Client #" + clientNumber
						+ "] IOException while sending or receiving a message. Closing...");
				e.printStackTrace();
				break;
			}

		}

        //Close Connection
        try {
			clientSocket.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

	private String createCurrentConsumptionJsonMessage() {

		StringBuilder sb = new StringBuilder();
		sb.append("{\"type\":").append("\"CURRENT\"");
		sb.append(",\"socketId\":").append(ClientDataGenerator.getRandomSocketId());
		sb.append(",\"timestamp\":").append(System.currentTimeMillis()/1000);
		sb.append(",\"current\":").append(ClientDataGenerator.getRandomCurrentValue());
		sb.append(",\"rfidNumber\":").append("\"").append(ClientDataGenerator.getRandomRfidNumber()).append("\"");
		sb.append("}").append("\n");

		return sb.toString();
	}
}
