package com.cerberus.server.persistence.services;

import java.util.List;

//import com.cerberus.server.persistence.DAO.CurrentDAO;
import com.cerberus.server.persistence.DAO.GenericDAO;
import com.cerberus.server.persistence.beans.Current;
import com.cerberus.server.persistence.beans.RoomType;

public class CurrentServices {

	private GenericDAO dao = new GenericDAO();
	
	//public Current getById(Integer id){
	//	return dao.get(Current.class, id);
	//}
	
	public Current saveCurrent(Current current){
		return dao.save(current);
	}
	
	//public Integer countCurrent(Filter filter){
	//	return dao.count(new Search().addFilter(filter));
	//}
	
//	public List<Current> getAll(Filter filter){
//		return dao.search(new Search().addFilter(filter));
//	}
	
	
	public void insertRoomType(RoomType roomType){
		dao.save(roomType);
	}
	
	public void insertCurrent(Current current){
		dao.save(current);	
	}
	
}
