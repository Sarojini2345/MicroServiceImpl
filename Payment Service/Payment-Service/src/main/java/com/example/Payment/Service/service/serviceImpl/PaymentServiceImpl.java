package com.example.Payment.Service.service.serviceImpl;

import com.example.Payment.Service.entity.Payment;
import com.example.Payment.Service.repository.PaymentRepository;
import com.example.Payment.Service.service.PaymentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;


    @Override
    public Payment savePayment(Payment payment) throws JsonProcessingException {
        payment.setTransactionId(UUID.randomUUID().toString());
        payment.setPaymentStatus(paymentProcessing());
        log.info("In Payment-service "+new ObjectMapper().writeValueAsString(payment));
        return paymentRepository.save(payment);
    }


    public String paymentProcessing(){
        return new Random().nextBoolean()?"Success":"false";
    }
}