package com.cerberus.daemon.constants;

public class OperationMode {

	private final Integer outletMode;
	private final Integer socketMode;

	public OperationMode(Integer outletMode, Integer socketMode) {
		this.outletMode = outletMode;
		this.socketMode = socketMode;
	}

	public Integer getSocketMode() {
		return socketMode;
	}

	public Integer getOutletMode() {
		return outletMode;
	}

	public Integer getOperationMode() {
		int opMode = 0;
		opMode += OutletOperationModeMask.getMaskFromId(outletMode);
		opMode += SocketOperationModeMask.getMaskFromId(socketMode);
		return opMode;
	}

}
