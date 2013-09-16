package com.cerberus.module.generic.workflows;

import org.apache.log4j.Logger;
import com.cerberus.service.pool.ServiceFactory;
import com.cerberus.service.pool.ServiceFactoryPool;
import com.cerberus.service.system.SystemService;

public abstract class Workflow {

	//Get Logger
	private final static Logger LOGGER = Logger.getLogger(Workflow.class);
	
	protected static ServiceFactory serviceFactory = borrowServiceFactory();	

	//Method used by the constructor to get the Service Factory
	protected static ServiceFactory borrowServiceFactory(){
		try {
			serviceFactory = ServiceFactoryPool.borrowServiceFactory();
		} catch (Throwable e) {
			LOGGER.error("ERROR Obtaining Service Factory");
			e.printStackTrace();
		}
		return serviceFactory;
	}

	// Method needs to be implemented by the workflows to return
	// the Service Factory
	public void returnServiceFactory() {
		try {
			ServiceFactoryPool.returnServiceFactory(serviceFactory);
		} catch (Throwable e) {
			LOGGER.error("ERROR Returning Service Factory");
			e.printStackTrace();
		}
		
	}

}
