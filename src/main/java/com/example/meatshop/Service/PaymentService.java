package com.example.meatshop.Service;


import com.example.meatshop.Entity.Payment;
import com.example.meatshop.Pojo.PaymentPojo;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    void addPayment(PaymentPojo paymentPojo);

    void deleteById(Integer id);

    List<Payment> getAll();

    Optional<Payment> findById(Integer id);
    void updateData(Integer id, PaymentPojo paymentPojo);
    boolean existsById(Integer id);

}
