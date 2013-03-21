package com.cerberus.server.service.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceFactory {
	
	private static final int DEFAULT_NUM_OF_THREADS = 10;
	
	private static ExecutorService decoderThreadPool;
	private static ExecutorService persistenceLogicThreadPool;
	private static ExecutorService responseLogicThreadPool;
	private static ExecutorService encoderThreadPool;
	
	public ExecutorServiceFactory(){
		decoderThreadPool = Executors.newFixedThreadPool(DEFAULT_NUM_OF_THREADS);
		persistenceLogicThreadPool = Executors.newFixedThreadPool(DEFAULT_NUM_OF_THREADS);
		responseLogicThreadPool = Executors.newFixedThreadPool(DEFAULT_NUM_OF_THREADS);
		encoderThreadPool = Executors.newFixedThreadPool(DEFAULT_NUM_OF_THREADS);
	}
	
	public ExecutorServiceFactory(int nThreadsDecoder, int nThreadsPersistenceLogic, int nThreadsResponseLogic, int nThreadsEncoder){
		decoderThreadPool = Executors.newFixedThreadPool(nThreadsDecoder);
		persistenceLogicThreadPool = Executors.newFixedThreadPool(nThreadsPersistenceLogic);
		responseLogicThreadPool = Executors.newFixedThreadPool(nThreadsResponseLogic);
		encoderThreadPool = Executors.newFixedThreadPool(nThreadsEncoder);
	}

	public static ExecutorService getDecoderThreadPool() {
		return decoderThreadPool;
	}

	public static void setDecoderThreadPool(ExecutorService decoderThreadPool) {
		ExecutorServiceFactory.decoderThreadPool = decoderThreadPool;
	}

	public static ExecutorService getPersistenceLogicThreadPool() {
		return persistenceLogicThreadPool;
	}

	public static void setPersistenceLogicThreadPool(
			ExecutorService persistenceLogicThreadPool) {
		ExecutorServiceFactory.persistenceLogicThreadPool = persistenceLogicThreadPool;
	}

	public static ExecutorService getResponseLogicThreadPool() {
		return responseLogicThreadPool;
	}

	public static void setResponseLogicThreadPool(
			ExecutorService responseLogicThreadPool) {
		ExecutorServiceFactory.responseLogicThreadPool = responseLogicThreadPool;
	}

	public static ExecutorService getEncoderThreadPool() {
		return encoderThreadPool;
	}

	public static void setEncoderThreadPool(ExecutorService encoderThreadPool) {
		ExecutorServiceFactory.encoderThreadPool = encoderThreadPool;
	}

	
	
		
	
}
