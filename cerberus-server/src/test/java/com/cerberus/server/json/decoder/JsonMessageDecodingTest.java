package com.cerberus.server.json.decoder;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.cerberus.server.json.JsonDataBinderFactory;
import com.cerberus.server.logic.constants.SocketOperatingMode;
import com.cerberus.server.logic.constants.SocketStatus;
import com.cerberus.server.message.CurrentConsumptionMessage;
import com.cerberus.server.message.GenericInformationMessage;
import com.cerberus.server.message.Message;
import com.cerberus.server.message.MessageType;
import com.cerberus.server.message.RFIDAuthRequestMessage;
import com.cerberus.server.message.RFIDAuthResponseMessage;
import com.cerberus.server.message.StatusMessage;
import com.cerberus.server.message.SwitchOperatingModeMessage;
import com.fasterxml.jackson.databind.ObjectReader;

public class JsonMessageDecodingTest {

	private static final String CURRENT_JSON_MESSAGE = "{ \"type\" : \"CURRENT\", \"socketId\" : 12345, \"timestamp\" : 1363702072, \"current\" : 3000, \"rfidNumber\" : \"1234567890\"}";
	private static final String CURRENT_JSON_MESSAGE_NO_RFID = "{ \"type\" : \"CURRENT\", \"socketId\" : 12345, \"timestamp\" : 1363702072, \"current\" : 3000}";
	private static final String RFID_AUTH_REQ_JSON_MESSAGE = "{ \"type\" : \"RFID_AUTH_REQ\", \"socketId\" : 12345, \"timestamp\" : 1363702072, \"rfidNumber\" : \"1234567890\"}";
	private static final String RFID_AUTH_RES_JSON_MESSAGE = "{ \"type\" : \"RFID_AUTH_RES\", \"socketId\" : 12345, \"timestamp\" : 1363702072, \"rfidNumber\" : \"1234567890\", \"authorized\" : true}";
	private static final String STATUS_JSON_MESSAGE = "{ \"type\" : \"STATUS\", \"socketId\" : 12345, \"timestamp\" : 1363702072, \"status\" : 0}";
	private static final String SWITCH_OP_MODE_JSON_MESSAGE = "{ \"type\" : \"SWITCH_OP_MODE\", \"socketId\" : 12345, \"timestamp\" : 1363702072, \"opMode\" : 0, \"powerThreshold\" : 2000}";
	private static final String GENERIC_INFO_JSON_MESSAGE = "{ \"type\" : \"GENERIC_INFO\", \"socketId\" : 12345, \"timestamp\" : 1363702072, \"informationType\" : \"blahtype\", \"information\" : \"blahblah\"}";

	private static final String EMPTY_JSON_MESSAGE = "{  }";
	private static final String INVALID_JSON_MESSAGE = "{ \"blah\" : {} }";

	private long socketId;
	private long timestamp;

	private Message message;

	@Before
	public void setup() {
		socketId = 12345;
		timestamp = 1363702072;
	}

	@Test
	public void testDecodingJsonCurrentConsumptionMessage() throws Exception {
		ObjectReader reader = JsonDataBinderFactory.getReader(Message.class);
		message = reader.readValue(CURRENT_JSON_MESSAGE);

		assertTrue(message instanceof CurrentConsumptionMessage);
		CurrentConsumptionMessage currentMsg = (CurrentConsumptionMessage) message;

		assertThat(currentMsg.getSocketId(), is(equalTo(socketId)));
		assertThat(currentMsg.getTimestamp(), is(equalTo(timestamp)));
		assertThat(currentMsg.getType(), is(equalTo(MessageType.CURRENT)));
		assertThat(currentMsg.getCurrent(), is(equalTo(3000)));
		assertThat(currentMsg.getRfidNumber(), is(equalTo("1234567890")));
	}

	@Test
	public void testDecodingJsonCurrentWithoutRFID() throws Exception {
		ObjectReader reader = JsonDataBinderFactory.getReader(Message.class);
		message = reader.readValue(CURRENT_JSON_MESSAGE_NO_RFID);

		assertTrue(message instanceof CurrentConsumptionMessage);
		CurrentConsumptionMessage currentMsg = (CurrentConsumptionMessage) message;

		assertThat(currentMsg.getSocketId(), is(equalTo(socketId)));
		assertThat(currentMsg.getTimestamp(), is(equalTo(timestamp)));
		assertThat(currentMsg.getType(), is(equalTo(MessageType.CURRENT)));
		assertThat(currentMsg.getCurrent(), is(equalTo(3000)));
		assertThat(currentMsg.getRfidNumber(), is(nullValue()));
	}

