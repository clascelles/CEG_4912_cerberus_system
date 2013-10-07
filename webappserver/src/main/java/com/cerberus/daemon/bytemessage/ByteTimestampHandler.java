package com.cerberus.daemon.bytemessage;

import java.nio.ByteBuffer;

import org.joda.time.DateTime;

public class ByteTimestampHandler {

	private static int MAX_TIMESTAMP_LENGTH = 7;
	private final ByteBuffer messageBuffer;

	public ByteTimestampHandler() {
		messageBuffer = ByteBuffer.allocate(MAX_TIMESTAMP_LENGTH);
	}

	public byte[] formatTimestamp(long timestamp) {
		messageBuffer.clear();
		DateTime time = new DateTime(timestamp);

		messageBuffer.put(formatYear(time.getYear()));
		messageBuffer.put(intToByte(time.getMonthOfYear()));
		messageBuffer.put(intToByte(time.getDayOfMonth()));
		messageBuffer.put(intToByte(time.getHourOfDay()));
		messageBuffer.put(intToByte(time.getMinuteOfHour()));
		messageBuffer.put(intToByte(time.getSecondOfMinute()));

		return messageBuffer.array();
	}

	public long readTimestamp(byte[] timestamp) throws IllegalArgumentException {
		DateTime time = new DateTime();

		if(timestamp.length > MAX_TIMESTAMP_LENGTH) {
			throw new IllegalArgumentException("Too many bytes in the timestamp, maximum of " +
					MAX_TIMESTAMP_LENGTH + "allowed: " + timestamp);
		}

		time = time.withYear((timestamp[0] << 8) | (timestamp[1] &0xFF));
		time = time.withMonthOfYear(timestamp[2]);
		time = time.withDayOfMonth(timestamp[3]);
		time = time.withHourOfDay(timestamp[4]);
		time = time.withMinuteOfHour(timestamp[5]);
		time = time.withSecondOfMinute(timestamp[6]);

		return time.getMillis();
	}

	private byte[] formatYear(int year) {
		byte[] formattedYear = new byte[2];
		formattedYear[0] = intToByte(year);
		formattedYear[1] = (byte) ((year >>> 8) & 0xFF);

		return formattedYear;
	}

	private byte intToByte(int value) {
		return (byte) (value & 0xFF);
	}

}
