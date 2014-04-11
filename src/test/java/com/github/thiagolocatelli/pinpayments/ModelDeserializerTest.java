package com.github.thiagolocatelli.pinpayments;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import com.github.thiagolocatelli.pinpayments.model.APIObject;
import com.github.thiagolocatelli.pinpayments.model.Card;
import com.github.thiagolocatelli.pinpayments.model.Charge;
import com.github.thiagolocatelli.pinpayments.model.ChargeCollection;
import com.github.thiagolocatelli.pinpayments.model.Customer;
import com.github.thiagolocatelli.pinpayments.model.CustomerCollection;
import com.github.thiagolocatelli.pinpayments.model.RefundCollection;
import com.github.thiagolocatelli.pinpayments.net.APIResource;
import com.google.gson.Gson;

public class ModelDeserializerTest {

	private static Gson gson = APIResource.GSON;

	@Test
	public void deserializeChargeAttributes() throws IOException {
		String json = resource("charge.json");
		Charge charge = gson.fromJson(json, Charge.class);
		assertThat(charge.getAmount(), notNullValue());
	}

	@Test
	public void deserializeCardEvent() throws IOException {
		String json = resource("card.json");
		Card card = APIObject.PRETTY_PRINT_GSON.fromJson(json, Card.class);
		assertEquals(card.getToken(), "card_nytGw7koRg23EEp9NTmz9w");
	}

	@Test
	public void deserializeCustomerEvent() throws IOException {
		String json = resource("customer.json");
		Customer customer = APIObject.PRETTY_PRINT_GSON.fromJson(json,
				Customer.class);
		assertEquals(customer.getEmail(), "roland@pin.net.auu");
	}

	@Test
	public void deserializeChargeCollection() throws IOException {
		String json = resource("charges.json");
		ChargeCollection charges = gson.fromJson(json, ChargeCollection.class);
		assertThat(charges.getPagination().getPerPage(), notNullValue());
	}

	@Test
	public void deserializeCustomerCollection() throws IOException {
		String json = resource("customers.json");
		CustomerCollection customers = APIObject.PRETTY_PRINT_GSON.fromJson(
				json, CustomerCollection.class);
		assertThat(customers.getPagination().getPerPage(), notNullValue());
	}

	@Test
	public void deserializeRefundCollection() throws IOException {
		String json = resource("refunds.json");
		RefundCollection refunds = APIObject.PRETTY_PRINT_GSON.fromJson(json,
				RefundCollection.class);
		assertThat(refunds.getPagination().getPerPage(), notNullValue());
	}

	private String resource(String path) throws IOException {
		InputStream resource = getClass().getResourceAsStream(path);

		ByteArrayOutputStream os = new ByteArrayOutputStream(1024);
		byte[] buf = new byte[1024];

		for (int i = resource.read(buf); i > 0; i = resource.read(buf)) {
			os.write(buf, 0, i);
		}

		return os.toString("utf8");

	}
}
