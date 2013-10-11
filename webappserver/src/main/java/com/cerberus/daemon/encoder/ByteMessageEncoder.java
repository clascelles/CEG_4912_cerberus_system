package com.cerberus.daemon.encoder;

import org.apache.log4j.Logger;
import org.jboss.netty.channel.Channel;
import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;

import com.cerberus.daemon.bytemessage.ByteMessageHandlerFactory;
import com.cerberus.daemon.bytemessage.ByteMessageWriter;
import com.cerberus.daemon.message.Message;
import com.cerberus.daemon.message.MessageContainer;

public class ByteMessageEncoder implements Runnable {

	//private static final int RESPONSE_TIMEOUT_MILLIS = 30000;

	//Get Logger
	private final static Logger LOGGER = Logger.getLogger(JsonEncoder.class);

	private final MessageContainer messageContainer;

	public ByteMessageEncoder(MessageContainer messageContainer){
		this.messageContainer = messageContainer;
	}

	public void run() {

		StopWatch stopwatch = new Log4JStopWatch("ByteMessageEncoder.run");
		//Print the message to Encode to test the framework
		LOGGER.debug("[Encoder]: " + messageContainer.getMessage().toString());

		Message message = messageContainer.getMessage();
		ByteMessageWriter writer = ByteMessageHandlerFactory.getWriter();

		Channel channel = messageContainer.getClientChannel();
		//if (channel.isOpen()) {
			try {
				byte[] encodedMessage = writer.write(message);
				LOGGER.debug("Wrote message: " + encodedMessage.toString());
				
				
				channel.write(encodedMessage);
				// Could use ChannelFuture to ensure the message has been
				// sent...
				LOGGER.debug("Wrote message: " + encodedMessage + " to client #" + channel.getId());
			} catch (IllegalArgumentException e) {
				LOGGER.error("Exception caught when trying to encode this outgoing message: " + message);
				e.printStackTrace();
			}
		//} else {
			// TODO Channel is not open, handle it!
		//}
		stopwatch.stop();

	}


}
