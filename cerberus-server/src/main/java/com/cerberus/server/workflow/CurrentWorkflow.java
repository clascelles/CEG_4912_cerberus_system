package com.cerberus.server.workflow;

import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Logger;

import com.cerberus.server.message.CurrentConsumptionMessage;
import com.cerberus.server.persistence.beans.Current;
import com.cerberus.server.persistence.beans.Login;
import com.cerberus.server.persistence.beans.RfidTag;
import com.cerberus.server.persistence.beans.Room;
import com.cerberus.server.persistence.beans.Socket;
import com.cerberus.server.persistence.beans.User;
import com.cerberus.server.persistence.filter.RfidTagFilter;
import com.cerberus.server.service.pool.ServiceFactory;
import com.cerberus.server.service.pool.ServiceFactoryPool;

public class CurrentWorkflow extends Workflow {

	// Get Logger
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	ServiceFactory serviceFactory;

	public CurrentWorkflow() {
		serviceFactory = borrowServiceFactory();
		LOGGER.info("[CurrentWorkflow]: Initializing. Borrowing Service Factory from ObjectPool");
	}

	public boolean persistCurrentMessage(CurrentConsumptionMessage message) {

		// Create new Current data structure
		Current current = new Current();

		current.setTimestamp(new Timestamp(message.getTimestamp()*1000));
		current.setCurrent(message.getCurrent());

		// Set Socket
		Socket socket = serviceFactory.getOutletService().getSocketBySerialNumber(message.getSocketId());
		current.setSocket(socket);
		
		// Set User
		User user = serviceFactory.getUserService().getUserBySocketId(socket.getId());
		current.setUser(user);

		// Set RFID Number
		RfidTag tag = serviceFactory.getRfidService().getRfidTagByNumber(RfidTagFilter.getRfidTagByNumber(message.getRfidNumber()));
		current.setRfidTagId(tag);

		try {

			// Persist the Current object
			serviceFactory.getConsumptionService().insertCurrent(current);
			LOGGER.info("Persisted CURRENT!");

		} catch (Exception e) { // Catch if an exception occurs
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public List<Room> getRooms(Integer roomTypeId) {
		return serviceFactory.getSystemService().getRoomByRoomTypeId(roomTypeId);
	}

	public void insertUser(User user) {
		serviceFactory.getUserService().insertUser(user);
	}

	public void insertLogin(Login login) {
		serviceFactory.getUserService().insertLogin(login);
	}

	@Override
	public void returnServiceFactory() {
		try {
			ServiceFactoryPool.returnServiceFactory(serviceFactory);
		} catch (Throwable e) {
			LOGGER.severe("ERROR Returning Service Factory");
			e.printStackTrace();
		}
	}

}
