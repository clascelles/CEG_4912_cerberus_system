package com.cerberus.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientConnection {

	public static void main(String[] args) throws UnknownHostException, IOException{
		String sentence;
        String modifiedSentence;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        Socket clientSocket = new Socket("localhost", 8080);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // sentence = inFromUser.readLine();
		sentence = "{ \"type\" : \"CURRENT\", \"socketId\" : 12345, \"timestamp\" : 1363702072, \"current\" : 3000, \"rfidNumber\" : 1234567890}";
        outToServer.writeBytes(sentence + '\n');

        modifiedSentence = inFromServer.readLine();
        System.out.println("[Client]: " + modifiedSentence);
        clientSocket.close();
	}

}
