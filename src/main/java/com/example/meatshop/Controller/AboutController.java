package com.example.meatshop.Controller;

import com.example.meatshop.Pojo.AboutPojo;
import com.example.meatshop.Service.AboutService;
import com.example.meatshop.Shared.GlobalApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/about")
public class AboutController {

    private final AboutService aboutService;

    @Autowired
    public AboutController(AboutService aboutService) {
        this.aboutService = aboutService;
    }

    @PostMapping
    public ResponseEntity<GlobalApiResponse<Void>> createAbout(@RequestBody AboutPojo aboutPojo) {
        aboutService.createAbout(aboutPojo);
        GlobalApiResponse<Void> response = new GlobalApiResponse<>("About created successfully", HttpStatus.CREATED.value(), null);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Void>> updateAbout(@PathVariable Integer id, @RequestBody AboutPojo aboutPojo) {
        aboutService.updateAbout(id, aboutPojo);
        GlobalApiResponse<Void> response = new GlobalApiResponse<>("About updated successfully", HttpStatus.OK.value(), null);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<Void>> deleteAbout(@PathVariable Integer id) {
        aboutService.deleteAbout(id);
        GlobalApiResponse<Void> response = new GlobalApiResponse<>("About deleted successfully", HttpStatus.NO_CONTENT.value(), null);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalApiResponse<AboutPojo>> getAbout(@PathVariable Integer id) {
        AboutPojo aboutPojo = aboutService.getAbout(id);
        GlobalApiResponse<AboutPojo> response = new GlobalApiResponse<>("About retrieved successfully", HttpStatus.OK.value(), aboutPojo);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<GlobalApiResponse<List<AboutPojo>>> getAllAbout() {
        List<AboutPojo> aboutList = aboutService.getAllAbout();
        GlobalApiResponse<List<AboutPojo>> response = new GlobalApiResponse<>("All about entries retrieved successfully", HttpStatus.OK.value(), aboutList);
        return ResponseEntity.ok(response);
    }
}
