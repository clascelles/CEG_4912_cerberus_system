package com.cerberus.server.message;

public enum MessageType {
	RFID_AUTH_REQ(1), CURRENT(2), STATUS(3), RFID_AUTH_RES(4), OUTLET_PROFILE(5), GENERIC_INFO(6);

	private final int type;

	MessageType(int type) {
		this.type = type;
	}

	public int getIntValue() {
		return type;
	}

}