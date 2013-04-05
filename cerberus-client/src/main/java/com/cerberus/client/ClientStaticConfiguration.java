package com.cerberus.client;

public class ClientStaticConfiguration {

	protected final static String LOG4J_XML = "src/main/resource/log4j.xml";

	protected static final String SERVER_HOST = "localhost";
	protected static final int SERVER_PORT = 8080;

	protected static final int CLIENTS = 4;
	protected static final int TOTAL_TIME_LAPSE = 20000; // 1 minute
	protected static final int RETRY_CONNECTING = 5000; // 5 seconds
	protected static final boolean WAIT_BEFORE_SENDING_NEXT_MESSAGE = false;

}
