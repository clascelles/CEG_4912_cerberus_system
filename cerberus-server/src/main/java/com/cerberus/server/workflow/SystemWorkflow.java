package com.cerberus.server.workflow;

import org.apache.log4j.Logger;

import com.cerberus.server.persistence.beans.Room;
import com.cerberus.server.persistence.beans.RoomType;
import com.cerberus.server.persistence.beans.System;
import com.cerberus.server.service.pool.ServiceFactory;
import com.cerberus.server.service.pool.ServiceFactoryPool;

public class SystemWorkflow extends Workflow {

	//Get Logger
	private final static Logger LOGGER = Logger.getLogger(SystemWorkflow.class);

	ServiceFactory serviceFactory;

	public SystemWorkflow(){
		serviceFactory = borrowServiceFactory();
		LOGGER.info("[CurrentWorkflow]: Initializing. Borrowing Service Factory from ObjectPool");
	}

	public void insertRoomType(RoomType roomType){
		serviceFactory.getSystemService().insertRoomType(roomType);
	}

	public void insertRoom(Room room){
		serviceFactory.getSystemService().insertRoom(room);
	}

	public void insertSystem(System system){
		serviceFactory.getSystemService().insertSystem(system);
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
