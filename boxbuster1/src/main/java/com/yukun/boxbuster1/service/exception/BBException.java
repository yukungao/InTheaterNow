package com.yukun.boxbuster1.service.exception;

@SuppressWarnings("serial")
public class BBException extends RuntimeException {
	private ErrorCode errorCode;

	public BBException(ErrorCode code, String message, Throwable throwable) {
		super(message, throwable);
		this.errorCode = code;
	}
	
	public BBException(ErrorCode code, String message) {
		super(message);
		this.errorCode = code;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

}