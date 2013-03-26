package com.cerberus.server.message;

public enum MessageType {

	RFID_AUTH_REQ(RFIDAuthRequestMessage.class), CURRENT(CurrentConsumptionMessage.class), STATUS(StatusMessage.class), RFID_AUTH_RES(
			RFIDAuthResponseMessage.class), SWITCH_OP_MODE(SwitchOperatingModeMessage.class), GENERIC_INFO(
			GenericInformationMessage.class);

	private final Class<?> classType;

	private MessageType(Class<?> classType) {
		this.classType = classType;
	}

	public Class<?> getClassType() {
		return classType;
	}

}
