package com.order.serviceclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.order.common.PaymentDto;

@FeignClient(name = "PAYMENT-SERVICE")
public interface PaymentService{
 
	 @PostMapping("/api/payments/doPayment")
	  PaymentDto doPayment(@RequestBody PaymentDto paymentDto);
}
