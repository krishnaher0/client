package com.example.meatshop.Service.Impl;

import com.example.meatshop.Entity.Items;
import com.example.meatshop.Entity.ProductCart;
import com.example.meatshop.Pojo.ItemsPojo;
import com.example.meatshop.Pojo.ProductCartPojo;
import com.example.meatshop.Repo.ProductCartRepo;
import com.example.meatshop.Service.ProductCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service

public class ProductCartImpl implements ProductCartService {
    private final ProductCartRepo productCartRepo;
    @Override
    public void saveData(ProductCartPojo productCartPojo) {
        ProductCart productCart=new ProductCart();
      productCart.setProductName(productCartPojo.getProductName());

    }

    @Override
    public List<ProductCart> getAll() {
        return productCartRepo.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        productCartRepo.deleteById(id.intValue());

    }

    @Override
    public Optional<ProductCart> findById(Long id) {
        return productCartRepo.findById(id.intValue());
    }

    public void updateProductCart(Integer id, ProductCartPojo productCartPojo) {
        Optional<ProductCart> productCartOptional = productCartRepo.findById(id);
        if (productCartOptional.isPresent()) {
            ProductCart existingItems = productCartOptional.get();

            updateCart(existingItems, productCartPojo);
            productCartRepo.save(existingItems);
        } else {

            throw new IllegalArgumentException("Items with ID " + id + " not found");
        }
    }
    private void updateCart(ProductCart existingProductCart, ProductCartPojo productCartPojo) {
        if (productCartPojo.getId()!= null) {
            existingProductCart.setProductName(productCartPojo.getProductName());
            existingProductCart.setId(productCartPojo.getId());

        }
        throw new IllegalArgumentException("Items with ID " +" not found");


    }

    @Override
    public boolean existsById(Integer id) {
        return productCartRepo.existsById(id.intValue());
    }
}
