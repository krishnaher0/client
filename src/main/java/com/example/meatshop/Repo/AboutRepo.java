package com.example.meatshop.Repo;

import com.example.meatshop.Entity.About;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRepo extends JpaRepository<About,Integer> {
}
