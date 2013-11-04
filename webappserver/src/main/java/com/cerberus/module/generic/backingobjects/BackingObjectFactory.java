package com.cerberus.module.generic.backingobjects;

import java.util.ArrayList;
import java.util.List;

import com.cerberus.model.account.bean.User;

public abstract class BackingObjectFactory<T, S extends BackingObject<T>> {

	public List<S> getBackingObjects(List<T> list) {
		List<S> backingObjects = new ArrayList<S>();
		
		if(list != null) {	
			for(T item : list) {
				backingObjects.add(getBackingObject(item));
			}			
		}
		
		return backingObjects;
	}
	
	public abstract S getBackingObject(User user);
	
	public abstract S getBackingObject(T object);
	
	public abstract T bind(S backingObject, User user);
	
	public abstract boolean isValid(S backingObject);
	
}
