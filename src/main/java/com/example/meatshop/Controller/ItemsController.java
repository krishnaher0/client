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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    @GetMapping("/count")
    public GlobalApiResponse<Long> getItemsCount() {
        return GlobalApiResponse.<Long>builder()
                .data(itemService.ItemCount())
                .statusCode(200)
                .message("Total home count retrieved successfully!")
                .build();
    }

    @PutMapping(value = "/update/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public GlobalApiResponse<Items> updateData(@PathVariable Integer id,
                                                      @RequestPart("items") Items itemsDetails,
                                                      @RequestPart(value = "image", required = false) MultipartFile image) {
        try {
            itemService.updateData(Long.valueOf(id), itemsDetails, image);
            Items updatedHome = itemService.findById(Long.valueOf(id)).orElse(null);
            return GlobalApiResponse.<Items>builder()
                    .data(updatedHome)
                    .statusCode(200)
                    .message("Destination updated successfully!")
                    .build();
        } catch (IOException e) {
            return GlobalApiResponse.<Items>builder()
                    .statusCode(500)
                    .message("Failed to process image!")
                    .build();
        }
    }

    @PostMapping(value="/save",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public GlobalApiResponse<Items> createDestination(@RequestPart("items")Items items,
                                                             @RequestPart("image") MultipartFile image) {
        try{
            itemService.addProducts(items,image);
            return GlobalApiResponse.<Items>builder()
                    .data(items)
                    .statusCode(201)
                    .message("Home created successfully!")
                    .build();
        } catch (IOException e) {
            return GlobalApiResponse.<Items>builder()
                    .statusCode(500)
                    .message("Failed to process image!")
                    .build();
        }
    }
    @GetMapping("/get/{id}")
    public GlobalApiResponse<Items> getData(@PathVariable Long id) {
        Optional<Items> destinations = itemService.findById(id);
        if (destinations.isPresent()) {
            return GlobalApiResponse.<Items>builder()
                    .data(destinations.get())
                    .statusCode(200)
                    .message("Building retrieved successfully!")
                    .build();
        } else {
            return GlobalApiResponse.<Items>builder()
                    .statusCode(404)
                    .message("Building not found!")
                    .build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public GlobalApiResponse<Void> delete(@PathVariable Long id) {
        if (!itemService.existsById(id.intValue())) {
            return GlobalApiResponse.<Void>builder()
                    .statusCode(404)
                    .message("Ground with ID " + id + " not found")
                    .build();
        }

        itemService.deleteById(id);

        return GlobalApiResponse.<Void>builder()
                .statusCode(200)
                .message("destination with ID " + id + " deleted successfully")
                .build();
    }
    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getHomeImage(@PathVariable Integer id) {
        try {
            byte[] imageData = itemService.getProductImage(id.longValue());
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(imageData);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
