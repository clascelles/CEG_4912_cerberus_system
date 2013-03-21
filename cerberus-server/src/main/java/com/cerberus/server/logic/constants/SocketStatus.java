package com.cerberus.server.logic.constants;

public enum SocketStatus {
	NORMAL(0), STANDBY(1), DEFECTIVE(2);

	private final int statusType;

	private SocketStatus(int statusType) {
		this.statusType = statusType;
	}

	public int getIntValue() {
		return statusType;
	}
}
