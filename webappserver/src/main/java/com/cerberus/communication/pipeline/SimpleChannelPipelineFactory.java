package com.cerberus.communication.pipeline;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.handler.codec.frame.DelimiterBasedFrameDecoder;
import org.jboss.netty.handler.codec.frame.Delimiters;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;
import org.jboss.netty.util.CharsetUtil;

import com.cerberus.communication.handlers.MessageHandler;

public class SimpleChannelPipelineFactory implements ChannelPipelineFactory {

	private static final int FRAME_MAXIMUM_LENGTH = 1024;

	public ChannelPipeline getPipeline() throws Exception {

		//Initialize pipeline
		ChannelPipeline pipeline = Channels.pipeline();

		//Initialize the Decoders, Handlers and Encoders

		//Decoders
		//Need these two to convert raw ChannelBuffers into Strings
		DelimiterBasedFrameDecoder delimiterFrameDecoder = new DelimiterBasedFrameDecoder(FRAME_MAXIMUM_LENGTH,
				Delimiters.lineDelimiter());
		StringDecoder stringDecoder = new StringDecoder(CharsetUtil.UTF_8);

		//Handlers
		//Need this to insert logic
		MessageHandler messageHandler = new MessageHandler();

		//Encoders
		//Need this to encode a string into a ChannelBuffer
		StringEncoder stringEncoder = new StringEncoder(CharsetUtil.UTF_8);

		/*
		 * Add the Handler to the pipeline. We can add many handler to the pipeline.
		 * They will be added in order. Order of the pipeline can also be changed at
		 * runtime to change the handling of data. (useful for compression of data)
		 */
		pipeline.addLast("delimiterFrameDecoder", delimiterFrameDecoder);
		pipeline.addLast("stringDecoder", stringDecoder);

		pipeline.addLast("stringEncoder", stringEncoder);
		pipeline.addLast("messageHandler", messageHandler);

		return pipeline;
	}

}
