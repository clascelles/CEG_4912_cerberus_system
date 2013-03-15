package com.cerberus.server.communication.pipeline;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.handler.codec.frame.DelimiterBasedFrameDecoder;
import org.jboss.netty.handler.codec.frame.Delimiters;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;
import org.jboss.netty.util.CharsetUtil;

import com.cerberus.server.communication.handlers.StringHandler;

public class SimpleChannelPipelineFactory implements ChannelPipelineFactory {

	public ChannelPipeline getPipeline() throws Exception {
		
		//Initialize pipeline
		ChannelPipeline pipeline = Channels.pipeline();
		
		//Initialize the Decoders, Handlers and Encoders
		 		
		//Decoders
		//Need these two to convert raw ChannelBuffers into Strings
		DelimiterBasedFrameDecoder delimiterFrameDecoder = new DelimiterBasedFrameDecoder(80, Delimiters.lineDelimiter());
		StringDecoder stringDecoder = new StringDecoder(CharsetUtil.UTF_8);
		
		//Handlers
		//Need this to insert logic
		StringHandler stringHandler = new StringHandler();
		
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
		pipeline.addLast("stringHandler", stringHandler);
			
		return pipeline;
	}

}
