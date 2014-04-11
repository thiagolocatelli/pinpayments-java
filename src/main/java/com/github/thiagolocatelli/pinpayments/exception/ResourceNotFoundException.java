package com.github.thiagolocatelli.pinpayments.exception;

public class ResourceNotFoundException extends PinPaymentsException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String error, String message) {
		super(error, message);
	}

}
