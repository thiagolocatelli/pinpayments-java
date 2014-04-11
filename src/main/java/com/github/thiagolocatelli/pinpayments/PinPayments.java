package com.github.thiagolocatelli.pinpayments;

public abstract class PinPayments
{
	public static boolean LIVE_MODE = false;
	public static final String TEST_API_BASE = "https://test-api.pin.net.au";
	public static final String LIVE_API_BASE = "https://api.pin.net.au";
	public static final String VERSION = "1";
	public static String apiKey;
	public static String apiVersion;

	private static String apiBase = LIVE_API_BASE;

	/**
	 * (FOR TESTING ONLY)
	 * If you'd like your API requests to hit your own (mocked) server,
	 * you can set this up here by overriding the base api URL.
	 */
	public static void overrideApiBase(final String overriddenApiBase) {
		apiBase = overriddenApiBase;
	}
	
	public static void config(String apiKey, boolean liveMode) {
		PinPayments.apiKey = apiKey;
		LIVE_MODE = liveMode;
	}

	public static String getApiBase() {
		if(LIVE_MODE)
			return apiBase;
		else
			return TEST_API_BASE;
	}
}
