package com.github.thiagolocatelli.pinpayments;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.github.thiagolocatelli.pinpayments.exception.PinPaymentsException;
import com.github.thiagolocatelli.pinpayments.model.Charge;
import com.github.thiagolocatelli.pinpayments.model.Refund;
import com.github.thiagolocatelli.pinpayments.model.RefundCollection;

public class RefundTest {

	static Map<String, Object> defaultCardParams = new HashMap<String, Object>();
	static Map<String, Object> defaultChargeParams = new HashMap<String, Object>();
	
	@BeforeClass
	public static void beforeClass() {
		
		PinPayments.config("0q8LSKPxx76L4jiWe8ILGQ", false);	
		
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

		defaultChargeParams.put("email", "roland.robots@gmail.com");
		defaultChargeParams.put("description", "Refund Junit Tests");
		defaultChargeParams.put("amount", 1099);
		defaultChargeParams.put("ip_address", "127.0.0.1");
		defaultChargeParams.put("currency", "AUD");
		
	}
	
	@Test
	public void testCreateFullRefund() throws PinPaymentsException {
		
		//create charge with card information inline
		Map<String, Object> chargeParams = new HashMap<String, Object>();
		chargeParams.putAll(defaultChargeParams);
		chargeParams.putAll(defaultCardParams);
		chargeParams.put("card[number]", "4200000000000000");
		Charge charge = Charge.create(chargeParams);
		assertThat(charge.getToken(), notNullValue());

		
		Refund refund = Refund.create(null, charge.getToken());
		assertThat(refund.getToken(), notNullValue());
		assertEquals(refund.getCharge(), charge.getToken());
		
	}
	
	@Test
	public void testCreatePartialRefund() throws PinPaymentsException {
		
		//create charge with card information inline
		Map<String, Object> chargeParams = new HashMap<String, Object>();
		chargeParams.putAll(defaultChargeParams);
		chargeParams.putAll(defaultCardParams);
		chargeParams.put("card[number]", "4200000000000000");
		Charge charge = Charge.create(chargeParams);
		assertThat(charge.getToken(), notNullValue());

		Map<String, Object> refundParams = new HashMap<String, Object>();
		refundParams.put("amount", 599);
		Refund refund = Refund.create(refundParams, charge.getToken());
		assertThat(refund.getToken(), notNullValue());
		assertEquals(refund.getCharge(), charge.getToken());
		
	}
	

	
	@Test
	public void testListRefunds() throws PinPaymentsException {
		
		//create charge with card information inline
		Map<String, Object> chargeParams = new HashMap<String, Object>();
		chargeParams.putAll(defaultChargeParams);
		chargeParams.putAll(defaultCardParams);
		chargeParams.put("card[number]", "4200000000000000");
		Charge charge = Charge.create(chargeParams);
		assertThat(charge.getToken(), notNullValue());

		Map<String, Object> refundParams = new HashMap<String, Object>();
		refundParams.put("amount", 299);
		Refund refund1 = Refund.create(refundParams, charge.getToken());
		assertThat(refund1.getToken(), notNullValue());
		assertEquals(refund1.getCharge(), charge.getToken());
		
		refundParams.put("amount", 399);
		Refund refund2 = Refund.create(refundParams, charge.getToken());
		assertThat(refund2.getToken(), notNullValue());
		assertEquals(refund2.getCharge(), charge.getToken());
		
		Charge refundedCharge = Charge.retrieve(charge.getToken());
		RefundCollection refunds = Refund.list(refundedCharge.getToken());
		assertThat(refunds.getResponse(), notNullValue());
		
	}
	
}
