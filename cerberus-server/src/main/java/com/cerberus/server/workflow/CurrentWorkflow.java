package com.cerberus.server.workflow;

import java.sql.Timestamp;
import java.util.logging.Logger;

import com.cerberus.server.message.CurrentConsumptionMessage;
import com.cerberus.server.persistence.beans.Current;
import com.cerberus.server.service.pool.ServiceFactory;
import com.cerberus.server.service.pool.ServiceFactoryPool;

public class CurrentWorkflow extends Workflow {
	
	//Get Logger
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); 
		
	ServiceFactory serviceFactory;
	
	public CurrentWorkflow(){
		serviceFactory = borrowServiceFactory();
	}
	
	
	public boolean persistCurrentMessage(CurrentConsumptionMessage message){
		
		//Create new Current data structure
		Current current = new Current();
		
		current.setSocketId(message.getSocketId());
		current.setTimestamp(new Timestamp(message.getTimestamp().getMillis()));
		current.setCurrent(message.getCurrent());

		//Get UserID
		//TODO Get User ID from User Services
		
		//Get RFID Number ID
		//TODO Get RFID Number ID from RFID Services
		
		try{
			
			//Persist the Current object
			//TODO Persist the Current object from the Current Services
			
		}catch(Exception e){ //Catch if an exception occurs
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public void returnServiceFactory (){
		try {
			ServiceFactoryPool.returnServiceFactory(serviceFactory);
		} catch (Throwable e) {
			LOGGER.severe("ERROR Returning Service Factory");
			e.printStackTrace();
		}
	}
	
	

}
