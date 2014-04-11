package com.github.thiagolocatelli.pinpayments.exception;

public class InvalidRequestException extends PinPaymentsException {

	private static final long serialVersionUID = 1L;

	public InvalidRequestException(String error, String message) {
		super(error, message);
	}

}
