package com.example.meatshop.Controller;

import com.example.meatshop.Entity.Payment;
import com.example.meatshop.Pojo.PaymentPojo;
import com.example.meatshop.Service.PaymentService;
import com.example.meatshop.Shared.GlobalApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequestMapping("/payment")
@RestController
@RequiredArgsConstructor

public class PaymentController {
    private final PaymentService paymentService;
    @GetMapping("/get")
    public GlobalApiResponse<List<Payment>> getData() {
        List<Payment> payments = paymentService.getAll();
        return GlobalApiResponse
                .<List<Payment>>builder()
                .data(payments)
                .statusCode(200)
                .message("Data retrieved successfully!")
                .build();
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody PaymentPojo paymentPojo) {
        if (!paymentService.existsById(id)) {
            return new ResponseEntity<>("Payment id" + id + " not found", HttpStatus.NOT_FOUND);
        } else {
            paymentService.updateData(id, paymentPojo);

        }
        return ResponseEntity.ok("Payment with ID " + id + " updated successfully");
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody PaymentPojo paymentPojo) {

        paymentService.addPayment(paymentPojo);
        return ResponseEntity.ok("Notices saved successfully");
    }
    @GetMapping("/get/{id}")
    public Optional<Payment> getData(@PathVariable Integer id) {

        return paymentService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        this.paymentService.deleteById(id);
    }
}
