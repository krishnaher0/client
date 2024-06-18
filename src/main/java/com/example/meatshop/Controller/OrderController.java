//package com.example.meatshop.Controller;
//
//import com.example.meatshop.Pojo.OrderPojo;
//import com.example.meatshop.Service.OrderService;
//import com.example.meatshop.Shared.GlobalApiResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//@ResponseBody
//@RequiredArgsConstructor
//
//@RestController
//@RequestMapping("/orders")
//
//public class OrderController {
//    private final OrderService orderService;
//    @GetMapping(value = "/get", produces = "application/json")
//    public GlobalApiResponse<List<Order>> getData() {
//        List<Order> order = orderService.getAll();
//        return GlobalApiResponse
//                .<List<Order>>builder()
//                .data(order)
//                .statusCode(200)
//                .message("Data retrieved successfully!")
//                .build();
//    }
//
//
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody OrderPojo orderPojo) {
//        if (!orderService.existsById(id.intValue())) {
//            return new ResponseEntity<>("Customer id" + id + " not found", HttpStatus.NOT_FOUND);
//        } else {
//            orderService.updateData(id, orderPojo);
//
//        }
//        return ResponseEntity.ok("Student with ID " + id + " updated successfully");
//    }
//
//    @PostMapping("/save")
//    public ResponseEntity<?> save(@RequestBody OrderPojo orderPojo) {
//        // Add validation or logging here if necessary
//
//        orderService.saveData(orderPojo);
//        return ResponseEntity.ok("Notices saved successfully");
//    }
//    @GetMapping("/get/{id}")
//    public Optional<Order> getData(@PathVariable Integer id) {
//        System.out.println("Hello");
//        return orderService.findById(id.longValue());
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void delete(@PathVariable Integer id) {
//        this.orderService.deleteById(id.longValue());
//    }
//}
