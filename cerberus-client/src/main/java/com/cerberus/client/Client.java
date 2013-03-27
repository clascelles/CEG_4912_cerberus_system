package com.cerberus.client;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Date;

public class Client extends Thread {

	public void run(){
		
		String sentence;
        String modifiedSentence;
        Socket clientSocket = null;
        
        Date startDate, stopDate;
        
        try{
        clientSocket = new Socket("localhost", 8080);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		while(true){
			startDate = new Date();
			
			sentence = "{ \"type\" : \"CURRENT\", \"socketId\" : 12345, \"timestamp\" : 1363702072, \"current\" : 3000, \"rfidNumber\" : 123456789}";
	        outToServer.writeBytes(sentence + '\n');
	
	        modifiedSentence = inFromServer.readLine();
	        stopDate = new Date();
	        
	        int interval = (int) (stopDate.getTime() - startDate.getTime());
	        
	        System.out.println("[Client] [Interval:" + interval + "] " + modifiedSentence);
	       
		}
		 
        }catch(Exception e){
        	e.printStackTrace();
        }
        
        //Close Connection
        try {
			clientSocket.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        
		
	}
}
