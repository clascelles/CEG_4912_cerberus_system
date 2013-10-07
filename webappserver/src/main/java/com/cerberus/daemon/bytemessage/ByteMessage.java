package com.cerberus.daemon.bytemessage;

public class ByteMessage {

	public final static int MAX_MESSAGE_LENGTH = 64;

	public final static int TYPE_LENGTH = 1;
	public final static int OUTLET_ID_LENGTH = 12;
	public final static int SOCKET_ID_LENGTH = 1;
	public final static int TIMESTAMP_LENGTH = 7;
	public final static int RFID_LENGTH = 5;
	public final static int MODE_LENGTH = 1;

	public final static int CURRENT_LENGTH = 8;

	private final byte[] rawMessage;

	public ByteMessage(byte[] rawMessage) {
		this.rawMessage = rawMessage;
	}

	public byte getType() {
		byte type = rawMessage[0];
		return type;
	}

	public byte[] getOutletId() {
		int offset = TYPE_LENGTH;
		byte[] outletId = copyByteArray(rawMessage, offset, OUTLET_ID_LENGTH);
		return outletId;
	}

	public byte getSocketId() {
		int offset = TYPE_LENGTH + OUTLET_ID_LENGTH;
		byte socketId = rawMessage[offset];
		return socketId;
	}

	public byte[] getTimestamp() {
		int offset = TYPE_LENGTH + OUTLET_ID_LENGTH + SOCKET_ID_LENGTH;
		byte[] timestamp = copyByteArray(rawMessage, offset, TIMESTAMP_LENGTH);
		return timestamp;
	}

	public byte[] getRfidNumber() {
		int offset = TYPE_LENGTH + OUTLET_ID_LENGTH + SOCKET_ID_LENGTH + TIMESTAMP_LENGTH;
		byte[] rfid = copyByteArray(rawMessage, offset, RFID_LENGTH);
		return rfid;
	}

	public byte getMode() {
		int offset = TYPE_LENGTH + OUTLET_ID_LENGTH + SOCKET_ID_LENGTH + TIMESTAMP_LENGTH + RFID_LENGTH;
		byte mode = rawMessage[offset];
		return mode;
	}

	public byte[] getCurrent() {
		int offset = TYPE_LENGTH + OUTLET_ID_LENGTH + SOCKET_ID_LENGTH + TIMESTAMP_LENGTH + RFID_LENGTH + MODE_LENGTH;
		byte[] current = copyByteArray(rawMessage, offset, CURRENT_LENGTH);
		return current;
	}

	public byte[] getExtraInfo() {
		int offset = TYPE_LENGTH + OUTLET_ID_LENGTH + SOCKET_ID_LENGTH + TIMESTAMP_LENGTH + RFID_LENGTH + MODE_LENGTH;
		byte[] info = copyByteArray(rawMessage, offset, MAX_MESSAGE_LENGTH - offset);
		return info;
	}

	private byte[] copyByteArray(byte[] original, int offset, int length) {
		byte[] copy = new byte[length];

		if(original.length >= length+offset) {
			for(int i = 0; i < length; i++) {
				copy[i] = original[i+offset];
			}
		}
		return copy;
	}

}
