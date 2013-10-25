package com.cerberus.module.account.backingobjects;

import com.cerberus.model.account.bean.Login;
import com.cerberus.model.account.bean.PersonalInformation;
import com.cerberus.model.account.bean.User;
import com.cerberus.module.generic.backingobjects.BackingObjectFactory;

public class UserBackingObjectFactory extends BackingObjectFactory<User, UserBackingObject> {
	
	public static UserBackingObjectFactory INSTANCE = new UserBackingObjectFactory();

	@Override
	public UserBackingObject getBackingObject(User user) {
		UserBackingObject backingObject = new UserBackingObject();
		backingObject.setId(user.getId());
		backingObject.setSysAdmin(user.isSysAdmin());
		backingObject.setUsername(user.getLogin().getUsername());
		backingObject.setFirstName(user.getInformation().getFirstName());
		backingObject.setLastName(user.getInformation().getLastName());
		backingObject.setPhoneNumber(user.getInformation().getPhoneNumber());
		backingObject.setAddress(user.getInformation().getAddress());				
		return backingObject;
	}

	@Override
	public User bind(UserBackingObject backingObject, User user) {
		Login login = user.getLogin();
		if(backingObject.getUsername() != null) { login.setUsername(backingObject.getUsername()); }
		if(backingObject.getOldPassword() != null 
				&& backingObject.getNewPassword() != null)  {
				if(backingObject.getOldPassword().equals(login.getPasswordValue())) {
					if(backingObject.getNewPassword().equals(backingObject.getConfirmPassword())) {
						login.setPasswordValue(backingObject.getNewPassword());						
					} else {
						//TODO write a message to the user saying the new passwords don't match
					}
				} else {
					//TODO write a message to the user saying the old passwords don't match
				}				
		}
		
		PersonalInformation info = user.getInformation();
		if(backingObject.getFirstName() != null) { info.setFirstName(backingObject.getFirstName()); }
		if(backingObject.getLastName() != null) { info.setLastName(backingObject.getLastName()); }
		if(backingObject.getPhoneNumber() != null) { info.setPhoneNumber(backingObject.getPhoneNumber()); }
		if(backingObject.getAddress() != null) { info.setAddress(backingObject.getAddress()); }		
		
		return user;
	}

}
