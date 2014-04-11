package com.github.thiagolocatelli.pinpayments;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.github.thiagolocatelli.pinpayments.exception.PinPaymentsException;
import com.github.thiagolocatelli.pinpayments.model.Card;
import com.github.thiagolocatelli.pinpayments.model.Charge;
import com.github.thiagolocatelli.pinpayments.model.ChargeCollection;

public class ChargeTest {

	static Map<String, Object> defaultCardTokenParams = new HashMap<String, Object>();
	static Map<String, Object> defaultCardParams = new HashMap<String, Object>();
	static Map<String, Object> defaultChargeParams = new HashMap<String, Object>();
	
	@BeforeClass
	public static void beforeClass() {
		PinPayments.config("0q8LSKPxx76L4jiWe8ILGQ", false);	

		defaultCardTokenParams.put("expiry_month", 12);
		defaultCardTokenParams.put("expiry_year", 2015);
		defaultCardTokenParams.put("cvc", 123);
		defaultCardTokenParams.put("name", "Roland Robot");
		defaultCardTokenParams.put("address_line1", "42 Sevenoaks St");
		defaultCardTokenParams.put("address_line2", "Apartment 5");
		defaultCardTokenParams.put("address_city", "Lathlain");
		defaultCardTokenParams.put("address_postcode", "6454");
		defaultCardTokenParams.put("address_state", "WA");
		defaultCardTokenParams.put("address_country", "Australia");
		
		defaultCardParams.put("card[expiry_month]", 12);
		defaultCardParams.put("card[expiry_year]", 2015);
		defaultCardParams.put("card[cvc]", 123);
		defaultCardParams.put("card[name]", "Roland Robot");
		defaultCardParams.put("card[address_line1]", "42 Sevenoaks St");
		defaultCardParams.put("card[address_line2]", "Apartment 5");
		defaultCardParams.put("card[address_city]", "Lathlain");
		defaultCardParams.put("card[address_postcode]", "6454");
		defaultCardParams.put("card[address_state]", "WA");
		defaultCardParams.put("card[address_country]", "Australia");

		defaultChargeParams.put("email", "thiago.locatelli@gmail.com");
		defaultChargeParams.put("description", "Pin Payments Java Bindings tests");
		defaultChargeParams.put("amount", 199);
		defaultChargeParams.put("ip_address", "127.0.0.1");
		defaultChargeParams.put("currency", "AUD");
		
	}
	
	@Test
	public void testChargeWithCardToken() throws PinPaymentsException {
		
		//Create card token first
		Map<String, Object> cardParams = new HashMap<String, Object>();
		cardParams.putAll(defaultCardTokenParams);
		cardParams.put("number", "4200000000000000");
		Card card = Card.create(cardParams);
		assertThat(card.getToken(), notNullValue());
		
		//Create charge with card token
		Map<String, Object> chargeParams = new HashMap<String, Object>();
		chargeParams.putAll(defaultChargeParams);
		chargeParams.put("card_token", card.getToken());
		Charge charge = Charge.create(chargeParams);
		assertThat(charge.getToken(), notNullValue());
		
	}
	
	@Test
	public void testChargeWithCard() throws PinPaymentsException {
		
		//create charge with card information inline
		Map<String, Object> chargeParams = new HashMap<String, Object>();
		chargeParams.putAll(defaultChargeParams);
		chargeParams.putAll(defaultCardParams);
		chargeParams.put("card[number]", "4200000000000000");
		Charge charge = Charge.create(chargeParams);
		assertThat(charge.getToken(), notNullValue());
		
	}
	
	//@Test
	public void testChargeWithCardDeclined() throws PinPaymentsException {
		
		//create charge with card information inline
		Map<String, Object> chargeParams = new HashMap<String, Object>();
		chargeParams.putAll(defaultChargeParams);
		chargeParams.putAll(defaultCardParams);
		chargeParams.put("card[number]", "4100000000000001");
		Charge charge = Charge.create(chargeParams);
		assertThat(charge.getToken(), notNullValue());
		
	}
	
	//@Test
	public void testChargeWithInsufficientFunds() throws PinPaymentsException {
		
		//create charge with card information inline
		Map<String, Object> chargeParams = new HashMap<String, Object>();
		chargeParams.putAll(defaultChargeParams);
		chargeParams.putAll(defaultCardParams);
		chargeParams.put("card[number]", "4000000000000002");
		Charge charge = Charge.create(chargeParams);
		assertThat(charge.getToken(), notNullValue());
		
	}
	
	//@Test
	public void testChargeWithInvalidCard() throws PinPaymentsException {
		
		//create charge with card information inline
		Map<String, Object> chargeParams = new HashMap<String, Object>();
		chargeParams.putAll(defaultChargeParams);
		chargeParams.putAll(defaultCardParams);
		chargeParams.put("card[number]", "4800000000000004");
		Charge charge = Charge.create(chargeParams);
		assertThat(charge.getToken(), notNullValue());
		
	}
	
	@Test
	public void testChargeSearch() throws PinPaymentsException {
		
		Map<String, Object> searchParams = new HashMap<String, Object>();
		searchParams.put("query", "Java Bindings");
		ChargeCollection chargeCollection = Charge.search(searchParams);
		assertThat(chargeCollection.getPagination(), notNullValue());
		
	}
	
}
