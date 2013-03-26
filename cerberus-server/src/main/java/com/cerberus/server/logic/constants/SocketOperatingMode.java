package com.cerberus.server.logic.constants;

public enum SocketOperatingMode {

	ON(0), OFF(1), SAFETY(2), RESTRICTED(3);

	private final int opMode;

	private SocketOperatingMode(int opMode) {
		this.opMode = opMode;
	}

	public int getIntValue() {
		return opMode;
	}

}
