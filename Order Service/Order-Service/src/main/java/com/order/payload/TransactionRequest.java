package com.order.payload;

import com.order.common.PaymentDto;
import com.order.entity.Order;
import lombok.Data;

@Data
public class TransactionRequest {
    private Order order;
    private PaymentDto paymentDto;
}
