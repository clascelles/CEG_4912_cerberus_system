package com.cerberus.daemon.bytemessage;

public class ByteMessageHandlerFactory {

	private final static ByteArrayReader reader = new ByteArrayReader();
	private final static ByteArrayWriter writer = new ByteArrayWriter();

	public static ByteArrayReader getReader() {
		return reader;
	}

	public static ByteArrayWriter getWriter() {
		return writer;
	}

}
