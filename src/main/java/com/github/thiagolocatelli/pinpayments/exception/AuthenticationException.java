package com.github.thiagolocatelli.pinpayments.exception;

public class AuthenticationException extends PinPaymentsException {

	private static final long serialVersionUID = 1L;

	public AuthenticationException(String error, String message) {
		super(error, message);
	}

}
