package com.cerberus.model.system.filter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.cerberus.model.system.bean.Room;

public class RoomFilter {

	public static DetachedCriteria getAll(){
		return DetachedCriteria.forClass(Room.class);
	}
	
	public static DetachedCriteria getBySystemId(Integer systemId){
		return DetachedCriteria.forClass(Room.class).
				add(Restrictions.eq("systemId", systemId));
	}
	
	public static DetachedCriteria getRoomByRoomTypeId(Integer roomTypeId){
		return DetachedCriteria.forClass(Room.class).
				add(Restrictions.eq("roomType.id", roomTypeId));
	}
	
}
