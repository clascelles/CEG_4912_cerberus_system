package com.cerberus.server.service.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceFactory {
	
	private static final int DEFAULT_NUM_OF_THREADS = 10;
	
	private static ExecutorService decoderThreadPool;
	private static ExecutorService logicThreadPool;
	private static ExecutorService encoderThreadPool;
	
	public ExecutorServiceFactory(){
		decoderThreadPool = Executors.newFixedThreadPool(DEFAULT_NUM_OF_THREADS);
		logicThreadPool = Executors.newFixedThreadPool(DEFAULT_NUM_OF_THREADS);
		encoderThreadPool = Executors.newFixedThreadPool(DEFAULT_NUM_OF_THREADS);
	}
	
	public ExecutorServiceFactory(int nThreadsDecoder, int nThreadsLogic, int nThreadsEncoder){
		decoderThreadPool = Executors.newFixedThreadPool(nThreadsDecoder);
		logicThreadPool = Executors.newFixedThreadPool(nThreadsLogic);
		encoderThreadPool = Executors.newFixedThreadPool(nThreadsEncoder);
	}

	public static ExecutorService getDecoderThreadPool() {
		return decoderThreadPool;
	}

	public static void setDecoderThreadPool(ExecutorService decoderThreadPool) {
		ExecutorServiceFactory.decoderThreadPool = decoderThreadPool;
	}

	public static ExecutorService getLogicThreadPool() {
		return logicThreadPool;
	}

	public static void setLogicThreadPool(ExecutorService logicThreadPool) {
		ExecutorServiceFactory.logicThreadPool = logicThreadPool;
	}

	public static ExecutorService getEncoderThreadPool() {
		return encoderThreadPool;
	}

	public static void setEncoderThreadPool(ExecutorService encoderThreadPool) {
		ExecutorServiceFactory.encoderThreadPool = encoderThreadPool;
	}

	
	
		
	
}
