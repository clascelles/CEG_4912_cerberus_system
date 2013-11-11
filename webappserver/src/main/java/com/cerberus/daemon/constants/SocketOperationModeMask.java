package com.cerberus.daemon.constants;

public enum SocketOperationModeMask {

	OFF(2, 1), ON(1, 2), NORMAL(3, 4);

	private final int id;
	private final int mask;

	private SocketOperationModeMask(int id, int mask) {
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
		for (SocketOperationModeMask mask : values()) {
			if(mask.getId() == id) {
				return mask.getMask();
			}
		}
		return 0;
	}

}
