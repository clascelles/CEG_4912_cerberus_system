package com.cerberus.server.message;

public class WrongMessageException extends Exception {

	private static final long serialVersionUID = 1L;

	public WrongMessageException(String message) {
		super(message);
	}

}
