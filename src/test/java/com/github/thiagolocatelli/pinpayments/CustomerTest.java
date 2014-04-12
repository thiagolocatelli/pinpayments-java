package com.github.thiagolocatelli.pinpayments;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.github.thiagolocatelli.pinpayments.exception.PinPaymentsException;
import com.github.thiagolocatelli.pinpayments.model.Card;
import com.github.thiagolocatelli.pinpayments.model.Customer;
import com.github.thiagolocatelli.pinpayments.model.CustomerCollection;

public class CustomerTest {

	@BeforeClass
	public static void beforeClass() {
		PinPayments.config("0q8LSKPxx76L4jiWe8ILGQ", false);	

		
	}	
	
	@Test
	public void testCustomerCreateWithCard() throws PinPaymentsException {
		Map<String, Object> cardParams = new HashMap<String, Object>();
		cardParams.put("number", "4200000000000000");
		cardParams.put("expiry_month", 12);
		cardParams.put("expiry_year", 2015);
		cardParams.put("cvc", 123);
		cardParams.put("name", "Roland Robot");
		cardParams.put("address_line1", "42 Sevenoaks St");
		cardParams.put("address_line2", "Apartment 5");
		cardParams.put("address_city", "Lathlain");
		cardParams.put("address_postcode", "6454");
		cardParams.put("address_state", "WA");
		cardParams.put("address_country", "Australia");

		Map<String, Object> customerParams = new HashMap<String, Object>();
		customerParams.put("email", "roland.robots@gmail.com");
		customerParams.put("card", cardParams);
		Customer customer = Customer.create(customerParams);
		assertThat(customer.getToken(), notNullValue());
	}
	
	@Test
	public void testCustomerCreateWithCardToken() throws PinPaymentsException {
		
		Map<String, Object> cardParams = new HashMap<String, Object>();
		cardParams.put("expiry_month", 12);
		cardParams.put("expiry_year", 2015);
		cardParams.put("cvc", 123);
		cardParams.put("name", "Roland Robot");
		cardParams.put("address_line1", "42 Sevenoaks St");
		cardParams.put("address_line2", "Apartment 5");
		cardParams.put("address_city", "Lathlain");
		cardParams.put("address_postcode", "6454");
		cardParams.put("address_state", "WA");
		cardParams.put("address_country", "Australia");
		cardParams.put("number", "4200000000000000");
		Card card = Card.create(cardParams);
		
		Map<String, Object> customerParams = new HashMap<String, Object>();
		customerParams.put("email", "roland.robots@gmail.com");
		customerParams.put("card_token", card.getToken());
		Customer customer = Customer.create(customerParams);
		assertThat(customer.getToken(), notNullValue());
	}	
	
	@Test
	public void testCustomerList() throws PinPaymentsException {
		
		CustomerCollection chargeCollection = Customer.list();
		assertThat(chargeCollection.getPagination(), notNullValue());
		assertTrue(chargeCollection.getPagination().getCount() > 0);
		
	}
	
}
