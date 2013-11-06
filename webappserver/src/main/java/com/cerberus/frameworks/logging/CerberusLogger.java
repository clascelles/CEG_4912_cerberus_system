package com.cerberus.frameworks.logging;

public class CerberusLogger {

	public static boolean DEBUG_MODE = true;

	private static final String GET = "GET: ";
	private static final String POST = "POST: ";
	private static final String UPDATE = "UPDATING: ";
	private static final String RESETTING_PASSWORD = "Resetting password for user: ";

	public static void get(String view) {
		printDebugMessage(GET + view);
	}

	public static void post(String view) {
		printDebugMessage(POST + view);
	}

	public static void update(String object) {
		printDebugMessage(UPDATE + object);
	}

	public static void resetPasswordMessage(String userId) {
		printDebugMessage(RESETTING_PASSWORD + userId);
	}

	public static void printDebugMessage(String message) {
		if(DEBUG_MODE) {
			System.out.println(message);
		}
	}

}
