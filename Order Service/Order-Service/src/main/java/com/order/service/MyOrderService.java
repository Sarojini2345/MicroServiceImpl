package com.order.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.order.payload.TransactionRequest;
import com.order.payload.TransactionResponse;

public interface MyOrderService {

    public TransactionResponse saveOrder(TransactionRequest order) throws JsonProcessingException;
}
