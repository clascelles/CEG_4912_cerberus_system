package com.cerberus.server.workflow;

import java.sql.Timestamp;
import java.util.List;

import org.apache.log4j.Logger;
import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;

import com.cerberus.server.message.CurrentConsumptionMessage;
import com.cerberus.server.persistence.beans.Current;
import com.cerberus.server.persistence.beans.Login;
import com.cerberus.server.persistence.beans.RfidTag;
import com.cerberus.server.persistence.beans.Room;
import com.cerberus.server.persistence.beans.Socket;
import com.cerberus.server.persistence.beans.User;
import com.cerberus.server.service.pool.ServiceFactory;
import com.cerberus.server.service.pool.ServiceFactoryPool;

public class CurrentWorkflow extends Workflow {

	// Get Logger
	private final static Logger LOGGER = Logger.getLogger(CurrentWorkflow.class);

	ServiceFactory serviceFactory;

	public CurrentWorkflow() {
		serviceFactory = borrowServiceFactory();
		LOGGER.info("[CurrentWorkflow]: Initializing. Borrowing Service Factory from ObjectPool");
	}

	public boolean persistCurrentMessage(CurrentConsumptionMessage message) {

		StopWatch stopwatch = new Log4JStopWatch("CurrentWorkflow.persistCurrentMessage");
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

		// RFID is optional
		if (message.getRfidNumber() != null) {
			// Set RFID Number
			RfidTag tag = serviceFactory.getRfidService().getRfidTagByNumber(message.getRfidNumber());
			current.setRfidTagId(tag);
		} else {
			current.setRfidTagId(null);
		}


		try {

			// Persist the Current object
			serviceFactory.getConsumptionService().insertCurrent(current);
			LOGGER.info("Persisted CURRENT!");

		} catch (Exception e) { // Catch if an exception occurs
			e.printStackTrace();
			return false;
		} finally {
			stopwatch.stop();
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
			LOGGER.error("ERROR Returning Service Factory");
			e.printStackTrace();
		}
	}

}
