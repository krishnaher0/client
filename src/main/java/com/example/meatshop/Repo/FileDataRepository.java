package com.example.meatshop.Repo;

import com.example.meatshop.Entity.FileData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FileDataRepository extends JpaRepository<FileData,Long> {
    List<FileData> findByName(String fileName);
}
