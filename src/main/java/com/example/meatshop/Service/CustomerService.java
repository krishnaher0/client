package com.example.meatshop.Service;

import com.example.meatshop.Entity.Customer;
import com.example.meatshop.Pojo.CustomerPojo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CustomerService {
    void addCustomer(CustomerPojo customerPojo);

    void deleteById(Integer id);

    List<Customer> getAll();
    void updateCustomerData(Integer id,CustomerPojo customerPojo);

    Optional<Customer> findById(Integer id);
    boolean existsById(Integer id);
}
