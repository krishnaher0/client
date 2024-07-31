package com.example.meatshop.Repo;

import com.example.meatshop.Entity.MeatCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CategoryRepo extends JpaRepository<MeatCategory,Integer> {
}
