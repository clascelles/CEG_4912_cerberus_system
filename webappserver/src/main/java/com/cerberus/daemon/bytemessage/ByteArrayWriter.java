package com.cerberus.daemon.bytemessage;

import java.nio.ByteBuffer;

import javax.xml.bind.DatatypeConverter;

import com.cerberus.daemon.message.Message;

public class ByteArrayWriter {

	private static int MAX_MESSAGE_LENGTH = 50;

	private final ByteBuffer messageBuffer;

	public ByteArrayWriter() {
		this.messageBuffer = ByteBuffer.allocate(MAX_MESSAGE_LENGTH);
	}

	public byte[] write(Message message) {
		messageBuffer.clear();
		messageBuffer.put((byte) message.getType().getIntValue());
		messageBuffer.put(message.getOutletId().getBytes());
		messageBuffer.put((byte) message.getSocket());
		messageBuffer.putLong(message.getTimestamp());
		// RFID Number is converted from a String to a hex byte array
		messageBuffer.put(DatatypeConverter.parseHexBinary(message.getRfidNumber()));


		return messageBuffer.array();


	}

}
