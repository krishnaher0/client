package com.example.meatshop.Service;

import com.example.meatshop.Entity.MeatCategory;
import com.example.meatshop.Pojo.CategoryPojo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public interface CategoryService {
    void saveData(CategoryPojo categoryPojo);
    List<MeatCategory> getAll();
    void deleteById(Long id);
    Optional<MeatCategory> findById(Long id);
    void updateData(Integer id, CategoryPojo categoryPojo);
    boolean existsById(Integer id);
}
