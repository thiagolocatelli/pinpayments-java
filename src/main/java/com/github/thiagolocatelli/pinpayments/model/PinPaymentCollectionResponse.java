package com.github.thiagolocatelli.pinpayments.model;

import com.google.gson.JsonArray;

public class PinPaymentCollectionResponse {

	JsonArray response;
	Pagination pagination;

	public JsonArray getResponse() {
		return response;
	}

	public void setResponse(JsonArray response) {
		this.response = response;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

}
