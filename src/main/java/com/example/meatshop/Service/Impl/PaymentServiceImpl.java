package com.example.meatshop.Service.Impl;

import com.example.meatshop.Entity.Items;
import com.example.meatshop.Entity.Payment;
import com.example.meatshop.Pojo.ItemsPojo;
import com.example.meatshop.Pojo.PaymentPojo;
import com.example.meatshop.Repo.PaymentRepo;
import com.example.meatshop.Service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service

public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepo paymentRepo;
    @Override
    public void saveData(PaymentPojo paymentPojo) {
        Payment payment=new Payment();
        payment.setPaymentDate(paymentPojo.getPaymentDate());
//        payment.setOrderId(paymentPojo.getOrderId());
        payment.setCustomerId(paymentPojo.getCustomerId());
        paymentRepo.save(payment);

    }

    @Override
    public List<Payment> getAll() {
        return paymentRepo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        paymentRepo.deleteById(id.intValue());

    }

    @Override
    public Optional<Payment> findById(Long id) {
        return paymentRepo.findById(id.intValue());
    }

    public void updateData(Integer id, PaymentPojo paymentPojo) {
        Optional<Payment> paymentOptional = paymentRepo.findById(id);
        if (paymentOptional.isPresent()) {
            Payment existingPayment= paymentOptional.get();

            updatePayment(existingPayment, paymentPojo);
            paymentRepo.save(existingPayment);
        } else {

            throw new IllegalArgumentException("Items with ID " + id + " not found");
        }
    }
    private void updatePayment(Payment existingPayment, PaymentPojo paymentPojo) {
        if (existingPayment.getPaymentId()!= null) {
            existingPayment.setCustomerId(paymentPojo.getCustomerId());
            existingPayment.setPaymentDate(paymentPojo.getPaymentDate());
//            existingPayment.setOrderId(paymentPojo.getOrderId());
        }
        throw new IllegalArgumentException("Items with ID " +" not found");


    }

    @Override
    public boolean existsById(Integer id) {
        return paymentRepo.existsById(id.intValue());
    }
}
