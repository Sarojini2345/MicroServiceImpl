package com.order.controller;

import com.order.payload.TransactionRequest;
import com.order.payload.TransactionResponse;
import com.order.service.MyOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private MyOrderService orderService;

    @PostMapping("/book/order")
    public ResponseEntity<TransactionResponse> createOrder(@RequestBody TransactionRequest order) {
        //Order savedOrder = orderService.saveOrder(order);
       // return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    	TransactionResponse response=null;
    	try {
    		response= orderService.saveOrder(order);
    	}catch (Exception e) {
			// TODO: handle exception
    		e.printStackTrace();
		}
		return ResponseEntity.ok(response);
    }
}