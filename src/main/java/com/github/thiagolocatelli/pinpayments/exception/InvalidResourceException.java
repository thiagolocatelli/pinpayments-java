package com.github.thiagolocatelli.pinpayments.exception;

import java.util.List;

import com.github.thiagolocatelli.pinpayments.net.APIResource.ErrorMessage;

public class InvalidResourceException extends PinPaymentsException {

	private static final long serialVersionUID = 1L;

	private final List<ErrorMessage> messages;

	public InvalidResourceException(String error, String message,
			List<ErrorMessage> messages) {
		super(error, message);
		this.messages = messages;
	}

	public List<ErrorMessage> getMessages() {
		return messages;
	}

}
