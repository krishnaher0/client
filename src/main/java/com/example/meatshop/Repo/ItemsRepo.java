package com.example.meatshop.Repo;

import com.example.meatshop.Entity.Items;
import org.springframework.stereotype.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
@Repository

public interface ItemsRepo extends JpaRepository<Items,Integer> {
}
