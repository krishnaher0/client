package com.example.meatshop.Pojo;

import com.example.meatshop.Entity.Customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PaymentPojo {
    private Integer paymentId;
    private LocalDate paymentDate;
//    private Order orderId;
    private Customer customerId;
}
