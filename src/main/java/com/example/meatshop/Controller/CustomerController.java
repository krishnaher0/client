package com.example.meatshop.Controller;

import com.example.meatshop.Entity.Customer;
import com.example.meatshop.Pojo.CustomerPojo;
import com.example.meatshop.Service.CustomerService;
import com.example.meatshop.Shared.GlobalApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@ResponseBody
@RequiredArgsConstructor

@RestController
@RequestMapping("/customers")

public class CustomerController {
    private final CustomerService customerService;
    @GetMapping(value = "/get", produces = "application/json")
    public GlobalApiResponse<List<Customer>> getData() {
        List<Customer> customers = customerService.getAll();
        return GlobalApiResponse
                .<List<Customer>>builder()
                .data(customers)
                .statusCode(200)
                .message("Data retrieved successfully!")
                .build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody CustomerPojo customerPojo) {
        if (!customerService.existsById(id.intValue())) {
            return new ResponseEntity<>("Customer id" + id + " not found", HttpStatus.NOT_FOUND);
        } else {
            customerService.updateCustomerData(id, customerPojo);

        }
        return ResponseEntity.ok("Student with ID " + id + " updated successfully");
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody CustomerPojo customerPojo) {
        // Add validation or logging here if necessary

        customerService.addCustomer(customerPojo);
        return ResponseEntity.ok("Notices saved successfully");
    }
    @GetMapping("/get/{id}")
    public Optional<Customer> getData(@PathVariable Integer id) {
        System.out.println("Hello");
        return customerService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        this.customerService.deleteById(id);
    }
}
