package com.cerberus.server.logic.constants;

public enum SocketOperatingMode {

	ON(1), OFF(2), SAFETY(3), RESTRICTED(4);

	private final int opMode;

	private SocketOperatingMode(int opMode) {
		this.opMode = opMode;
	}

	public int getIntValue() {
		return opMode;
	}

}
