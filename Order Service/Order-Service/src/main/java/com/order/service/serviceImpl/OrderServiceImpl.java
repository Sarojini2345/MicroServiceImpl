package com.order.service.serviceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.common.PaymentDto;
import com.order.entity.Order;
import com.order.payload.TransactionRequest;
import com.order.payload.TransactionResponse;
import com.order.repository.OrderRepository;
import com.order.service.MyOrderService;
import com.order.serviceclient.PaymentService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class OrderServiceImpl implements MyOrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private PaymentService paymentService;

    @Override
    public TransactionResponse saveOrder(TransactionRequest request) throws JsonProcessingException{
        Order order=request.getOrder();
        PaymentDto paymentDto=request.getPaymentDto();
        System.out.println(order.getOrderId());
        System.out.println(paymentDto);
        Order savedOrder = orderRepository.save(order);
        paymentDto.setOrderId(savedOrder.getOrderId());
        paymentDto.setAmount(savedOrder.getTotalAmount());
        log.info("Sending request to payment-service from Order-service ");
      //  PaymentDto paymentDto1 = restTemplate.postForObject("http://PAYMENT-SERVICE/api/payments/doPayment", paymentDto, PaymentDto.class);
        PaymentDto paymentDto1 = paymentService.doPayment(paymentDto);
        log.info("from Orderservice "+new ObjectMapper().writeValueAsString(paymentDto1));
        System.out.println(paymentDto1.getPaymentStatus());
        String msg = paymentDto1.getPaymentStatus().equalsIgnoreCase("success") ? "payment successfull" : "Payment failed,please try again";
        return new TransactionResponse(order,paymentDto1.getAmount(),paymentDto1.getTransactionId(),msg);
    }
}