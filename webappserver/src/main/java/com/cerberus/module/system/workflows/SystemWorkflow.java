package com.cerberus.module.system.workflows;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.cerberus.model.account.bean.User;
import com.cerberus.model.outlets.bean.OutletOperationMode;
import com.cerberus.model.outlets.dao.OutletOperationModeDAO;
import com.cerberus.model.system.bean.CerberusSystem;
import com.cerberus.model.system.bean.Room;
import com.cerberus.model.system.bean.RoomType;
import com.cerberus.module.account.backingobjects.RoomBackingObject;
import com.cerberus.module.account.backingobjects.RoomBackingObjectFactory;
import com.cerberus.module.generic.workflows.Workflow;
import com.cerberus.service.outlets.OutletService;
import com.cerberus.service.system.SystemService;

public class SystemWorkflow extends Workflow {

	public CerberusSystem createNewSystem(String ownerFirstName) {
		SystemService systemService = serviceFactory.getSystemService();

		OutletOperationModeDAO oomDao = new OutletOperationModeDAO();
		CerberusSystem system = new CerberusSystem(ownerFirstName + "'s System");
		system.setSystemActive(true);
		system.setSpikeProtection(true);
		system.setDefaultOperationMode(oomDao.getById(OutletOperationMode.MONITORING));

		// Generate random envryption key (16 chars)
		String encryptionKey = UUID.randomUUID().toString();
		encryptionKey = encryptionKey.replaceAll("-", "");
		String shortKey = encryptionKey.substring(0, 16);
		system.setEncryptionKey(shortKey);

		// Commit system to database
		Integer systemId = systemService.insertSystem(system);

		if(systemId == null) return null;

		return system;
	}


	public List<RoomBackingObject> getRoomBackingObjects(User user) {

		SystemService systemService = serviceFactory.getSystemService();

		CerberusSystem system = user.getLogin().getSystem();

		List<Room> rooms = systemService.getRooms(system.getId());

		List<RoomBackingObject> backingObjects = new ArrayList<RoomBackingObject>();

		if(rooms != null){
			for(Room room : rooms){
				backingObjects.add(RoomBackingObjectFactory.getBackingObject(room));
			}
		}

		this.returnServiceFactory();

		return backingObjects;
	}

	public List<Room> getRooms(Integer systemId) {
		SystemService systemService = serviceFactory.getSystemService();

		List<Room> rooms = systemService.getRooms(systemId);

		this.returnServiceFactory();

		return rooms;
	}

	public Room getRoomById(Integer id) {
		SystemService systemService = serviceFactory.getSystemService();

		Room room = systemService.getRoomById(id);

		this.returnServiceFactory();

		return room;
	}

	public List<Room> getRoomsByRoomTypeId(Integer id) {
		SystemService systemService = serviceFactory.getSystemService();

		List<Room> rooms = systemService.getRoomByRoomTypeId(id);

		this.returnServiceFactory();

		return rooms;
	}

	public RoomType getRoomTypeById(Integer id) {
		SystemService systemService = serviceFactory.getSystemService();

		RoomType roomType = systemService.getRoomTypeById(id);

		this.returnServiceFactory();

		return roomType;
	}

	public CerberusSystem getSystemById(Integer id) {
		SystemService systemService = serviceFactory.getSystemService();

		CerberusSystem system = systemService.getSystemById(id);

		this.returnServiceFactory();

		return system;
	}

	public void updateSystem(CerberusSystem system) {
		SystemService systemService = serviceFactory.getSystemService();

		systemService.updateSystem(system);

		this.returnServiceFactory();
	}

	public byte[] getEncryptionKeyForOutlet(Integer outletId){
		OutletService outletService = serviceFactory.getOutletService();
		SystemService systemService = serviceFactory.getSystemService();

		Integer systemId = outletService.getSystemIdFromOutlet(outletId);
		CerberusSystem system = systemService.getSystemById(systemId);

		byte[] encryptionKey = new byte[16];
		encryptionKey = system.getEncryptionKey().getBytes();
		return encryptionKey;

	}

}
