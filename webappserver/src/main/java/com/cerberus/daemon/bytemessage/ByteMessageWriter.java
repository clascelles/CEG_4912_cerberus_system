package com.cerberus.daemon.bytemessage;

import java.nio.ByteBuffer;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

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
			messageBuffer.put(message.getOutletSerialNumber().getBytes());
			messageBuffer.put(intToByte(message.getSocket()));
			messageBuffer.put(timestampHandler.formatTimestamp(message.getTimestamp()));
			// RFID Number is converted from a String to a hex byte array
			byte[] decodedRfid = new byte[5];
			try {
				decodedRfid = Hex.decodeHex(message.getRfidNumber().toCharArray());
			} catch (DecoderException e) {
				// TODO: Log error!
				e.printStackTrace();
			}
			messageBuffer.put(decodedRfid);

			// Mode and subsequent fields are dependent on message type
			switch(message.getType()) {
			case OP_MODE_SWITCH:
				SwitchOperatingModeMessage switchOp = (SwitchOperatingModeMessage) message;
				messageBuffer.put(intToByte(switchOp.getOpMode()));
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

			case INIT:
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
