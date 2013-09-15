package com.cerberus.module.account.workflows;

import java.util.ArrayList;
import java.util.List;

import com.cerberus.model.account.bean.Login;
import com.cerberus.model.account.bean.User;
import com.cerberus.model.system.bean.CerberusSystem;
import com.cerberus.model.system.bean.Room;
import com.cerberus.module.account.backingobjects.LoginBackingObject;
import com.cerberus.module.account.backingobjects.RoomBackingObject;
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
	
	public List<RoomBackingObject> getRoomsForUser(User user) {

		CerberusSystem system = systemService.getSystemByUserId(user.getId());
		
		List<Room> rooms = systemService.getRooms(system.getId());
		
		List<RoomBackingObject> backingObjects = new ArrayList<RoomBackingObject>();
		
		if(rooms != null){
			for(Room room : rooms){
				RoomBackingObject roomBO = new RoomBackingObject();
				roomBO.setName(room.getName());
				roomBO.setType(room.getRoomType());
				backingObjects.add(roomBO);
			}
		}
		
		return backingObjects;
	}
	
}
