package com.solelogic;

public class CustomException extends RuntimeException {

	private String message;
	private int errorCode;

	public CustomException(String message, int errorCode) {
		super();
		this.message = message;
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomException(String message) {

		super(message);
	}

}
