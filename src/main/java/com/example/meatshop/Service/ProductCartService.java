package com.example.meatshop.Service;

import com.example.meatshop.Entity.ProductCart;
import com.example.meatshop.Pojo.ProductCartPojo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public interface ProductCartService {
    void saveData(ProductCartPojo studentPojo);
    List<ProductCart> getAll();
    void deleteById(Integer id);
    Optional<ProductCart> findById(Long id);
    void updateProductCart(Integer id, ProductCartPojo productCartPojo);
    boolean existsById(Integer id);
}
