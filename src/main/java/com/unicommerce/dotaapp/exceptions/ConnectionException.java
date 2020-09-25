package com.unicommerce.dotaapp.exceptions;


/*
 * Exception class for calls made to the APIs
 */
public class ConnectionException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String responseMessage;
	
	public ConnectionException(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	@Override
	public String getMessage() {
		return responseMessage;
	}
}
