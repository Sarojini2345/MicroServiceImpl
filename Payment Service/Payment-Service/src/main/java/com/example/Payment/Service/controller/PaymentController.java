package com.example.Payment.Service.controller;


import com.example.Payment.Service.entity.Payment;
import com.example.Payment.Service.service.PaymentService;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/doPayment")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
    	Payment savedPayment=null;
    	try {
         savedPayment = paymentService.savePayment(payment);
    	}catch (Exception e) {
			// TODO: handle exception
    		e.printStackTrace();
		}
        return new ResponseEntity<>(savedPayment, HttpStatus.CREATED);
    }

    @GetMapping("/doPay")
    public ResponseEntity<String> getMessage(){
        return ResponseEntity.ok("Hi");
    }
}