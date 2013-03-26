package com.cerberus.server.json.encoder;

import java.util.logging.Logger;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;

import com.cerberus.server.json.JsonDataBinderFactory;
import com.cerberus.server.message.Message;
import com.cerberus.server.message.MessageContainer;
import com.cerberus.server.message.MessageType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;

public class JsonEncoder implements Runnable {

	private static final int RESPONSE_TIMEOUT_MILLIS = 30000;

	//Get Logger
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	private final MessageContainer messageContainer;

	public JsonEncoder(MessageContainer messageContainer){
		this.messageContainer = messageContainer;
	}

	@Override
	public void run() {

		//Print the message to Encode to test the framework
		LOGGER.info("[Encoder]: " + messageContainer.getMessage().toString());

		Message message = messageContainer.getMessage();
		MessageType type = message.getType();
		ObjectWriter writer = JsonDataBinderFactory.getWriter(type.getClassType());

		Channel channel = messageContainer.getClientChannel();
		if (channel.isOpen()) {
			try {
				ChannelFuture response = channel.write(writer.writeValueAsBytes(message));
				if (!response.await(RESPONSE_TIMEOUT_MILLIS)) {
					LOGGER.severe("Sending message: " + message + " to client #" + channel.getId() + " timed out.");
					// TODO Handle timeouts here
				}
				// Else, message was successfully sent
			} catch (JsonProcessingException e) {
				LOGGER.severe("Exception caught when trying to encode this outgoing message: " + message);
				e.printStackTrace();
			} catch (InterruptedException e) {
				LOGGER.severe("Thread interrupted while waiting for a response from the client after sending a message.");
				// TODO Handle interruption
				e.printStackTrace();
			}
		} else {
			// TODO Channel is not open, handle it!
		}

	}


}
