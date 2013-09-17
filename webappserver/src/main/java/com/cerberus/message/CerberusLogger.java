package com.cerberus.message;

public class CerberusLogger {

	private static final String GET = "GET: ";
	private static final String POST = "POST: ";	
	
	public static void get(String view) {
		System.out.println(GET + view);
	}
	
	public static void post(String view) {
		System.out.println(POST + view);
	}
	
}
