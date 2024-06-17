package com.example.meatshop.Repo;

import com.example.meatshop.Entity.ProductCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductCartRepo extends JpaRepository<ProductCart,Integer> {
}
