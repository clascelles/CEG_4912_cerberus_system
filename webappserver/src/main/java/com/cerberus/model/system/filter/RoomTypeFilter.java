package com.cerberus.model.system.filter;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.cerberus.model.system.bean.RoomType;

public class RoomTypeFilter {

	public static DetachedCriteria getAll(){
		return DetachedCriteria.forClass(RoomType.class);
	}
	
	public static DetachedCriteria getById(Integer id){
		return DetachedCriteria.forClass(RoomType.class).
				add(Restrictions.eq("id", id));
	}
	
	public static DetachedCriteria getByName(String name){
		return DetachedCriteria.forClass(RoomType.class).
				add(Restrictions.eq("name", name));
	}
	
}
