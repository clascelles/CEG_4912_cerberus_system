package com.cerberus.server.json.encoder;

import static org.junit.Assert.assertThat;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

import com.cerberus.server.json.JsonDataBinderFactory;
import com.cerberus.server.logic.constants.SocketOperatingMode;
import com.cerberus.server.logic.constants.SocketStatus;
import com.cerberus.server.message.CurrentConsumptionMessage;
import com.cerberus.server.message.GenericInformationMessage;
import com.cerberus.server.message.RFIDAuthRequestMessage;
import com.cerberus.server.message.RFIDAuthResponseMessage;
import com.cerberus.server.message.StatusMessage;
import com.cerberus.server.message.SwitchOperatingModeMessage;
import com.fasterxml.jackson.databind.ObjectWriter;

public class JsonMessageEncodingTest {

	private static final String CURRENT_JSON_MESSAGE = "{ \"type\" : \"CURRENT\", \"socketId\" : 12345, \"timestamp\" : 1363702072, \"current\" : 3000, \"rfidNumber\" : 1234567890}";
	private static final String RFID_AUTH_REQ_JSON_MESSAGE = "{ \"type\" : \"RFID_AUTH_REQ\", \"socketId\" : 12345, \"timestamp\" : 1363702072, \"rfidNumber\" : 1234567890}";
	private static final String RFID_AUTH_RES_JSON_MESSAGE = "{ \"type\" : \"RFID_AUTH_RES\", \"socketId\" : 12345, \"timestamp\" : 1363702072, \"rfidNumber\" : 1234567890, \"authorized\" : true}";
	private static final String STATUS_JSON_MESSAGE = "{ \"type\" : \"STATUS\", \"socketId\" : 12345, \"timestamp\" : 1363702072, \"status\" : 0}";
	private static final String SWITCH_OP_MODE_JSON_MESSAGE = "{ \"type\" : \"SWITCH_OP_MODE\", \"socketId\" : 12345, \"timestamp\" : 1363702072, \"opMode\" : 0, \"powerThreshold\" : 2000}";
	private static final String GENERIC_INFO_JSON_MESSAGE = "{ \"type\" : \"GENERIC_INFO\", \"socketId\" : 12345, \"timestamp\" : 1363702072, \"informationType\" : \"typeblah\", \"information\" : \"blahblah\"}";

	private int socketId;
	private long timestamp;

	@Before
	public void setup() {
		socketId = 12345;
		timestamp = 1363702072;
	}

	@Test
	public void testEncodingJsonCurrentConsumptionMessage() throws Exception {
		CurrentConsumptionMessage message = new CurrentConsumptionMessage(socketId, timestamp, 3000, 1234567890);

		ObjectWriter writer = JsonDataBinderFactory.getWriter(message.getClass());
		String jsonMessage = writer.writeValueAsString(message);

		assertThat(jsonMessage, is(equalTo(CURRENT_JSON_MESSAGE.replaceAll("\\s", ""))));
	}

	@Test
	public void testEncodingJsonRFIDAuthRequestMessage() throws Exception {
		RFIDAuthRequestMessage message = new RFIDAuthRequestMessage(socketId, timestamp, 1234567890);

		ObjectWriter writer = JsonDataBinderFactory.getWriter(message.getClass());
		String jsonMessage = writer.writeValueAsString(message);

		assertThat(jsonMessage, is(equalTo(RFID_AUTH_REQ_JSON_MESSAGE.replaceAll("\\s", ""))));
	}

	@Test
	public void testEncodingJsonRFIDAuthResponseMessage() throws Exception {
		RFIDAuthResponseMessage message = new RFIDAuthResponseMessage(socketId, timestamp, 1234567890, true);

		ObjectWriter writer = JsonDataBinderFactory.getWriter(message.getClass());
		String jsonMessage = writer.writeValueAsString(message);

		assertThat(jsonMessage, is(equalTo(RFID_AUTH_RES_JSON_MESSAGE.replaceAll("\\s", ""))));
	}

	@Test
	public void testEncodingJsonStatusMessage() throws Exception {
		StatusMessage message = new StatusMessage(socketId, timestamp, SocketStatus.NORMAL);

		ObjectWriter writer = JsonDataBinderFactory.getWriter(message.getClass());
		String jsonMessage = writer.writeValueAsString(message);

		assertThat(jsonMessage, is(equalTo(STATUS_JSON_MESSAGE.replaceAll("\\s", ""))));
	}

	@Test
	public void testEncodingJsonSwitchOperatingModeMessage() throws Exception {
		SwitchOperatingModeMessage message = new SwitchOperatingModeMessage(socketId, timestamp,
				SocketOperatingMode.ON, 2000);

		ObjectWriter writer = JsonDataBinderFactory.getWriter(message.getClass());
		String jsonMessage = writer.writeValueAsString(message);

		assertThat(jsonMessage, is(equalTo(SWITCH_OP_MODE_JSON_MESSAGE.replaceAll("\\s", ""))));
	}

	@Test
	public void testEncodingJsonGenericInformationMessage() throws Exception {
		GenericInformationMessage message = new GenericInformationMessage(socketId, timestamp, "typeblah", "blahblah");

		ObjectWriter writer = JsonDataBinderFactory.getWriter(message.getClass());
		String jsonMessage = writer.writeValueAsString(message);

		assertThat(jsonMessage, is(equalTo(GENERIC_INFO_JSON_MESSAGE.replaceAll("\\s", ""))));
	}

}
