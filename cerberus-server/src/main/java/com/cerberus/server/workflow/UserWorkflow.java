package com.cerberus.server.workflow;

import org.apache.log4j.Logger;

import com.cerberus.server.persistence.beans.Login;
import com.cerberus.server.persistence.beans.PersonalInformation;
import com.cerberus.server.persistence.beans.User;
import com.cerberus.server.persistence.beans.UserSetting;
import com.cerberus.server.persistence.beans.UserType;
import com.cerberus.server.service.pool.ServiceFactory;
import com.cerberus.server.service.pool.ServiceFactoryPool;

public class UserWorkflow extends Workflow {

	//Get Logger
	private final static Logger LOGGER = Logger.getLogger(UserWorkflow.class);

	ServiceFactory serviceFactory;

	public UserWorkflow(){
		serviceFactory = borrowServiceFactory();
		LOGGER.info("[UserWorkflow]: Initializing. Borrowing Service Factory from ObjectPool");
	}

	public void insertUserType(UserType userType) {
		serviceFactory.getUserService().insertUserType(userType);
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
