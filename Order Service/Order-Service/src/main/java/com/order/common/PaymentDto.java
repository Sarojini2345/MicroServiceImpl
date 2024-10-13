package com.order.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
    private Long paymentId;
    private String paymentStatus;
    private String transactionId;
    private Long orderId;
    private Double amount;
}