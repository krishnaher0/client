package com.example.meatshop.Repo;

import com.example.meatshop.Entity.PaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDetailsRepo extends JpaRepository<PaymentDetails, Long> {

}
