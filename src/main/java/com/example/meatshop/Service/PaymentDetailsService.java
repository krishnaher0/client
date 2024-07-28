package com.example.meatshop.Service;

import com.example.meatshop.Pojo.PaymentDetailsPojo;

import java.util.List;

public interface PaymentDetailsService {
    void processPayment(PaymentDetailsPojo paymentDetails);
    List<PaymentDetailsPojo> getAllPayments();
    Long paymentCount();
}
