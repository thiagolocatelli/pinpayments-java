package com.github.thiagolocatelli.pinpayments.net;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import com.github.thiagolocatelli.pinpayments.PinPayments;
import com.github.thiagolocatelli.pinpayments.exception.InvalidRequestException;
import com.github.thiagolocatelli.pinpayments.model.Charge;
import com.github.thiagolocatelli.pinpayments.model.Customer;

public class ClassUrlTest {

	@Test
	public void testChargeUrl() throws IOException {
		PinPayments.LIVE_MODE = true;
		String url = APIResource.classURL(Charge.class);
		assertEquals(url, "https://api.pin.net.au/1/charges");
	}

	@Test
	public void testChargeInstanceUrl() throws IOException, InvalidRequestException {
		PinPayments.LIVE_MODE = true;
		String url = APIResource.instanceURL(Charge.class, "ch_lfUYEBK14zotCTykezJkfg");
		assertEquals(url, "https://api.pin.net.au/1/charges/ch_lfUYEBK14zotCTykezJkfg");
	}
	
	@Test
	public void testCustomerUrl() throws IOException {
		PinPayments.LIVE_MODE = true;
		String url = APIResource.classURL(Customer.class);
		assertEquals(url, "https://api.pin.net.au/1/customers");
	}

	@Test
	public void testCustomerInstanceUrl() throws IOException, InvalidRequestException {
		PinPayments.LIVE_MODE = true;
		String url = APIResource.instanceURL(Customer.class, "cus_XZg1ULpWaROQCOT5PdwLkQ");
		assertEquals(url, "https://api.pin.net.au/1/customers/cus_XZg1ULpWaROQCOT5PdwLkQ");
	}
	
	public static void main(String args[]) {
		System.out.println(String.format("%s?%s", null, null));
	}

}
