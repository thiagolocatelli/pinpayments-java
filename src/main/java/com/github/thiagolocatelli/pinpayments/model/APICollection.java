package com.github.thiagolocatelli.pinpayments.model;

import java.util.List;

public abstract class APICollection<T> extends APIObject {

	List<T> response;
	Pagination pagination;

	public List<T> getResponse() {
		return response;
	}

	public void setResponse(List<T> response) {
		this.response = response;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

}
