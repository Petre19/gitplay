package com.endava.google;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;

public class GsonExample {
    private static final Logger LOGGER = LogManager.getLogger(GsonExample.class);

    public static void main(String[] args) {
        Payment payment = new Payment();
        payment.setCustomerName("John Travolta");
        payment.setAmount(100.0);
        payment.setCurrency("RON");
        payment.setCardNumber("131232132131");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(payment);
        LOGGER.info("\n{}", json);
        Payment dPayment = gson.fromJson(json, Payment.class);
        LOGGER.info(payment.equals(dPayment));
        LOGGER.info(dPayment.getCardNumber());

    }
}