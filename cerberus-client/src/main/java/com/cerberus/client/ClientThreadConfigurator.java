package com.cerberus.client;

public class ClientThreadConfigurator {

	// Static config values
	private static final String LOG4J_XML = "log4j.xml";
	private static final int RETRY_TIMEOUT = 5000; // 5 seconds

	// Default config values
	private static final int DEFAULT_NUMBER_OF_THREADS = 1;
	private static final int DEFAULT_SIMULATION_TIME = 60000; // 1 minute
	private static final int DEFAULT_SERVER_PORT = 8080;
	private static final String DEFAULT_SERVER_HOST = "localhost";
	private static final boolean DEFAULT_FULL_BLAST_ACTIVATED = false;

	// Configured values
	private final int numberOfThreads;
	private final int simulationTimeMS;
	private final int serverPort;
	private final boolean fullBlastActivated;
	private final String serverHost;

	public ClientThreadConfigurator(String[] args) {
		this.serverHost = setStringValueOrDefault(args, 0, DEFAULT_SERVER_HOST);
		this.serverPort = setIntegerValueOrDefault(args, 1, 0, 65535, DEFAULT_SERVER_PORT);
		this.numberOfThreads = setIntegerValueOrDefault(args, 2, 1, 100000, DEFAULT_NUMBER_OF_THREADS);
		this.simulationTimeMS = setIntegerValueOrDefault(args, 3, 1000, 3600000, DEFAULT_SIMULATION_TIME);
		this.fullBlastActivated = setBooleanValueOrDefault(args, 4, DEFAULT_FULL_BLAST_ACTIVATED);
	}

	public int getServerPort() {
		return serverPort;
	}

	public String getServerHost() {
		return serverHost;
	}

	public int getNumberOfThreads() {
		return numberOfThreads;
	}

	public int getSimulationTime() {
		return simulationTimeMS;
	}

	public boolean isFullBlastActivated() {
		return fullBlastActivated;
	}

	public int getRetryTimeout() {
		return RETRY_TIMEOUT;
	}

	public String getLog4JXMLFilePath() {
		return LOG4J_XML;
	}

	private String setStringValueOrDefault(String[] args, int index, String defaultValue) {
		if (args != null && args.length > index) {
			return args[index];
		}
		return defaultValue;
	}

	private int setIntegerValueOrDefault(String[] args, int index, int minRange, int maxRange, int defaultValue) {
		if (args != null && args.length > index) {
			try {
				int numValue = Integer.valueOf(args[index]);
				if (numValue >= minRange || numValue <= maxRange) {
					return numValue;
				}
			} catch (NumberFormatException e) {
				return defaultValue;
			}
		}
		return defaultValue;
	}

	private boolean setBooleanValueOrDefault(String[] args, int index, boolean defaultValue) {
		if (args != null && args.length > index) {
			boolean boolValue = Boolean.valueOf(args[index]);
			if (boolValue != defaultValue) {
				return boolValue;
			}
		}
		return defaultValue;
	}

}
