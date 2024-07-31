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
@Service
@RequiredArgsConstructor

public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepo paymentRepo;
    @Override
    public void addPayment(PaymentPojo paymentPojo) {
        Payment payment=new Payment();
        payment.setAmount(paymentPojo.getAmount());
        payment.setType(paymentPojo.getType());
        payment.setDate(paymentPojo.getDate());
        payment.setItems(paymentPojo.getItems());
        payment.setId(paymentPojo.getId());
        payment.setCustomer(paymentPojo.getCustomer());
        paymentRepo.save(payment);
    }

    @Override
    public void deleteById(Integer id) {
        paymentRepo.deleteById(id);

    }

    @Override
    public List<Payment> getAll() {
        return paymentRepo.findAll();
    }

    @Override
    public Optional<Payment> findById(Integer id) {
        return paymentRepo.findById(id);
    }


    @Override
    public void updateData(Integer id, PaymentPojo paymentPojo) {
        Optional<Payment> paymentOptional = paymentRepo.findById(id);
//        if (itemsOptional.isPresent()) {
        Payment existingPayment = paymentOptional.get();
        // Update the existing student with the data from studentPojo
        updateStudentProperties(existingPayment, paymentPojo);
        paymentRepo.save(existingPayment); // Save the updated student

    }

    // Helper method to update properties of Student based on StudentPojo
    private void updateStudentProperties(Payment payment, PaymentPojo paymentPojo) {
        payment.setAmount(paymentPojo.getAmount());
        payment.setType(paymentPojo.getType());
        payment.setDate(paymentPojo.getDate());
        payment.setItems(paymentPojo.getItems());
        payment.setId(paymentPojo.getId());
        payment.setCustomer(paymentPojo.getCustomer());
        paymentRepo.save(payment);
    }

    @Override
    public boolean existsById(Integer id) {
        return paymentRepo.existsById(id);
    }


}
