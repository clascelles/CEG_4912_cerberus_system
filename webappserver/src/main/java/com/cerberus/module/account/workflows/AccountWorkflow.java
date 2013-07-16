package com.cerberus.module.account.workflows;

import com.cerberus.model.account.bean.Login;
import com.cerberus.model.account.bean.User;
import com.cerberus.module.account.backingobjects.LoginBackingObject;
import com.cerberus.module.generic.workflows.Workflow;
import com.cerberus.service.account.UserService;

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
