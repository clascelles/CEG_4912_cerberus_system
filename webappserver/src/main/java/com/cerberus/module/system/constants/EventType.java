package com.cerberus.module.system.constants;

public enum EventType {

	// Make sure to update this enum if updating the event database table!
	CONNECTION_ESTABLISHED(1),
	CONNECTION_LOST(2),
	NEW_OUTLET(3),
	SCHEDULED_EVENT_TRIGGERED(4),
	DEVICE_PLUGGED(5), //TODO: Not implemented
	DEVICE_UNPLUGGED(6), //TODO: Not implemented (probably never will be)
	NEW_RFID_TAG(7),
	RFID_TAG_ALLOWED(8),
	RFID_TAG_DENIED(9);

	private final Integer typeId;

	private EventType(Integer typeId) {
		this.typeId = typeId;
	}

	public Integer getId() {
		return typeId;
	}

	public static EventType fromIntValue(Integer typeId) {
		for (EventType type : EventType.values()) {
			if(type.getId() == typeId) {
				return type;
			}
		}
		return null;
	}

}