	@Test
	public void testDecodingJsonRFIDAuthRequestMessage() throws Exception {
		ObjectReader reader = JsonDataBinderFactory.getReader(Message.class);
		message = reader.readValue(RFID_AUTH_REQ_JSON_MESSAGE);

		assertTrue(message instanceof RFIDAuthRequestMessage);
		RFIDAuthRequestMessage rfidMsg = (RFIDAuthRequestMessage) message;

		assertThat(rfidMsg.getSocketId(), is(equalTo(socketId)));
		assertThat(rfidMsg.getTimestamp(), is(equalTo(timestamp)));
		assertThat(rfidMsg.getType(), is(equalTo(MessageType.RFID_AUTH_REQ)));
		assertThat(rfidMsg.getRfidNumber(), is(equalTo("1234567890")));
	}

	@Test
	public void testDecodingJsonRFIDAuthResponseMessage() throws Exception {
		ObjectReader reader = JsonDataBinderFactory.getReader(Message.class);
		message = reader.readValue(RFID_AUTH_RES_JSON_MESSAGE);

		assertTrue(message instanceof RFIDAuthResponseMessage);
		RFIDAuthResponseMessage rfidMsg = (RFIDAuthResponseMessage) message;

		assertThat(rfidMsg.getSocketId(), is(equalTo(socketId)));
		assertThat(rfidMsg.getTimestamp(), is(equalTo(timestamp)));
		assertThat(rfidMsg.getType(), is(equalTo(MessageType.RFID_AUTH_RES)));
		assertThat(rfidMsg.getRfidNumber(), is(equalTo("1234567890")));
		assertThat(rfidMsg.isAuthorized(), is(true));
	}

	@Test
	public void testDecodingJsonStatusMessage() throws Exception {
		ObjectReader reader = JsonDataBinderFactory.getReader(Message.class);
		message = reader.readValue(STATUS_JSON_MESSAGE);

		assertTrue(message instanceof StatusMessage);
		StatusMessage currentMsg = (StatusMessage) message;

		assertThat(currentMsg.getSocketId(), is(equalTo(socketId)));
		assertThat(currentMsg.getTimestamp(), is(equalTo(timestamp)));
		assertThat(currentMsg.getType(), is(equalTo(MessageType.STATUS)));
		assertThat(currentMsg.getStatus(), is(equalTo(SocketStatus.NORMAL)));
	}

	@Test
	public void testDecodingJsonSwitchOperatingModeMessage() throws Exception {
		ObjectReader reader = JsonDataBinderFactory.getReader(Message.class);
		message = reader.readValue(SWITCH_OP_MODE_JSON_MESSAGE);

		assertTrue(message instanceof SwitchOperatingModeMessage);
		SwitchOperatingModeMessage switchMsg = (SwitchOperatingModeMessage) message;

		assertThat(switchMsg.getSocketId(), is(equalTo(socketId)));
		assertThat(switchMsg.getTimestamp(), is(equalTo(timestamp)));
		assertThat(switchMsg.getType(), is(equalTo(MessageType.SWITCH_OP_MODE)));
		assertThat(switchMsg.getOpMode(), is(equalTo(SocketOperatingMode.ON)));
		assertThat(switchMsg.getPowerThreshold(), is(equalTo(2000)));
	}

	@Test
	public void testDecodingJsonGenericInformationMessage() throws Exception {
		ObjectReader reader = JsonDataBinderFactory.getReader(Message.class);
		message = reader.readValue(GENERIC_INFO_JSON_MESSAGE);

		assertTrue(message instanceof GenericInformationMessage);
		GenericInformationMessage genericMsg = (GenericInformationMessage) message;

		assertThat(genericMsg.getSocketId(), is(equalTo(socketId)));
		assertThat(genericMsg.getTimestamp(), is(equalTo(timestamp)));
		assertThat(genericMsg.getType(), is(equalTo(MessageType.GENERIC_INFO)));
		assertThat(genericMsg.getInformationType(), is(equalTo("blahtype")));
		assertThat(genericMsg.getInformation(), is(equalTo("blahblah")));
	}

	@Test(expected = IOException.class)
	public void testEmptyJsonMessageShouldThrowExceptionAndFail() throws Exception {
		ObjectReader reader = JsonDataBinderFactory.getReader(Message.class);
		message = reader.readValue(EMPTY_JSON_MESSAGE);
	}

	@Test(expected = IOException.class)
	public void testInvalidJsonMessageShouldThrowExceptionAndFail() throws Exception {
		ObjectReader reader = JsonDataBinderFactory.getReader(Message.class);
		message = reader.readValue(INVALID_JSON_MESSAGE);
	}

}
