package com.cerberus.logic.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum SocketOperatingMode {

	ON(0), OFF(1), SAFETY(2), RESTRICTED(3);

	private final int opMode;

	private SocketOperatingMode(int opMode) {
		this.opMode = opMode;
	}

	@JsonValue
	public int getIntValue() {
		return opMode;
	}

	@JsonCreator
	public static SocketOperatingMode fromIntValue(int opModeValue) {
		for (SocketOperatingMode opMode : SocketOperatingMode.values()) {
			if (opModeValue == opMode.getIntValue()) {
				return opMode;
			}
		}
		return null;
	}

}
