package com.example.Payment.Service.service;

import com.example.Payment.Service.entity.Payment;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface PaymentService {

    public Payment savePayment(Payment payment) throws JsonProcessingException;
}
