package com.cerberus.workflow.userResquestHandling;

import com.cerberus.backingobjects.LoginBackingObject;
import com.cerberus.persistence.beans.Login;
import com.cerberus.persistence.beans.User;
import com.cerberus.service.system.UserService;
import com.cerberus.workflow.Workflow;

public class AccountWorkflow extends Workflow {
	
	public Login getLoginInstance(LoginBackingObject loginBackingObject){
		//Getting the User Service
		UserService userService = serviceFactory.getUserService();
		Login currentLogin = userService.getLoginByUsernameAndPassword(loginBackingObject.getUsername(), loginBackingObject.getPassword());
		return currentLogin;
	}
	
	public User getUserByLogin(Login login){
		return serviceFactory.getUserService().getUserByLoginId(login.getId());
	}
	
	
	
	
}
