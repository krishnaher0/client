package com.example.meatshop.Service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



import com.example.meatshop.Entity.MeatCategory;
import com.example.meatshop.Pojo.CategoryPojo;
import com.example.meatshop.Repo.CategoryRepo;

import com.example.meatshop.Service.CategoryService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor


public class  CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;
    @Override
    public void saveData(CategoryPojo categoryPojo) {
        MeatCategory meatCategory=new MeatCategory();
        meatCategory.setCategoryName(categoryPojo.getCategoryName());
        meatCategory.setDescription(categoryPojo.getDescription());
        categoryRepo.save(meatCategory);

    }

    @Override
    public List<MeatCategory> getAll() {
        return categoryRepo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        categoryRepo.deleteById(id.intValue());

    }

    @Override
    public Optional<MeatCategory> findById(Long id) {
        return categoryRepo.findById(id.intValue());
    }



    public void updateData(Integer id, CategoryPojo categoryPojo) {
        Optional<MeatCategory> categoryOptional = categoryRepo.findById(id);
        if (categoryOptional.isPresent()) {
            MeatCategory existingCategory = categoryOptional.get();

            updateCategory(existingCategory, categoryPojo);
            categoryRepo.save(existingCategory);
        } else {

            throw new IllegalArgumentException("Student with ID " + id + " not found");
        }
    }
    private void updateCategory(MeatCategory existingCategory, CategoryPojo categoryPojo) {
        if (categoryPojo.getCategoryName() != null) {
            existingCategory.setCategoryName(categoryPojo.getCategoryName());
        }
        if (categoryPojo.getDescription() != null) {
            existingCategory.setDescription(categoryPojo.getDescription());
        }
        // Add more fields as needed
    }


    @Override
    public boolean existsById(Integer id) {
        return categoryRepo.existsById(id.intValue());
    }
}
