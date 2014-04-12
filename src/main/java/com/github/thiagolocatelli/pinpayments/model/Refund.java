package com.github.thiagolocatelli.pinpayments.model;

import java.util.Map;

import com.github.thiagolocatelli.pinpayments.exception.APIConnectionException;
import com.github.thiagolocatelli.pinpayments.exception.APIException;
import com.github.thiagolocatelli.pinpayments.exception.AuthenticationException;
import com.github.thiagolocatelli.pinpayments.exception.InvalidRequestException;
import com.github.thiagolocatelli.pinpayments.exception.InvalidResourceException;
import com.github.thiagolocatelli.pinpayments.exception.ResourceNotFoundException;
import com.github.thiagolocatelli.pinpayments.net.APIResource;

public class Refund extends APIResource {

	String token;
	Boolean success;
	Integer amount;
	String currency;
	String charge;
	String createdAt;
	String errorMessage;
	String statusMessage;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
	public static Refund create(Map<String, Object> params, String token)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException, ResourceNotFoundException,
			InvalidResourceException {
		return create(params, token, null);
	}

	public static Refund create(Map<String, Object> params, String token, String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException, ResourceNotFoundException,
			InvalidResourceException {
		return request(RequestMethod.POST, instanceURL(Charge.class, token) + "/refunds", params,
				Refund.class, apiKey);
	}

	public static RefundCollection list(String token) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, APIException,
			ResourceNotFoundException, InvalidResourceException {
		return list(token, null);
	}

	public static RefundCollection list(String token, String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException, ResourceNotFoundException,
			InvalidResourceException {
		return request(RequestMethod.GET, instanceURL(Charge.class, token) + "/refunds", null,
				RefundCollection.class, apiKey);
	}	

}
