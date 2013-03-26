package com.cerberus.server.workflow;

import java.util.logging.Logger;

import com.cerberus.server.persistence.beans.*;
import com.cerberus.server.service.pool.ServiceFactory;
import com.cerberus.server.service.pool.ServiceFactoryPool;

public class UserWorkflow extends Workflow {
	
	//Get Logger
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME); 
		
	ServiceFactory serviceFactory;
	
	public UserWorkflow(){
		serviceFactory = borrowServiceFactory();
		LOGGER.info("[UserWorkflow]: Initializing. Borrowing Service Factory from ObjectPool");
	}
	
	
	public void insertUser(User user){
		serviceFactory.getUserService().insertUser(user);
	}
	
	public void insertLogin(Login login){
		serviceFactory.getUserService().insertLogin(login);
	}
	
	public void insertPersonalInformation(PersonalInformation personalInformation){
		serviceFactory.getUserService().insertPersonalInformation(personalInformation);
	}
	
	public void insertUserSetting(UserSetting userSetting){
		serviceFactory.getUserService().insertUserSetting(userSetting);
	}
	
	public UserType getUserTypeById(Integer userTypeId){
		return serviceFactory.getUserService().getUserTypeById(userTypeId);
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
