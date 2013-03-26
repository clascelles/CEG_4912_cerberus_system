package com.cerberus.server.message;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

public class RFIDAuthRequestMessageTest {

	private int socketId;
	private long timestamp;

	@Before
	public void setup() {
		socketId = 12345;
		timestamp = System.currentTimeMillis();
	}

	@Test
	public void creatingNewRFIDAuthRequestMessage() throws Exception {
		Message rfidAuthReq = new RFIDAuthRequestMessage(socketId, timestamp, 123456789);

		assertTrue(rfidAuthReq instanceof RFIDAuthRequestMessage);
		RFIDAuthRequestMessage message = (RFIDAuthRequestMessage) rfidAuthReq;

		assertThat(message.getSocketId(), is(equalTo(socketId)));
		assertThat(message.getTimestamp(), is(equalTo(timestamp)));
		assertThat(message.getType(), is(equalTo(MessageType.RFID_AUTH_REQ)));
		assertThat(message.getRfidNumber(), is(equalTo(123456789)));
	}

}
