package com.se.spring.restException;

public class CustomNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	
	public CustomNotFoundException(String message) {
		super(message);
	}
	
	public CustomNotFoundException(Throwable cause) {
		super(cause);
	}
}
