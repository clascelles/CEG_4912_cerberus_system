package com.cerberus.module.system.constants;

public enum EventType {

	// Make sure to update this enum if updating the event database table!
	CONNECTION_OPENED(1),
	CONNECTION_CLOSED(2),
	CONNECTION_BINDED(3),
	INTERMITTENT_CONNECTION(4),
	CONNECTION_LOST(5);

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
