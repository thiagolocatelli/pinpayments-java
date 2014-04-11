package com.github.thiagolocatelli.pinpayments.model;

import com.google.gson.JsonObject;

public class PinPaymentResponse {

	JsonObject response;
	Pagination pagination;

	public JsonObject getResponse() {
		return response;
	}

	public void setResponse(JsonObject response) {
		this.response = response;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

}
