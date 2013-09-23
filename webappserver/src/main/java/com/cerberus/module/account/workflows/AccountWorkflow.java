package com.cerberus.module.account.workflows;

import com.cerberus.message.CerberusLogger;
import com.cerberus.model.account.bean.Login;
import com.cerberus.model.account.bean.PersonalInformation;
import com.cerberus.model.account.bean.User;
import com.cerberus.module.account.backingobjects.LoginBackingObject;
import com.cerberus.module.generic.workflows.Workflow;
import com.cerberus.service.account.UserService;

public class AccountWorkflow extends Workflow {
	
	public Login getLoginInstance(LoginBackingObject loginBackingObject){
		//Getting the User Service
		UserService userService = serviceFactory.getUserService();
		Login currentLogin = userService.getLoginByUsernameAndPassword(loginBackingObject.getUsername(), loginBackingObject.getPassword());		
		this.returnServiceFactory();
		return currentLogin;
	}
	
	public User getUserByLogin(Login login){
		User user = serviceFactory.getUserService().getUserByLoginId(login.getId());
		this.returnServiceFactory();
		return user;
	}
	
	public void updateLogin(Login login) {
		CerberusLogger.update(login.toString());
		UserService userService = serviceFactory.getUserService();
		userService.updateLogin(login);			
		this.returnServiceFactory();
	}
	
	public void updatePersonalInformation(PersonalInformation info) {
		CerberusLogger.update(info.toString());
		UserService userService = serviceFactory.getUserService();
		userService.updatePersonalInformation(info);			
		this.returnServiceFactory();
	}	
}
