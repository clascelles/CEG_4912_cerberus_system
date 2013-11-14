package com.cerberus.daemon.bytemessage;

import java.nio.ByteBuffer;

import org.apache.commons.codec.binary.Hex;

import com.cerberus.daemon.constants.MessageType;
import com.cerberus.daemon.constants.SocketStatus;
import com.cerberus.daemon.message.CurrentConsumptionMessage;
import com.cerberus.daemon.message.Message;
import com.cerberus.daemon.message.RFIDAuthRequestMessage;
import com.cerberus.daemon.message.StatusMessage;

public class ByteMessageReader {

	private final ByteTimestampHandler timestampHandler;

	public ByteMessageReader() {
		timestampHandler = new ByteTimestampHandler();
	}

	public Message read(byte[] rawMessage) {
		ByteMessage message = new ByteMessage(rawMessage);

		MessageType type = MessageType.fromIntValue(message.getType());
		String outletId = new String(message.getOutletSerialNumber());
		int socketId = message.getSocketId();
		long timestamp = timestampHandler.readTimestamp(message.getTimestamp());
		String rfid = new String(Hex.encodeHex(message.getRfidNumber()));

		Message readMessage;
		switch(type) {
		case CURRENT:
			short currentUnit = ByteBuffer.wrap(message.getCurrentUnit()).getShort();
			short currentDec = ByteBuffer.wrap(message.getCurrentDec()).getShort();

			double current = currentUnit + currentDec * (1/10000);
			readMessage = new CurrentConsumptionMessage(outletId, socketId, timestamp, rfid, current);
			break;
		case RFID_AUTH_REQ:
			readMessage = new RFIDAuthRequestMessage(outletId, socketId, timestamp, rfid);
			break;
		case STATUS:
			SocketStatus status = SocketStatus.fromIntValue(message.getMode());
			readMessage = new StatusMessage(outletId, socketId, timestamp, rfid, status);
			break;
		case GENERIC:
		case RFID_AUTH_RES:
		case OP_MODE_SWITCH:
		default:
			throw new IllegalArgumentException("Illegal message type being read! : " + type);
		}

		return readMessage;
	}

}
