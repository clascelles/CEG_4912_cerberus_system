package com.cerberus.daemon.constants;

public enum SocketOperatingMode {

	ON(2), OFF(1), NORMAL(4), MONITORING(32), SAFETY(16), RESTRICTED(8);

	private final int opMode;

	private SocketOperatingMode(int opMode) {
		this.opMode = opMode;
	}

	public int getIntValue() {
		return opMode;
	}

	public static SocketOperatingMode fromIntValue(int opModeValue) {
		switch(opModeValue){
		case 1:
		   return SocketOperatingMode.ON;
		case 2:
		   return SocketOperatingMode.OFF;
		case 3:
		   return SocketOperatingMode.NORMAL;
		case 4:
		   return SocketOperatingMode.MONITORING;
		case 5:
		   return SocketOperatingMode.SAFETY;
		case 6:
		   return SocketOperatingMode.RESTRICTED;
		}
		return null;
	}

}
