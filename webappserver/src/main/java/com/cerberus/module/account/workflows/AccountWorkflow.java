package com.cerberus.module.account.workflows;

import java.util.ArrayList;
import java.util.List;

import com.cerberus.frameworks.logging.CerberusLogger;
import com.cerberus.model.account.bean.Login;
import com.cerberus.model.account.bean.PersonalInformation;
import com.cerberus.model.account.bean.User;
import com.cerberus.model.system.bean.CerberusSystem;
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

	public User resetUserPassword(User user) {
		CerberusLogger.resetPasswordMessage(user.getId().toString());
		user.getLogin().setPasswordValue(user.getLogin().getUsername());
		return user;
	}

	public User getUserById(Integer userId) {
		User user = serviceFactory.getUserService().getUserById(userId);
		this.returnServiceFactory();
		return user;
	}

	public User getUserByLogin(Login login){
		User user = serviceFactory.getUserService().getUserByLoginId(login.getId());
		this.returnServiceFactory();
		return user;
	}

	public List<User> getUsersForSystem(CerberusSystem system) {
		UserService userService = serviceFactory.getUserService();
		List<User> users = new ArrayList<User>();
		List<Login> logins = serviceFactory.getUserService().getLoginsBySystemId(system.getId());
		for(Login login : logins) {
			users.add(userService.getUserByLoginId(login.getId()));
		}
		this.returnServiceFactory();
		return users;
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
