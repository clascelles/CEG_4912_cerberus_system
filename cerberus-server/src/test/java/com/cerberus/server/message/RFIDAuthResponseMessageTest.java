package com.cerberus.server.message;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

public class RFIDAuthResponseMessageTest {

	private long socketId;
	private long timestamp;

	@Before
	public void setup() {
		socketId = 12345L;
		timestamp = System.currentTimeMillis();
	}

	@Test
	public void creatingNewRFIDAuthResponseMessage() throws Exception {
		Message rfidAuthRes = new RFIDAuthResponseMessage(socketId, timestamp, "123456789", true);

		assertTrue(rfidAuthRes instanceof RFIDAuthResponseMessage);
		RFIDAuthResponseMessage message = (RFIDAuthResponseMessage) rfidAuthRes;

		assertThat(message.getSocketId(), is(equalTo(socketId)));
		assertThat(message.getTimestamp(), is(equalTo(timestamp)));
		assertThat(message.getType(), is(equalTo(MessageType.RFID_AUTH_RES)));
		assertThat(message.getRfidNumber(), is(equalTo("123456789")));
		assertThat(message.isAuthorized(), is(true));
	}

}
