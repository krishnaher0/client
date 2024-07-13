package com.example.meatshop.Controller;

import com.example.meatshop.Entity.Customer;
import com.example.meatshop.Entity.Role;
import com.example.meatshop.Pojo.AuthResponsePojo;
import com.example.meatshop.Pojo.CustomerPojo;
import com.example.meatshop.Repo.CustomerRepo;
import com.example.meatshop.Repo.RoleRepository;
import com.example.meatshop.security.JwtGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final CustomerRepo customerRepo;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtGenerator jwtGenerator;

    public AuthController(AuthenticationManager authenticationManager, CustomerRepo customerRepo, RoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.customerRepo = customerRepo;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }

@PostMapping("/login")
public ResponseEntity<AuthResponsePojo> login(@RequestBody CustomerPojo loginPojo) {
    try {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginPojo.getUsername(), loginPojo.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        System.out.println("Generated Token: " + token); // Check if token is generated correctly
        return new ResponseEntity<>(new AuthResponsePojo(token), HttpStatus.OK);
    } catch (AuthenticationException e) {
        e.printStackTrace(); // Log the specific authentication error
        return new ResponseEntity<>(new AuthResponsePojo(null), HttpStatus.UNAUTHORIZED);
    }
}

    @PostMapping("/register/user")
    public ResponseEntity<String> registerUser(@RequestBody CustomerPojo registerPojo) {
        if (customerRepo.existsByUsername(registerPojo.getUsername())) {
            return new ResponseEntity<>("Username is taken", HttpStatus.BAD_REQUEST);
        }

        Customer user = new Customer();
        user.setCustomerId(registerPojo.getCustomerId());
        user.setUsername(registerPojo.getUsername());
        user.setPassword(passwordEncoder.encode(registerPojo.getPassword()));
        user.setAddress(registerPojo.getAddress());
        user.setEmail(registerPojo.getEmail());
        user.setContactNo(registerPojo.getContactNo());
        user.setCustomerName(registerPojo.getCustomerName());

        Optional<Role> role = roleRepository.findByName("USER");
        if (role.isPresent()) {
            user.setRoles(Collections.singletonList(role.get()));
        } else {
            return new ResponseEntity<>("Role not found", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        customerRepo.save(user);
        return new ResponseEntity<>("USER registered successfully", HttpStatus.OK);
    }



    @PostMapping("/register/admin")
    public ResponseEntity<String> register(@RequestBody CustomerPojo registerPojo){
        if(customerRepo.existsByUsername(registerPojo.getUsername())){
            return new ResponseEntity<>("Username is taken", HttpStatus.BAD_REQUEST);
        }

        Customer user = new Customer();
        user.setCustomerId(registerPojo.getCustomerId());
        user.setUsername(registerPojo.getUsername());
        user.setPassword(passwordEncoder.encode(registerPojo.getPassword()));
        user.setAddress(registerPojo.getAddress());
        user.setEmail(registerPojo.getEmail());
        user.setContactNo(registerPojo.getContactNo());
        user.setCustomerName(registerPojo.getCustomerName());


        Optional<Role> role = roleRepository.findByName("ADMIN");
        if(role.isPresent()) {
            user.setRoles(Collections.singletonList(role.get()));
        } else {
            return new ResponseEntity<>("Role not found", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        customerRepo.save(user);
        return new ResponseEntity<>("ADMIN registered successfully", HttpStatus.OK);
    }
//
//    @PostMapping("/update/password/{username}")
//    public ResponseEntity<String> updatePassword(@PathVariable String username, @RequestBody String newPassword) {
//        // Find the user by username
//        Optional<Customer> optionalUser = customerRepo.findByUsername(username);
//
//        if (optionalUser.isEmpty()) {
//            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
//        }
//
//        // Update password
//        Customer user = optionalUser.get();
//        user.setPassword(passwordEncoder.encode(newPassword));
//        customerRepo.save(user);
//
//        return new ResponseEntity<>("Password updated successfully", HttpStatus.OK);
//    }
//
//    @PostMapping("/authenticate")
//    public ResponseEntity<String> authenticate(@RequestBody CustomerPojo request) {
//        try {
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
//            );
//            String token = jwtGenerator.generateToken(authentication);
//            return ResponseEntity.ok(token); // Return token as part of the response body
//        } catch (AuthenticationException e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // Return 401 if authentication fails
//        }
//    }
//
//
//    @GetMapping("/secured")
//    public ResponseEntity<String> securedEndpoint(@RequestHeader("Authorization") String token) {
//        if (!jwtGenerator.validateToken(token)) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid or expired token");
//        }
//
//        String username = jwtGenerator.getUsernameFromJwt(token);
//        // Use username for secure endpoint logic
//
//        return ResponseEntity.ok("Hello, " + username + "! This is a secured endpoint.");
//    }
}
