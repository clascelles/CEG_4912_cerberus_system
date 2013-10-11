package com.cerberus.daemon.constants;

public enum MessageType {
	
	CURRENT(0), STATUS(1), RFID_AUTH_REQ(2), RFID_AUTH_RES(3), OP_MODE_SWITCH(4), GENERIC(5), INIT(6);
	
	private final int type;
	
	private MessageType(int type) {
		this.type = type;
	}
	
	public int getIntValue() {
		return this.type;
	}
	
	public static MessageType fromIntValue(int type) {
		for (MessageType messageType : MessageType.values()) {
			if (type == messageType.getIntValue()) {
				return messageType;
			}
		}
		return null;
	}
}
