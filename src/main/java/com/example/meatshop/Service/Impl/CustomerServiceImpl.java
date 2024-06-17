package com.example.meatshop.Service.Impl;

import com.example.meatshop.Entity.Customer;
import com.example.meatshop.Entity.MeatCategory;
import com.example.meatshop.Pojo.CategoryPojo;
import com.example.meatshop.Pojo.CustomerPojo;
import com.example.meatshop.Repo.CustomerRepo;
import com.example.meatshop.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service



public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo customerRepo;
    @Override
    public void addCustomer(CustomerPojo customerPojo) {
        Customer customer=new Customer();
        customer.setCustomerId(customerPojo.getCustomerId());
        customer.setCustomerName(customerPojo.getCustomerName());
        customer.setEmail(customerPojo.getEmail());
        customer.setAddress(customerPojo.getAddress());
        customer.setContactNo(customerPojo.getContactNo());
        customerRepo.save(customer);
    }

    @Override
    public void deleteById(Integer id) {
        customerRepo.deleteById(id);

    }

    public void updateCustomerData(Integer id, CustomerPojo customerPojo) {
        Optional<Customer> customerOptional = customerRepo.findById(id);
        if (customerOptional.isPresent()) {
            Customer existingCustomer = customerOptional.get();

            updateCustomer(existingCustomer, customerPojo);
            customerRepo.save(existingCustomer);
        } else {

            throw new IllegalArgumentException("Student with ID " + id + " not found");
        }
    }
    private void updateCustomer(Customer existingCustomer, CustomerPojo customerPojo) {
        if (existingCustomer.getCustomerId() != null) {
            existingCustomer.setCustomerId(customerPojo.getCustomerId());
            existingCustomer.setCustomerName(customerPojo.getCustomerName());
            existingCustomer.setEmail(customerPojo.getEmail());
            existingCustomer.setAddress(customerPojo.getAddress());
            existingCustomer.setContactNo(customerPojo.getContactNo());
        }
        System.out.println("Null id which is a required field");

    }


    @Override
    public List<Customer> getAll() {
        return customerRepo.findAll();
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return customerRepo.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
       return customerRepo.existsById(id.intValue());
    }
}
