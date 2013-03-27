package com.cerberus.server.message;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CurrentConsumptionMessageTest {

	private int socketId;
	private long timestamp;

	@Before
	public void setup() {
		socketId = 12345;
		timestamp = System.currentTimeMillis();
	}

	@Test
	public void creatingNewCurrentConsumptionMessage() throws Exception {
		Message currentMsg = new CurrentConsumptionMessage(socketId, timestamp, 2000, "123456789");

		assertTrue(currentMsg instanceof CurrentConsumptionMessage);
		CurrentConsumptionMessage message = (CurrentConsumptionMessage) currentMsg;

		assertThat(message.getSocketId(), is(equalTo(socketId)));
		assertThat(message.getTimestamp(), is(equalTo(timestamp)));
		assertThat(message.getType(), is(equalTo(MessageType.CURRENT)));
		assertThat(message.getCurrent(), is(equalTo(2000)));
		assertThat(message.getRfidNumber(), is(equalTo("123456789")));
	}

}
