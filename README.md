# Pin Payments Java Bindings

You can sign up for a Pin Payments account at https://pin.net.au.

Requirements
============

Java 1.5 and later.

Installation
============

### Maven users

Add this dependency to your project's POM:

    <dependency>
      <groupId>com.github.thiagolocatelli</groupId>
      <artifactId>pinpayments-java</artifactId>
      <version>1.0</version>
    </dependency>
    
### Others

Download the project and build on your local workspace

Usage
=====

PinPaymentExample.java

    import java.util.HashMap;
    import java.util.Map;

    import com.stripe.Stripe;
    import com.stripe.exception.StripeException;
    import com.stripe.model.Charge;

    public class StripeExample {

        public static void main(String[] args) {
            PinPayments.apiKey = "YOUR-SECRET-KEY";
            Map<String, Object> chargeMap = new HashMap<String, Object>();
            chargeMap.put("amount", 100);
            chargeMap.put("currency", "usd");
            Map<String, Object> cardMap = new HashMap<String, Object>();
            cardMap.put("number", "4242424242424242");
            cardMap.put("exp_month", 12);
            cardMap.put("exp_year", 2020);
            chargeMap.put("card", cardMap);
            try {
                Charge charge = Charge.create(chargeMap);
                System.out.println(charge);
            } catch (StripeException e) {
                e.printStackTrace();
            }
        }
    }

Testing
=======

You must have Maven installed. To run the tests, simply run `mvn test`. You can run particular tests by passing `-D test=Class#method` -- for example, `-D test=StripeTest#testPlanCreate`.
