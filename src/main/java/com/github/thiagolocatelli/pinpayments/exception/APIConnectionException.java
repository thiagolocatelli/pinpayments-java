package com.github.thiagolocatelli.pinpayments.exception;

public class APIConnectionException extends PinPaymentsException {

	private static final long serialVersionUID = 1L;

	public APIConnectionException(String error, String message) {
		super(error, message);
	}

	public APIConnectionException(String message, Throwable e) {
		super(message, e);
	}

}
