package com.github.thiagolocatelli.pinpayments.exception;

public class APIException extends PinPaymentsException {

	private static final long serialVersionUID = 1L;

	public APIException(String message, Throwable e) {
		super(message, e);
	}

}
