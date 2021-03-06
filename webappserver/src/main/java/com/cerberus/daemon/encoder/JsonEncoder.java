package com.cerberus.daemon.encoder;

import org.apache.log4j.Logger;
import org.jboss.netty.channel.Channel;
import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;

import com.cerberus.daemon.json.JsonDataBinderFactory;
import com.cerberus.daemon.message.Message;
import com.cerberus.daemon.message.MessageContainer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;

public class JsonEncoder implements Runnable {

	//private static final int RESPONSE_TIMEOUT_MILLIS = 30000;

	//Get Logger
	private final static Logger LOGGER = Logger.getLogger(JsonEncoder.class);

	private final MessageContainer messageContainer;

	public JsonEncoder(MessageContainer messageContainer){
		this.messageContainer = messageContainer;
	}

	public void run() {

		StopWatch stopwatch = new Log4JStopWatch("JsonEncoder.run");
		//Print the message to Encode to test the framework
		LOGGER.debug("[Encoder]: " + messageContainer.getMessage().toString());

		Message message = messageContainer.getMessage();
		ObjectWriter writer = JsonDataBinderFactory.getWriter(message.getClass());

		Channel channel = messageContainer.getClientChannel();
		if (channel.isOpen()) {
			try {
				String encodedMessage = writer.writeValueAsString(message) + "\n";
				channel.write(encodedMessage);
				// Could use ChannelFuture to ensure the message has been
				// sent...
				LOGGER.debug("Wrote message: " + encodedMessage + " to client #" + channel.getId());
			} catch (JsonProcessingException e) {
				LOGGER.error("Exception caught when trying to encode this outgoing message: " + message);
				e.printStackTrace();
			}
		} else {
			// TODO Channel is not open, handle it!
		}
		stopwatch.stop();

	}


}
