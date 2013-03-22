package com.cerberus.server.workflow;

import java.util.logging.Logger;

import com.cerberus.server.service.pool.ServiceFactory;
import com.cerberus.server.service.pool.ServiceFactoryPool;

public abstract class Workflow {

	//Get Logger
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); 
	
	//Method used by the constructor to get the Service Factory
	protected ServiceFactory borrowServiceFactory(){
		ServiceFactory serviceFactory = null;
		try {
			serviceFactory = ServiceFactoryPool.borrowServiceFactory();
		} catch (Throwable e) {
			LOGGER.severe("ERROR Obtaining Service Factory");
			e.printStackTrace();
		}
		return serviceFactory;
	}
	
	//Methods needed to be implemented by the workflows to return the Service Factory
	public abstract void returnServiceFactory();
	
	
}
