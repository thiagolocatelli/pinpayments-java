package com.github.thiagolocatelli.pinpayments.exception;

public abstract class PinPaymentsException extends Exception {

	private String error;
	private String message;

	public PinPaymentsException(String message, Throwable e) {
		super(message, e);
		this.message = message;
	}

	public PinPaymentsException(String error, String message) {
		super(message, null);
		this.error = error;
		this.message = message;
	}

	public PinPaymentsException(String error, String message, Throwable e) {
		super(message, e);
		this.error = error;
		this.message = message;
	}

	private static final long serialVersionUID = 1L;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
