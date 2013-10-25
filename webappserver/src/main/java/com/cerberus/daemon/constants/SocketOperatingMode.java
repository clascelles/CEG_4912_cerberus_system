package com.cerberus.daemon.constants;

public enum SocketOperatingMode {

	ON(1), OFF(2), MONITORING(3), SAFETY(4), RESTRICTED(5);

	private final int opMode;

	private SocketOperatingMode(int opMode) {
		this.opMode = opMode;
	}

	public int getIntValue() {
		return opMode;
	}

	public static SocketOperatingMode fromIntValue(int opModeValue) {
		for (SocketOperatingMode opMode : SocketOperatingMode.values()) {
			if (opModeValue == opMode.getIntValue()) {
				return opMode;
			}
		}
		return null;
	}

}
