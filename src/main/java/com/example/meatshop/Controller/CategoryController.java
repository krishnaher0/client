package com.example.meatshop.Controller;

import com.example.meatshop.Entity.Customer;
import com.example.meatshop.Entity.MeatCategory;
import com.example.meatshop.Pojo.CategoryPojo;
import com.example.meatshop.Pojo.CustomerPojo;
import com.example.meatshop.Service.CategoryService;
import com.example.meatshop.Service.CustomerService;
import com.example.meatshop.Shared.GlobalApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@RestController
@RequestMapping("/category")

public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping(value = "/get", produces = "application/json")
    public GlobalApiResponse<List<MeatCategory>> getData() {
        List<MeatCategory> categories = categoryService.getAll();
        return GlobalApiResponse
                .<List<MeatCategory>>builder()
                .data(categories)
                .statusCode(200)
                .message("Data retrieved successfully!")
                .build();
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody CategoryPojo categoryPojo) {
        if (!categoryService.existsById(id.intValue())) {
            return new ResponseEntity<>("Category id" + id + " not found", HttpStatus.NOT_FOUND);
        } else {
            categoryService.updateData(id, categoryPojo);

        }
        return ResponseEntity.ok("Category with ID " + id + " updated successfully");
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody CategoryPojo categoryPojo) {
        // Add validation or logging here if necessary
        if (categoryPojo.getId() == null) {
            // Handle the missing student_id case
            return ResponseEntity.badRequest().body("Customer Id ID is required");
        }
        categoryService.saveData(categoryPojo);
        return ResponseEntity.ok("Notices saved successfully");
    }
    @GetMapping("/get/{id}")
    public Optional<MeatCategory> getData(@PathVariable Integer id) {
        System.out.println("Hello");
        return categoryService.findById(id.longValue());
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        this.categoryService.deleteById(id.longValue());
    }
}
