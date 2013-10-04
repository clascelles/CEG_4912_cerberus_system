package com.cerberus.daemon.bytemessage;

import java.nio.ByteBuffer;

import com.cerberus.daemon.message.Message;

public class ByteArrayWriter {

	private static int MAX_MESSAGE_LENGTH = 50;

	private final ByteBuffer messageBuffer;

	public ByteArrayWriter() {
		this.messageBuffer = ByteBuffer.allocate(MAX_MESSAGE_LENGTH);
	}

	public byte[] write(Message message) {
		messageBuffer.clear();
		messageBuffer.putInt(message.getType().getIntValue());
		messageBuffer.putLong(message.getSocketId());
		messageBuffer.putLong(message.getTimestamp());
		messageBuffer.put(message.getRfidNumber().getBytes());

		return messageBuffer.array();


	}

}
