package com.github.thiagolocatelli.pinpayments.model;

import java.util.Date;
import java.util.Map;

import com.github.thiagolocatelli.pinpayments.exception.APIConnectionException;
import com.github.thiagolocatelli.pinpayments.exception.APIException;
import com.github.thiagolocatelli.pinpayments.exception.AuthenticationException;
import com.github.thiagolocatelli.pinpayments.exception.InvalidRequestException;
import com.github.thiagolocatelli.pinpayments.exception.InvalidResourceException;
import com.github.thiagolocatelli.pinpayments.exception.ResourceNotFoundException;
import com.github.thiagolocatelli.pinpayments.net.APIResource;

public class Charge extends APIResource {

	String token;
	Boolean success;
	Integer amount;
	String currency;
	String description;
	String email;
	String ipAddress;
	Date createdAt;
	String statusMessage;
	String errorMessage;
	Card card;
	Boolean captured;
	Boolean authorisationExpired;
	String transfer;
	String settlementCurrency;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public Boolean getCaptured() {
		return captured;
	}

	public void setCaptured(Boolean captured) {
		this.captured = captured;
	}

	public Boolean getAuthorisationExpired() {
		return authorisationExpired;
	}

	public void setAuthorisationExpired(Boolean authorisationExpired) {
		this.authorisationExpired = authorisationExpired;
	}

	public String getTransfer() {
		return transfer;
	}

	public void setTransfer(String transfer) {
		this.transfer = transfer;
	}

	public String getSettlementCurrency() {
		return settlementCurrency;
	}

	public void setSettlementCurrency(String settlementCurrency) {
		this.settlementCurrency = settlementCurrency;
	}

	public static Charge create(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException, ResourceNotFoundException,
			InvalidResourceException {
		return create(params, null);
	}

	public static Charge create(Map<String, Object> params, String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException, ResourceNotFoundException,
			InvalidResourceException {
		return request(RequestMethod.POST, classURL(Charge.class), params,
				Charge.class, apiKey);
	}

	public static Charge retrieve(String token) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, APIException,
			ResourceNotFoundException, InvalidResourceException {
		return retrieve(token, null);
	}

	public static Charge retrieve(String token, String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException, ResourceNotFoundException,
			InvalidResourceException {
		return request(RequestMethod.GET, instanceURL(Charge.class, token),
				null, Charge.class, apiKey);
	}

	public static Charge capture(String token) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, APIException,
			ResourceNotFoundException, InvalidResourceException {
		return capture(token, null);
	}

	public static Charge capture(String token, String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException, ResourceNotFoundException,
			InvalidResourceException {
		return request(RequestMethod.GET, instanceURL(Charge.class, token) + "/capture",
				null, Charge.class, apiKey);
	}

	public Charge update(Map<String, Object> params)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException, ResourceNotFoundException,
			InvalidResourceException {
		return update(params, null);
	}

	public Charge update(Map<String, Object> params, String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException, ResourceNotFoundException,
			InvalidResourceException {
		return request(RequestMethod.PUT, instanceURL(Charge.class, token),
				params, Charge.class, apiKey);
	}

	public static ChargeCollection list() throws AuthenticationException,
			InvalidRequestException, APIConnectionException, APIException,
			ResourceNotFoundException, InvalidResourceException {
		return list(null);
	}

	public static ChargeCollection list(String apiKey)
			throws AuthenticationException, InvalidRequestException,
			APIConnectionException, APIException, ResourceNotFoundException,
			InvalidResourceException {
		return request(RequestMethod.GET, classURL(Charge.class), null,
				ChargeCollection.class, apiKey);
	}

	public static ChargeCollection search(Map<String, Object> params) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, APIException,
			ResourceNotFoundException, InvalidResourceException {
		return search(params, null);
	}

	public static ChargeCollection search(Map<String, Object> params,
			String apiKey) throws AuthenticationException,
			InvalidRequestException, APIConnectionException, APIException,
			ResourceNotFoundException, InvalidResourceException {
		return request(RequestMethod.GET, instanceURL(Charge.class, "search"),
				params, ChargeCollection.class, apiKey);
	}

}
