package com.github.thiagolocatelli.pinpayments.model;

import java.util.Map;

import com.github.thiagolocatelli.pinpayments.exception.APIConnectionException;
import com.github.thiagolocatelli.pinpayments.exception.APIException;
import com.github.thiagolocatelli.pinpayments.exception.AuthenticationException;
import com.github.thiagolocatelli.pinpayments.exception.InvalidRequestException;
import com.github.thiagolocatelli.pinpayments.exception.InvalidResourceException;
import com.github.thiagolocatelli.pinpayments.exception.ResourceNotFoundException;
import com.github.thiagolocatelli.pinpayments.net.APIResource;

public class Card extends APIResource {

	String token;
	String displayNumber;
	Integer expiryMonth;
	Integer expiryYear;
	String name;
	String addressLine1;
	String addressLine2;
	String addressCity;
	String addressPostcode;
	String addressState;
	String addressCountry;
	String scheme;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getDisplayNumber() {
		return displayNumber;
	}

	public void setDisplayNumber(String displayNumber) {
		this.displayNumber = displayNumber;
	}

	public Integer getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(Integer expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public Integer getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(Integer expiryYear) {
		this.expiryYear = expiryYear;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressPostcode() {
		return addressPostcode;
	}

	public void setAddressPostcode(String addressPostcode) {
		this.addressPostcode = addressPostcode;
	}

	public String getAddressState() {
		return addressState;
	}

	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}

	public String getAddressCountry() {
		return addressCountry;
	}

	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}

	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	public static Card create(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException, ResourceNotFoundException,
			InvalidResourceException {
		return create(params, null);
	}

	public static Card create(Map<String, Object> params, String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException, ResourceNotFoundException,
			InvalidResourceException {
		return request(RequestMethod.POST, classURL(Card.class), params,
				Card.class, apiKey);
	}

}
