package com.cerberus.server.service.system;

import com.cerberus.server.persistence.DAO.ConnectionEventDAO;
import com.cerberus.server.persistence.DAO.EventDAO;
import com.cerberus.server.persistence.DAO.OutletDAO;

public class OutletService {

	private OutletDAO outletDAO;
	private ConnectionEventDAO connectionEventDAO;
	private EventDAO eventDAO;
	
	public OutletService(){
		outletDAO = new OutletDAO();
		connectionEventDAO = new ConnectionEventDAO();
		eventDAO = new EventDAO();
	}
	
//	public List<ConnectionEvent> getConnectionEventsByOutletId(Integer outletId){
//		return
//	}
}
