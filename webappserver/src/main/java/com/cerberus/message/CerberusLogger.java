package com.cerberus.message;

public class CerberusLogger {

	private static final String GET = "GET: ";
	private static final String POST = "POST: ";
	
	private static final String UPDATE = "UPDATING: ";
	
	public static void get(String view) {
		System.out.println(GET + view);
	}
	
	public static void post(String view) {
		System.out.println(POST + view);
	}
	
	public static void update(String object) {
		System.out.println(UPDATE + object);
	}
	
}
