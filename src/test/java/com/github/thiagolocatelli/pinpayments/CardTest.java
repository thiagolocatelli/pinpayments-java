package com.github.thiagolocatelli.pinpayments;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.github.thiagolocatelli.pinpayments.exception.PinPaymentsException;
import com.github.thiagolocatelli.pinpayments.model.Card;


public class CardTest {
	
	static Map<String, Object> defaultCardParams = new HashMap<String, Object>();
	
	@BeforeClass
	public static void beforeClass() {
		PinPayments.config("0q8LSKPxx76L4jiWe8ILGQ", false);	

		defaultCardParams.put("expiry_month", 12);
		defaultCardParams.put("expiry_year", 2015);
		defaultCardParams.put("cvc", 123);
		defaultCardParams.put("name", "Roland Robot");
		defaultCardParams.put("address_line1", "42 Sevenoaks St");
		defaultCardParams.put("address_line2", "Apartment 5");
		defaultCardParams.put("address_city", "Lathlain");
		defaultCardParams.put("address_postcode", "6454");
		defaultCardParams.put("address_state", "WA");
		defaultCardParams.put("address_country", "Australia");
	}

	@Test
	public void testCreateToken() throws PinPaymentsException {
		Map<String, Object> cardParams = new HashMap<String, Object>();
		cardParams.putAll(defaultCardParams);
		cardParams.put("number", "4200000000000000");
		Card card = Card.create(cardParams);
		assertThat(card.getToken(), notNullValue());
	}
	
	@Test
	public void testCreateTokenVisa() throws PinPaymentsException {
		Map<String, Object> cardParams = new HashMap<String, Object>();
		cardParams.putAll(defaultCardParams);
		cardParams.put("number", "4200000000000000");
		Card card = Card.create(cardParams);
		assertEquals(card.getScheme(), "visa");
	}
	

	@Test
	public void testCreateTokenMasterCard() throws PinPaymentsException {
		Map<String, Object> cardParams = new HashMap<String, Object>();
		cardParams.putAll(defaultCardParams);
		cardParams.put("number", "5520000000000000");
		Card card = Card.create(cardParams);
		assertEquals(card.getScheme(), "master");
	}
	
	@Test(expected = PinPaymentsException.class)
	public void testInvalidResourceVisa() throws PinPaymentsException {
		Map<String, Object> cardParams = new HashMap<String, Object>();
		cardParams.putAll(defaultCardParams);
		Card.create(cardParams);
	}
	
}
