package com.cerberus.daemon.constants;

public enum OutletOperationModeMask {

	MONITORING(1, 32), SAFETY(2, 16), RESTRICTED(3, 8);

	private final int id;
	private final int mask;

	private OutletOperationModeMask(int id, int mask) {
		this.id = id;
		this.mask = mask;
	}

	public int getId() {
		return id;
	}

	public int getMask() {
		return mask;
	}

	public static int getMaskFromId(int id) {
		for (OutletOperationModeMask mask : values()) {
			if(mask.getId() == id) {
				return mask.getMask();
			}
		}
		return 0;
	}
}
