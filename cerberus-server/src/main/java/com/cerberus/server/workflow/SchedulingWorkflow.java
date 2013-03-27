package com.cerberus.server.workflow;

import org.apache.log4j.Logger;

import com.cerberus.server.persistence.beans.SocketOperationMode;
import com.cerberus.server.service.pool.ServiceFactory;
import com.cerberus.server.service.pool.ServiceFactoryPool;

public class SchedulingWorkflow extends Workflow {

	//Get Logger
	private final static Logger LOGGER = Logger.getLogger(SchedulingWorkflow.class);

	ServiceFactory serviceFactory;

	public SchedulingWorkflow(){
		serviceFactory = borrowServiceFactory();
		LOGGER.info("[SchedulingWorkflow]: Initializing. Borrowing Service Factory from ObjectPool");
	}

	public void insertSocketOperationMode(SocketOperationMode socketOperationMode){
		serviceFactory.getSchedulingService().insertSocketOperationMode(socketOperationMode);
	}

	@Override
	public void returnServiceFactory (){
		try {
			ServiceFactoryPool.returnServiceFactory(serviceFactory);
		} catch (Throwable e) {
			LOGGER.error("ERROR Returning Service Factory");
			e.printStackTrace();
		}
	}

}
