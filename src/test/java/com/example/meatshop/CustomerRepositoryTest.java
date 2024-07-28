package com.example.meatshop;

import com.example.meatshop.Entity.Customer;
import com.example.meatshop.Entity.Role;
import com.example.meatshop.Repo.CustomerRepo;
import com.example.meatshop.Repo.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest

public class CustomerRepositoryTest {
    @Autowired
    private CustomerRepo customerRepo;



    @Autowired
    private RoleRepository roleRepository;


    @Test
    public void saveCustomerTest() {
        // Ensure the role "USER" exists in the database
        Optional<Role> role = roleRepository.findByName("USER");

        Customer user = new Customer();
        user.setCustomerName("Rita Kafle");
        user.setAddress("Bhaktapur");
        user.setUsername("hero123");
        user.setContactNo("98877637");
        user.setPassword("12345678");

        if (role.isPresent()) {
            user.setRoles(Collections.singletonList(role.get()));
        }

        Customer savedCustomer = customerRepo.save(user);

        assertNotNull(savedCustomer.getCustomerId(), "Customer ID should not be null");
        assertEquals("Rita Kafle", savedCustomer.getCustomerName(), "Customer name should match");
        assertEquals("Bhaktapur", savedCustomer.getAddress(), "Customer address should match");
        assertEquals("98877637", savedCustomer.getContactNo(), "Customer contact number should match");
        assertEquals("hero123", savedCustomer.getUsername(), "Customer username should match");

    }

    @Test
    public void getAllCustomerTest() {
        // Ensure the role "USER" exists in the database
        Optional<Role> role = roleRepository.findByName("USER");

        // Create and save some customers
        Customer user1 = new Customer();
        user1.setCustomerName("Rita Kafle");
        user1.setAddress("Bhaktapur");
        user1.setUsername("hero123");
        user1.setContactNo("98877637");
        user1.setPassword("12345678");

        Customer user2 = new Customer();
        user2.setCustomerName("Sita Shrestha");
        user2.setAddress("Kathmandu");
        user2.setUsername("hero456");
        user2.setContactNo("98765432");
        user2.setPassword("password123");

        if (role.isPresent()) {
            user1.setRoles(Collections.singletonList(role.get()));
            user2.setRoles(Collections.singletonList(role.get()));
        }

        customerRepo.save(user1);
        customerRepo.save(user2);

        // Fetch all customers
        List<Customer> customers = customerRepo.findAll();

        // Verify the fetched list
        assertNotNull(customers, "Customers list should not be null");
        assertEquals(2, customers.size(), "Customers list size should be 2");

        // Verify the details of each customer
        Customer fetchedUser1 = customers.stream().filter(c -> c.getUsername().equals("hero123")).findFirst().orElse(null);
        Customer fetchedUser2 = customers.stream().filter(c -> c.getUsername().equals("hero456")).findFirst().orElse(null);

        assertNotNull(fetchedUser1, "Fetched user1 should not be null");
        assertEquals("Rita Kafle", fetchedUser1.getCustomerName(), "Customer name should match");
        assertEquals("Bhaktapur", fetchedUser1.getAddress(), "Customer address should match");
        assertEquals("98877637", fetchedUser1.getContactNo(), "Customer contact number should match");

        assertNotNull(fetchedUser2, "Fetched user2 should not be null");
        assertEquals("Sita Shrestha", fetchedUser2.getCustomerName(), "Customer name should match");
        assertEquals("Kathmandu", fetchedUser2.getAddress(), "Customer address should match");
        assertEquals("98765432", fetchedUser2.getContactNo(), "Customer contact number should match");
    }
}
