package com.cerberus.server.message;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

public class GenericInformationMessageTest {

	private long socketId;
	private long timestamp;

	@Before
	public void setup() {
		socketId = 12345L;
		timestamp = System.currentTimeMillis();
	}

	@Test
	public void creatingNewGenericInformationMessage() throws Exception {
		Message statusMsg = new GenericInformationMessage(socketId, timestamp, "information type", "information");

		assertTrue(statusMsg instanceof GenericInformationMessage);
		GenericInformationMessage message = (GenericInformationMessage) statusMsg;

		assertThat(message.getSocketId(), is(equalTo(socketId)));
		assertThat(message.getTimestamp(), is(equalTo(timestamp)));
		assertThat(message.getInformationType(), is(equalTo("information type")));
		assertThat(message.getInformation(), is(equalTo("information")));
	}

}
