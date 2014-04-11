package com.github.thiagolocatelli.pinpayments.deserializer;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class DateDeserializer  implements JsonDeserializer<Date> {
	
	public Date deserialize(JsonElement element, Type arg1, JsonDeserializationContext arg2) throws JsonParseException {
		String date = element.getAsString();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'");
		formatter.setTimeZone(TimeZone.getTimeZone("Australia/Sydney"));
		
		try {
			return formatter.parse(date);
		} catch (ParseException e) {
			throw new JsonParseException(e);
		}
	}
}
