package com.cerberus.module.account.workflows;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import com.cerberus.frameworks.logging.CerberusLogger;
import com.cerberus.model.account.bean.Login;
import com.cerberus.model.account.bean.PersonalInformation;
import com.cerberus.model.account.bean.User;
import com.cerberus.model.account.bean.UserType;
import com.cerberus.model.system.bean.CerberusSystem;
import com.cerberus.module.account.backingobjects.LoginBackingObject;
import com.cerberus.module.account.backingobjects.NewAccountBackingObject;
import com.cerberus.module.generic.workflows.Workflow;
import com.cerberus.service.account.UserService;

public class AccountWorkflow extends Workflow {

	public User createNewUser(NewAccountBackingObject newAccount, CerberusSystem system) {
		UserService userService = serviceFactory.getUserService();
		User user = new User();

		// Not setting any user setting to user (useless!)
		user.setSetting(null);

		// User type set to sys owner
		UserType sysOwner = userService.getUserTypeById(UserType.SYSTEM_OWNER_ID);
		user.setType(sysOwner);

		// User login info
		Login login = new Login();
		if(newAccount.getUsername() != null) { login.setUsername(newAccount.getUsername()); }
		if(newAccount.getPassword() != null) { login.setPasswordValue(newAccount.getPassword()); }

		long nowMillis = DateTime.now().getMillis();
		Date now = new Date(nowMillis);
		login.setCreatedDate(now);
		login.setLastUpdatedDate(now);
		// TODO: Remove this!
		login.setIsSysAdmin(1);

		login.setSystem(system);

		// Insert login
		userService.insertLogin(login);
		user.setLogin(login);

		// User personal info
		PersonalInformation info = new PersonalInformation();
		if(newAccount.getFirstname() != null) { info.setFirstName(newAccount.getFirstname()); }
		if(newAccount.getLastname() != null) { info.setLastName(newAccount.getLastname()); }

		// Insert personal info
		userService.insertPersonalInformation(info);
		user.setInformation(info);

		user.setCreatedDate(now);
		user.setLastUpdatedDate(now);

		// Insert user
		Integer userId = userService.insertUser(user);

		if(userId == null) return null;

		return user;
	}

	public Login getLoginInstance(LoginBackingObject loginBackingObject){
		return getLoginInstance(loginBackingObject.getUsername(), loginBackingObject.getPassword());
	}

	public boolean isUsernameUnique(String username) {
		if(username == null) return false;

		UserService userService = serviceFactory.getUserService();
		Login userLogin = userService.getLoginByUsername(username);

		if(userLogin != null && userLogin.getUsername().equals(username)) return false;

		return true;
	}

	public boolean isAccountValid(NewAccountBackingObject backingObject) {
		if(backingObject == null) return false;

		if(backingObject.getUsername() == null || backingObject.getUsername().equals("")) return false;
		if(backingObject.getPassword() == null || backingObject.getPassword().equals("")) return false;

		return true;
	}

	public Login getLoginInstance(String username, String password) {
		//Getting the User Service
		UserService userService = serviceFactory.getUserService();
		Login currentLogin = userService.getLoginByUsernameAndPassword(username, password);
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
