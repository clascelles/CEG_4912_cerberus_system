package com.cerberus.module.security.constants;

public enum RfidPermission {

	DENIED(0), ALLOWED(1), UNKNOWN(2);

	private final int permission;

	private RfidPermission(int permission) {
		this.permission = permission;
	}

	public int getIntValue() {
		return permission;
	}

	public static RfidPermission fromIntValue(int permissionValue) {
		for (RfidPermission permission : RfidPermission.values()) {
			if (permissionValue == permission.getIntValue()) {
				return permission;
			}
		}
		return null;
	}

}
