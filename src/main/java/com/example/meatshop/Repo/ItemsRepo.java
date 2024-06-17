package com.example.meatshop.Repo;

import com.example.meatshop.Entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepo extends JpaRepository<Items,Integer> {
}
