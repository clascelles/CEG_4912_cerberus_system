package com.cerberus.module.outlets.backingobjects;

import com.cerberus.model.account.bean.User;
import com.cerberus.model.outlets.bean.Current;
import com.cerberus.module.generic.backingobjects.BackingObjectFactory;

public class CurrentBackingObjectFactory extends BackingObjectFactory<Current, CurrentBackingObject> {
	
	public static CurrentBackingObjectFactory INSTANCE = new CurrentBackingObjectFactory();
		
	public OutletBackingObject getBackingObject(User user) {
		OutletBackingObject backingObject = new OutletBackingObject();
		return backingObject;
	}

	@Override
	public CurrentBackingObject getBackingObject(Current outlet) {
		CurrentBackingObject backingObject = new CurrentBackingObject();
		//TODO
		return backingObject;
	}

	@Override
	public Current bind(CurrentBackingObject backingObject, User user) {
		//Workflows workflows = CerberusApplicationContext.getWorkflows();
		
		//TODO
		
		return null;
	}
	
	public static CurrentBackingObject generateRandomCurrent(String time) {
		CurrentBackingObject backingObject = new CurrentBackingObject();
		
		backingObject.setTime(time);
		backingObject.setValue(getRandomInRange(0,5));
		
		return backingObject;
	}
	
	
	//Temporary helper
	public static String getRandomInRange(int max, int min) {
		return String.valueOf(min + (int)(Math.random() * ((max - min + 1))));
	}
	
}
