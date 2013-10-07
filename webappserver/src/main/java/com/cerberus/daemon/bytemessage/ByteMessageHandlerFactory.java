package com.cerberus.daemon.bytemessage;

public class ByteMessageHandlerFactory {

	private final static ByteMessageReader reader = new ByteMessageReader();
	private final static ByteMessageWriter writer = new ByteMessageWriter();

	public static ByteMessageReader getReader() {
		return reader;
	}

	public static ByteMessageWriter getWriter() {
		return writer;
	}

}
