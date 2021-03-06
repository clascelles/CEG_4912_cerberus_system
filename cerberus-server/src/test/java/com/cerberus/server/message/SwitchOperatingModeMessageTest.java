package com.cerberus.server.message;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

import com.cerberus.server.logic.constants.SocketOperatingMode;

public class SwitchOperatingModeMessageTest {

	private long socketId;
	private long timestamp;

	@Before
	public void setup() {
		socketId = 12345L;
		timestamp = System.currentTimeMillis();
	}

	@Test
	public void creatingNewSwitchOperatingModeMessage() throws Exception {
		Message statusMsg = new SwitchOperatingModeMessage(socketId, timestamp, SocketOperatingMode.ON, 1000);

		assertTrue(statusMsg instanceof SwitchOperatingModeMessage);
		SwitchOperatingModeMessage message = (SwitchOperatingModeMessage) statusMsg;

		assertThat(message.getSocketId(), is(equalTo(socketId)));
		assertThat(message.getTimestamp(), is(equalTo(timestamp)));
		assertThat(message.getOpMode(), is(equalTo(SocketOperatingMode.ON)));
		assertThat(message.getPowerThreshold(), is(equalTo(1000)));
	}

}
