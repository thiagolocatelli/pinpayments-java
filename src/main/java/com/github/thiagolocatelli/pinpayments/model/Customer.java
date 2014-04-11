package com.github.thiagolocatelli.pinpayments.model;

import java.util.Map;

import com.github.thiagolocatelli.pinpayments.exception.APIConnectionException;
import com.github.thiagolocatelli.pinpayments.exception.APIException;
import com.github.thiagolocatelli.pinpayments.exception.AuthenticationException;
import com.github.thiagolocatelli.pinpayments.exception.InvalidRequestException;
import com.github.thiagolocatelli.pinpayments.exception.InvalidResourceException;
import com.github.thiagolocatelli.pinpayments.exception.ResourceNotFoundException;
import com.github.thiagolocatelli.pinpayments.net.APIResource;

public class Customer extends APIResource {

	String token;
	String email;
	String createdAt;
	Card card;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
	
	public static Customer create(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException, ResourceNotFoundException,
			InvalidResourceException {
		return create(params, null);
	}

	public static Customer create(Map<String, Object> params, String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException, ResourceNotFoundException,
			InvalidResourceException {
		return request(RequestMethod.POST, classURL(Customer.class), params,
				Customer.class, apiKey);
	}

	public static Customer retrieve(String token) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, APIException,
			ResourceNotFoundException, InvalidResourceException {
		return retrieve(token, null);
	}

	public static Customer retrieve(String token, String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException, ResourceNotFoundException,
			InvalidResourceException {
		return request(RequestMethod.GET, instanceURL(Customer.class, token),
				null, Customer.class, apiKey);
	}

	public Customer update(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException, ResourceNotFoundException,
			InvalidResourceException {
		return update(params, null);
	}

	public Customer update(Map<String, Object> params, String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException, ResourceNotFoundException,
			InvalidResourceException {
		return request(RequestMethod.PUT, instanceURL(Customer.class, token),
				params, Customer.class, apiKey);
	}

	public static CustomerCollection list() throws AuthenticationException,
			InvalidRequestException, APIConnectionException, APIException,
			ResourceNotFoundException, InvalidResourceException {
		return list(null);
	}

	public static CustomerCollection list(String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException, ResourceNotFoundException,
			InvalidResourceException {
		return request(RequestMethod.GET, classURL(Customer.class), null,
				CustomerCollection.class, apiKey);
	}

}
