package com.cerberus.server.persistence.filter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.cerberus.server.persistence.beans.Room;

public class RoomFilter {

	public static DetachedCriteria getRoomByRoomTypeId(Integer roomTypeId){
		return DetachedCriteria.forClass(Room.class).
				add(Restrictions.eq("roomType.id", roomTypeId));
	}
	
}
