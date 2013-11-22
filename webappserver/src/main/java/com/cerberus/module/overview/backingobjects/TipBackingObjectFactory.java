package com.cerberus.module.overview.backingobjects;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import com.cerberus.model.account.bean.User;
import com.cerberus.model.usage.bean.SystemTip;
import com.cerberus.model.usage.bean.Tip;
import com.cerberus.module.generic.backingobjects.BackingObjectFactory;

public class TipBackingObjectFactory extends BackingObjectFactory<Tip, TipBackingObject> {

	public static TipBackingObjectFactory INSTANCE = new TipBackingObjectFactory();

	private static String TIMESTAMP_FORMAT = "dd/M/yyyy HH:mm:ss";

	@Override
	public TipBackingObject getBackingObject(User user) {
		return new TipBackingObject();
	}

	public TipBackingObject getBackingObject(Tip tip, SystemTip systemTip) {
		TipBackingObject backingObject = new TipBackingObject();
		
		DateTime tipTime = new DateTime(systemTip.getTimestamp().getTime());
		
		if(tipTime.plusDays(1).isAfterNow()){
			backingObject.setLevel(1);
		}else if(tipTime.plusDays(7).isAfterNow()){
			backingObject.setLevel(2);
		}else{
			backingObject.setLevel(3);
		}
		
		SimpleDateFormat timestampFormat = new SimpleDateFormat(TIMESTAMP_FORMAT);
		backingObject.setTimestamp(timestampFormat.format(systemTip.getTimestamp()));
		
		backingObject.setMessage(tip.getTipName());
		
		//Here we can add more description based on the tip rules.
		
		return backingObject;
	}

	@Override
	public Tip bind(TipBackingObject backingObject, User user) {
		return null;
	}

	@Override
	public boolean isValid(TipBackingObject backingObject) {
		return false;
	}

	@Override
	public TipBackingObject getBackingObject(Tip object) {
		return null;
	}
	
	
	public List<TipBackingObject> getBackingObjects(List<Tip> tips, List<SystemTip> systemTips) {
		List<TipBackingObject> backingObjects = new ArrayList<TipBackingObject>();
		
		if(tips != null && systemTips != null) {	
			for(int i=0; i<tips.size(); i++) {
				backingObjects.add(getBackingObject(tips.get(i), systemTips.get(i)));
			}			
		}
		
		return backingObjects;
	}

}
