package com.cerberus.daemon.bytemessage;

import java.nio.ByteBuffer;

import javax.xml.bind.DatatypeConverter;

import com.cerberus.daemon.message.GenericInformationMessage;
import com.cerberus.daemon.message.Message;
import com.cerberus.daemon.message.RFIDAuthResponseMessage;
import com.cerberus.daemon.message.StatusMessage;
import com.cerberus.daemon.message.SwitchOperatingModeMessage;

public class ByteMessageWriter {

	private final ByteBuffer messageBuffer;
	private final ByteTimestampHandler timestampHandler;

	public ByteMessageWriter() {
		this.messageBuffer = ByteBuffer.allocate(ByteMessage.MAX_MESSAGE_LENGTH);
		this.timestampHandler = new ByteTimestampHandler();
	}

	public byte[] write(Message message) throws IllegalArgumentException {
		messageBuffer.clear();

		if(message != null) {
			messageBuffer.put(intToByte(message.getType().getIntValue()));
			messageBuffer.put(message.getOutletId().getBytes());
			messageBuffer.put(intToByte(message.getSocket()));
			messageBuffer.put(timestampHandler.formatTimestamp(message.getTimestamp()));
			// RFID Number is converted from a String to a hex byte array
			messageBuffer.put(DatatypeConverter.parseHexBinary(message.getRfidNumber()));

			// Mode and subsequent fields are dependent on message type
			switch(message.getType()) {
			case OP_MODE_SWITCH:
				SwitchOperatingModeMessage switchOp = (SwitchOperatingModeMessage) message;
				messageBuffer.put(intToByte(switchOp.getOpMode().getIntValue()));
				// Casting power threshold value to use 4 bytes instead of 1
				messageBuffer.putInt(switchOp.getPowerThreshold());
				break;

			case RFID_AUTH_RES:
				RFIDAuthResponseMessage res = (RFIDAuthResponseMessage) message;
				int auth = res.isAuthorized() ? 1 : 0;
				messageBuffer.put(intToByte(auth));
				break;

			case STATUS:
				StatusMessage status = (StatusMessage) message;
				messageBuffer.put(intToByte(status.getStatus().getIntValue()));
				break;

			case GENERIC:
				// Not really used so far, might have to change how we handle info type...
				GenericInformationMessage generic = (GenericInformationMessage) message;
				messageBuffer.put(generic.getInformationType().getBytes());
				messageBuffer.put(generic.getInformation().getBytes());
				break;

			case CURRENT:
			case RFID_AUTH_REQ:
			default:
				throw new IllegalArgumentException("Illegal message type being written! : " + message.getType());
			}
		} else {
			throw new IllegalArgumentException("Trying to write null message!");
		}

		return messageBuffer.array();
	}

	private byte intToByte(int value) {
		return (byte) (value & 0xFF);
	}
}
