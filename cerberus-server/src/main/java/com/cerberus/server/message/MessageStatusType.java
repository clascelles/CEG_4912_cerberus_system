package com.cerberus.server.message;

public enum MessageStatusType {
	NORMAL(0), STANDBY(1), DEFECTIVE(2);

	private final int statusType;

	private MessageStatusType(int statusType) {
		this.statusType = statusType;
	}

	public int getIntValue() {
		return statusType;
	}
}
