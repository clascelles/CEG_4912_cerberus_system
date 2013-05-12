package com.cerberus.server.message;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

import com.cerberus.server.logic.constants.SocketStatus;

public class StatusMessageTest {

	private long socketId;
	private long timestamp;

	@Before
	public void setup() {
		socketId = 12345L;
		timestamp = System.currentTimeMillis();
	}

	@Test
	public void creatingNewStatusMessage() throws Exception {
		Message statusMsg = new StatusMessage(socketId, timestamp, SocketStatus.NORMAL);

		assertTrue(statusMsg instanceof StatusMessage);
		StatusMessage message = (StatusMessage) statusMsg;

		assertThat(message.getSocketId(), is(equalTo(socketId)));
		assertThat(message.getTimestamp(), is(equalTo(timestamp)));
		assertThat(message.getStatus(), is(equalTo(SocketStatus.NORMAL)));
	}

}
