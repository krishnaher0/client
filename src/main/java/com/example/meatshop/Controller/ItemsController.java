package com.example.meatshop.Controller;

import com.example.meatshop.Entity.Customer;
import com.example.meatshop.Entity.Items;
import com.example.meatshop.Pojo.CustomerPojo;
import com.example.meatshop.Pojo.ItemsPojo;
import com.example.meatshop.Service.CustomerService;
import com.example.meatshop.Service.ItemService;
import com.example.meatshop.Shared.GlobalApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@RestController
@RequestMapping("/items")

public class ItemsController {
    private final ItemService itemService;
    @GetMapping(value = "/get", produces = "application/json")
    public GlobalApiResponse<List<Items>> getData() {
        List<Items> items = itemService.getAll();
        return GlobalApiResponse
                .<List<Items>>builder()
                .data(items)
                .statusCode(200)
                .message("Data retrieved successfully!")
                .build();
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody ItemsPojo itemsPojo) {
        if (!itemService.existsById(id.intValue())) {
            return new ResponseEntity<>("Customer id" + id + " not found", HttpStatus.NOT_FOUND);
        } else {
            itemService.updateData(id, itemsPojo);

        }
        return ResponseEntity.ok("Student with ID " + id + " updated successfully");
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ItemsPojo itemsPojo) {
        // Add validation or logging here if necessary
        if (itemsPojo.getId() == null) {
            // Handle the missing student_id case
            return ResponseEntity.badRequest().body("Customer Id ID is required");
        }
        itemService.saveData(itemsPojo);
        return ResponseEntity.ok("Notices saved successfully");
    }
    @GetMapping("/get/{id}")
    public Optional<Items> getData(@PathVariable Integer id) {
        System.out.println("Hello");
        return itemService.findById(id.longValue());
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        this.itemService.deleteById(id.longValue());
    }
}
