package com.example.meatshop.Repo;

import com.example.meatshop.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PaymentRepo extends JpaRepository<Payment,Integer> {
}
