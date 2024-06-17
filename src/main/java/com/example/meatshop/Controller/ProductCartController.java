package com.example.meatshop.Controller;

import com.example.meatshop.Entity.Customer;
import com.example.meatshop.Entity.ProductCart;
import com.example.meatshop.Pojo.CustomerPojo;
import com.example.meatshop.Pojo.ProductCartPojo;
import com.example.meatshop.Service.CustomerService;
import com.example.meatshop.Service.ProductCartService;
import com.example.meatshop.Shared.GlobalApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@RestController
@RequestMapping("/cart")

public class ProductCartController {
    private final ProductCartService productCartService;
    @GetMapping(value = "/get", produces = "application/json")
    public GlobalApiResponse<List<ProductCart>> getData() {
        List<ProductCart> productCarts = productCartService.getAll();
        return GlobalApiResponse
                .<List<ProductCart>>builder()
                .data(productCarts)
                .statusCode(200)
                .message("Data retrieved successfully!")
                .build();
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody ProductCartPojo productCartPojo) {
        if (!productCartService.existsById(id.intValue())) {
            return new ResponseEntity<>("cart id" + id + " not found", HttpStatus.NOT_FOUND);
        } else {
            productCartService.updateProductCart(id, productCartPojo);

        }
        return ResponseEntity.ok("cart with ID " + id + " updated successfully");
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProductCartPojo productCartPojo) {
        // Add validation or logging here if necessary
        if (productCartPojo.getId() == null) {
            // Handle the missing student_id case
            return ResponseEntity.badRequest().body("Customer Id ID is required");
        }
        productCartService.saveData(productCartPojo);
        return ResponseEntity.ok("Notices saved successfully");
    }
    @GetMapping("/get/{id}")
    public Optional<ProductCart> getData(@PathVariable Integer id) {
        System.out.println("Hello");
        return productCartService.findById(id.longValue());
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        this.productCartService.deleteById(id);
    }
}
