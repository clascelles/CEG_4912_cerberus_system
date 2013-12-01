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


	public void addDefaultRoomsToSystem(CerberusSystem system){
		List<Room> rooms = new ArrayList<Room>(10);
		rooms.add(new Room("Foyer", new RoomType(RoomType.FOYER), system));
		rooms.add(new Room("Front Hall", new RoomType(RoomType.FRONT_HALL), system));
		rooms.add(new Room("Living Room", new RoomType(RoomType.LIVING_ROOM), system));
		rooms.add(new Room("Dining Room", new RoomType(RoomType.DINING_ROOM), system));
		rooms.add(new Room("Laundry Room", new RoomType(RoomType.LAUNDRY_ROOM), system));
		rooms.add(new Room("Sitting Room", new RoomType(RoomType.SITTING_ROOM), system));
		rooms.add(new Room("Kitchen", new RoomType(RoomType.KITCHEN), system));
		rooms.add(new Room("Stairwell", new RoomType(RoomType.STAIRWELL), system));
		rooms.add(new Room("Hallway", new RoomType(RoomType.HALLWAY), system));
		rooms.add(new Room("Bathroom", new RoomType(RoomType.BATHROOM), system));
		rooms.add(new Room("Half Bath", new RoomType(RoomType.HALF_BATH), system));
		rooms.add(new Room("Ensuite Bathroom", new RoomType(RoomType.ENSUITE_BATH), system));
		rooms.add(new Room("Master Bedroom", new RoomType(RoomType.MASTER_BEDROOM), system));
		rooms.add(new Room("Bedroom", new RoomType(RoomType.BEDROOM), system));
		rooms.add(new Room("Guest Bedroom", new RoomType(RoomType.GUEST_BEDROOM), system));
		rooms.add(new Room("Balcony", new RoomType(RoomType.BALCONY), system));
		rooms.add(new Room("Office", new RoomType(RoomType.OFFICE), system));
		rooms.add(new Room("Basement", new RoomType(RoomType.BASEMENT), system));
		
		SystemService systemService = serviceFactory.getSystemService();
		for(Room room: rooms){
			systemService.insertRoom(room);
		}

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
