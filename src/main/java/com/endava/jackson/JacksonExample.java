package com.endava.jackson;

import com.endava.google.Payment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JacksonExample {
    private static final Logger LOGGER = LogManager.getLogger(JacksonExample.class);

    public static void main(String[] args) throws JsonProcessingException {
        Payment payment = new Payment();
        payment.setCardNumber("21231211");
        payment.setCurrency("EUR");
        payment.setAmount(1000.32);
        payment.setCustomerName("Ionel Cercel");

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(payment);
        LOGGER.info(json);
        Payment dPayment=objectMapper.readValue(json,Payment.class);
        LOGGER.info(dPayment.equals(payment));
    }
}
