package com.example.meatshop.Service;

import com.example.meatshop.Entity.Payment;
import com.example.meatshop.Pojo.PaymentPojo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public interface PaymentService {
    void saveData(PaymentPojo paymentPojo);
    List<Payment> getAll();
    void deleteById(Long id);
    Optional<Payment> findById(Long id);
    void updateData(Integer id, PaymentPojo paymentPojo);
    boolean existsById(Integer id);
}
