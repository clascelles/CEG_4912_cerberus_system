package com.cerberus.daemon.constants;

public enum SocketStatus {
	NORMAL(0), STANDBY(1), DEFECTIVE(2);

	private final int statusType;

	private SocketStatus(int statusType) {
		this.statusType = statusType;
	}

	public int getIntValue() {
		return statusType;
	}

	public static SocketStatus fromIntValue(int statusValue) {
		for (SocketStatus status : SocketStatus.values()) {
			if (statusValue == status.getIntValue()) {
				return status;
			}
		}
		return null;
	}
}
